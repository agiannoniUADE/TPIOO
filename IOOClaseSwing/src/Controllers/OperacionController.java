package Controllers;

import DAO.OpeacionT1Dao;
import model.*;
import utils.Logger;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class OperacionController {

    SocioController socioController;
    TipoOperacionController tipoOperacionController;
    SGRController sgrController;
    OpeacionT1Dao opeacionT1Dao;


    static OperacionController instance;

    public static OperacionController getInstance() throws Exception {
        if (instance == null) {
            instance = new OperacionController();
        }
        return instance;
    }

    private OperacionController() throws Exception {
        socioController = SocioController.getInstance();
        sgrController = SGRController.getInstance();
        tipoOperacionController = TipoOperacionController.getInstance();
        opeacionT1Dao = new OpeacionT1Dao();
    }

    public void AgregarOperacion(Operacion operacion, String cuitSocio) throws Exception {

        if (operacion.getSubtipoOperacion() == null) {
            throw new Exception("No se indico el tipo de operacion deseada.");
        }

        if (operacion.getMonto() == 0) {
            throw new Exception("El monto de la operacion no puede ser nulo.");
        }

        SocioParticipe socio = socioController.getSocioParticipe(cuitSocio);

        if (socio == null) {
            throw new Exception("No pudo encontrarse un socio con ese cuit.");
        }
        if (socio.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO) {
            throw new Exception("Un postulante a socio no puede realizar operaciones.");
        }
        if (!ValidatorVO.ValidarMoraMenorAl10deLineaAsignada(socio.getId())) {
            throw new Exception("Un socio no puede tener operaciones por encima del 10% de la linea asignada.");
        }
        //si es del tipo 1 valido que el mismo firmante no acumule mas del 5% del FDR
        if (operacion.getSubtipoOperacion().getTipoOperacion().getId() == 1) {
            Tipo1 operacionTipo1 = (Tipo1) operacion;
            if (!ValidatorVO.validarChequesMismoFirmante(operacionTipo1.getCuitDelFirmante(), operacion.getMonto())) {
                throw new Exception("La SGR no puede recibir mas de 5% del FDR en cheques del mismo firmante.");
            }
        }
        operacion.setSocioParticipe(socio);

        int lastId = opeacionT1Dao.getLastInsertId() + 1;
        operacion.setId(lastId);
        opeacionT1Dao.save(operacion);
        Logger logger=Logger.getInstance();

        logger.log(operacion.getId(),TipoLog.OPERACIONES,EstadoOperacion.INGRESADO.toString(),EstadoOperacion.INGRESADO.toString(),LocalDate.now(),"usuario1");
    }


    public void emitirCertificado(int idOperacion) throws Exception {
        Operacion operacion = (Operacion) this.getOperacionSafely(idOperacion);

        if (operacion == null) {
            throw new Exception("la operacion no existe.");
        }

        if (operacion.getEstado() != EstadoOperacion.INGRESADO) {
            throw new Exception("la operacion debe estar en estado ingresado.");
        }

        SocioParticipe socio = operacion.getSocioParticipe();

        if (socio.getLineaDeCredito().getFechaVigencia().compareTo(LocalDate.now()) < 0) {
            throw new Exception("La linea de credito del socio se encuentra vencida.");
        }

        if (socio.getLineaDeCredito() != null &&
            !socio.getLineaDeCredito().getTipoOperacion().equals(operacion.getSubtipoOperacion().getTipoOperacion())) {
            throw new Exception("La linea de credito del Socio no permite este tipo de operaciones.");
        }
        if (socio.getMontoLineaDeCredito() == 0) {
            throw new Exception("El socio indicado no dispone de saldo en su linea de credito.");
        }

        if (!socioController.getSociosQuetienenLosMismosAccionistas(socio.getCuit()).isEmpty()) {
            if (!ValidatorVO.validarMontoOperacionParaSociosQueTienenMismoAccionista(socio.getCuit(), operacion.getMonto())) {
                throw new Exception("Ningun socio que comparte accionistas puede operar por mas de 5% de la suma de los riesgo vivos.");
            }
        } else {
            if (!ValidatorVO.ValidarMontoOperacion(operacion.getMonto())) {
                throw new Exception("Ningun socio puede operar por mas de 5% del fondo de la SGR");
            }
        }

        if (socio.getLineaDeCredito().getMontoAsignado() < operacion.getMonto()) {
            throw new Exception("El socio no dispone de fondos suficientes para realizar esta operacion.");
        }

        operacion.setEstado(EstadoOperacion.CERTIFICADO_EMITIDO);

        Random r = new Random();
        int certidicadoId = r.nextInt(999999);

        Certificado certificado = new Certificado(certidicadoId, operacion.getSocioParticipe().getRazonSocial());

        operacion.setCertificado(certificado);

        opeacionT1Dao.update(operacion);
    //cambio estado, ingresado a cert-emitido
        Logger logger=Logger.getInstance();

        logger.log(operacion.getId(),TipoLog.OPERACIONES,EstadoOperacion.INGRESADO.toString(),EstadoOperacion.CERTIFICADO_EMITIDO.toString(),LocalDate.now(),"usuario1");

    }


    public void pasarAMonetizada(int idOperacion) throws Exception {

        float tasaComision;
        float monto;
        Operacion operacion = (Operacion) this.getOperacionSafely(idOperacion);

        if (operacion == null) {
            throw new Exception("la operacion no existe.");
        }

        if (operacion.getEstado() != EstadoOperacion.CERTIFICADO_EMITIDO) {
            throw new Exception("la operacion debe estar en estado 'Con Certificado emitido'.");
        }

        if (operacion.getSocioParticipe().tieneComisionPreferencial()) {
            tasaComision = operacion.getSocioParticipe().getComisionPreferencial();
        } else {
            tasaComision = operacion.getSubtipoOperacion().getComision();
        }

        monto = operacion.getMonto();
        //Esto porque las operaciones de tipo 1 se le quita una comision por negociarlos antes de la fecha,
        if (operacion.getSubtipoOperacion().getTipoOperacion().getId() == 1) {
            Tipo1 tipo1 = (Tipo1) opeacionT1Dao.search(idOperacion, Tipo1.class);
            monto = tipo1.getMonto();
        }
        Comision comision = new Comision(monto, tasaComision);
        operacion.setComision(comision);
        operacion.setEstado(EstadoOperacion.MONETIZADO);

        opeacionT1Dao.update(operacion);

        Logger logger=Logger.getInstance();

        logger.log(operacion.getId(),TipoLog.OPERACIONES,EstadoOperacion.INGRESADO.toString(),EstadoOperacion.MONETIZADO.toString(),LocalDate.now(),"usuario1");
    }

    public void facturarComisiones() throws Exception {

        List<Operacion> lista = (List<Operacion>) opeacionT1Dao.getAll()
            .stream()
            .filter((x -> ((Operacion) x).getEstado() == EstadoOperacion.MONETIZADO))
            .collect(Collectors.toList());

        for (Operacion item : lista) {
            if (item.getComision().getEstadoComision() == EstadoComision.CALCULADA) {
                item.getComision().GenerarFactura(item.getSocioParticipe().getRazonSocial());
                item.getComision().setEstadoComision(EstadoComision.FACTURADA);
                opeacionT1Dao.update(item);
            }
        }
    }

    public Tipo1 buscarOperacion(int id) throws FileNotFoundException {
        return (Tipo1) opeacionT1Dao.search(id);
    }

    /**
     * @param id
     */
    public List<Operacion> getOperacionPorSocio(int id) throws Exception {
        return (List<Operacion>) opeacionT1Dao.getAll()
            .stream()
            .filter((x -> ((Operacion) x).getSocioParticipe().getId() == id))
            .collect(Collectors.toList());
    }

    /**
     * Total de comisiones calculadas en un día por operaciones de cheques presentadas en el Mercado Argentino de Valores
     *
     * @param fecha
     * @return
     * @throws Exception
     */
    public float getComisionDeChequesPorFecha(LocalDate fecha) throws Exception {
        float comision = 0;
        List<Operacion> lista = (List<Operacion>) opeacionT1Dao.getAll()
            .stream()
            .filter((x -> ((Operacion) x).getEstado() == EstadoOperacion.MONETIZADO &&
                ((Operacion) x).getSubtipoOperacion().getTipoOperacion().getId() == 1))
            .collect(Collectors.toList());

        for (Operacion item : lista) {
            if (fecha.compareTo(item.getComision().getFechaCalculocomision()) == 0) {
                comision += item.getComision().getMonto();
            }
        }
        return comision;
    }

    /**
     * @param fecha
     */
    public void getOperacionesPorFecha(LocalDate fecha) {
        // TODO implement here
    }

    /**
     * @param idSocio
     * @param fechaDesde
     * @param fechaHasta
     */
    public void getOperacionesMonetizadasPorSocio(int idSocio, LocalDate fechaDesde, LocalDate fechaHasta) {
        // TODO implement here
    }

    /**
     * @param tamanioEmpresa
     * @param fechaDesde
     * @param fechaHasta
     */
    public void getPromedioDescuentoyTotalOperadoPorTamanioEmpresaPorFecha(String tamanioEmpresa, LocalDate fechaDesde, LocalDate fechaHasta) {
        // TODO implement here
    }

    /**
     * @param tipoId
     */
    public List<Operacion> getOperacionesPorTipo(int tipoId) throws Exception {
        return (List<Operacion>) opeacionT1Dao.getAll()
            .stream()
            .filter(x -> ((Operacion) x).getSubtipoOperacion().getTipoOperacion().getId() == tipoId)
            .collect(Collectors.toList());
    }

    /**
     * Riesgo vivo por socio son todas las operaciones monetizadas no vencidas.
     */
    public float getRiesgoVivoPorSocio(int id) throws Exception {

        double riesgoVivo = 0;
        SocioParticipe socio = SocioController.getInstance().getSocioParticipe(id);
        int idOperacion = socio.getLineaDeCredito().getTipoOperacion().getId();

        //si es del tipo 3, necesitamos traer la lista parseada al tipo 3, para acceder a los metodos de cuotas.
        if (idOperacion == 3) {
            riesgoVivo = (double) opeacionT1Dao.getAll(Tipo3.class)
                .stream()
                .filter(x -> ((Tipo3) x).getEstado() == EstadoOperacion.MONETIZADO
                    && ((Tipo3) x).getFechaVencimiento().compareTo(LocalDate.now()) > 0
                    && ((Tipo3) x).getSocioParticipe().getId() == socio.getId()
                    && (((Tipo3) x).getSubtipoOperacion().getTipoOperacion().getId() == idOperacion))
                .map(x -> ((Tipo3) x).montoRestanteDePago())
                .collect(Collectors.summingDouble(Float::doubleValue));
        } else {
            riesgoVivo = (double) opeacionT1Dao.getAll()
                .stream()
                .filter(x -> ((Operacion) x).getEstado() == EstadoOperacion.MONETIZADO
                    && ((Operacion) x).getFechaVencimiento().compareTo(LocalDate.now()) > 0
                    && ((Operacion) x).getSocioParticipe().getId() == socio.getId()
                    && (((Operacion) x).getSubtipoOperacion().getTipoOperacion().getId() == idOperacion))
                .map(x -> ((Operacion) x).getMonto())
                .collect(Collectors.summingDouble(Float::doubleValue));
        }

        return (float) riesgoVivo;
    }


    /**
     * Las operaciones avaladas a nombre de un socio, en estado monetizadas en un período de tiempo
     */
    public List<Operacion> operacionesDeUnsocioPorEstado(String cuit, LocalDate inicio, LocalDate fin) throws Exception {
        Socio socio = SocioController.getInstance().getSocioByCuit(cuit);
        if (socio == null)
            throw new Exception("El socio no existe");
        return getOperacionPorSocio(socio.getId())
            .stream()
            .filter(x -> x.getEstado() == EstadoOperacion.MONETIZADO
                    && x.getFecha().compareTo(inicio) >= 0
                    && x.getFecha().compareTo(fin) <= 0)
            .collect(Collectors.toList());
    }

    /**
     * Valor promedio de la tasa de descuento de cheques y pagarés para un tipo de empresa (pequeña, mediana, grande), en un período de tiempo
     */
    public float getPromedioTasaDescuentoParaOperacionesChequeParaUntipoEmpresaPoFecha(String tamanoEmpresa, LocalDate inicio, LocalDate fin) throws Exception {
        double total = 0;
        List<Tipo1> lista = (List<Tipo1>) opeacionT1Dao.getAll(Tipo1.class)
            .stream()
            .filter(x -> ((Tipo1) x).getSubtipoOperacion().getTipoOperacion().getId() == 1
                && ((Tipo1) x).getSocioParticipe().getTamanioEmpresa().equals(tamanoEmpresa)
                && ((Tipo1) x).getFecha().compareTo(inicio) >= 0
                && ((Tipo1) x).getFecha().compareTo(fin) <= 0)
            .collect(Collectors.toList());

        if (lista != null) {
            total = lista.stream().map(x -> x.getTasaDeDescuento()).collect(Collectors.averagingDouble(a -> a.doubleValue()));
        }
        return (float) total;
    }

    /**
     * total operado de cheques y pagarés para un tipo de empresa (pequeña, mediana, grande), en un período de tiempo
     */
    public float getTotalOperadoenChequeParaUntipoEmpresaPorFecha(String tamanoEmpresa, LocalDate inicio, LocalDate fin) throws Exception {
        double total = 0;
        List<Tipo1> lista = (List<Tipo1>) opeacionT1Dao.getAll(Tipo1.class)
            .stream()
            .filter(x -> ((Tipo1) x).getSubtipoOperacion().getTipoOperacion().getId() == 1
                && ((Tipo1) x).getSocioParticipe().getTamanioEmpresa().equals(tamanoEmpresa)
                && ((Tipo1) x).getFecha().compareTo(inicio) >= 0
                && ((Tipo1) x).getFecha().compareTo(fin) <= 0)
            .collect(Collectors.toList());

        if (lista != null) {
            total = lista.stream().map(x -> x.getTasaDeDescuento()).collect(Collectors.summingDouble(a -> a.doubleValue()));
        }
        return (float) total;
    }

    /**
     * El utilizado de la línea son las operaciones con certificado emitido más el riesgo vivo del socio.
     */
    public float GetTotalUtilizadoDeLinea(String cuit) throws Exception {
        SocioParticipe socio = SocioController.getInstance().getSocioParticipe(cuit);
        int idOperacion = socio.getLineaDeCredito().getTipoOperacion().getId();

        double totalUtilizado = (double) opeacionT1Dao.getAll(Operacion.class)
            .stream()
            .filter(x -> ((Operacion) x).getEstado() == EstadoOperacion.MONETIZADO
                && ((Operacion) x).getSocioParticipe().getId() == socio.getId()
                && (((Operacion) x).getSubtipoOperacion().getTipoOperacion().getId() == idOperacion))
            .map(x -> ((Operacion) x).getMonto())
            .collect(Collectors.summingDouble(Float::doubleValue));

        double riesgovivo = this.getRiesgoVivoPorSocio(socio.getId());

        return (float) (riesgovivo + totalUtilizado);
    }


    public List<Tipo1> getOperacionesCheque() throws Exception {
        return (List<Tipo1>) opeacionT1Dao.getAll(Tipo1.class)
            .stream()
            .filter(x -> ((Tipo1) x).getSubtipoOperacion().getTipoOperacion().getId() == 1)
            .collect(Collectors.toList());
    }

    /**
     * hotfix al bug donde se perdia info en los cambios de estados.
     */
    public Operacion getOperacionSafely(int id) throws Exception {
        Operacion op = (Operacion) opeacionT1Dao.search(id);
        int tipoOperacion = op.getSubtipoOperacion().getTipoOperacion().getId();
        if (tipoOperacion == 1)
            return (Tipo1) opeacionT1Dao.search(id, Tipo1.class);
        if (tipoOperacion == 2)
            return (Tipo2) opeacionT1Dao.search(id, Tipo2.class);
        else
            return (Tipo3) opeacionT1Dao.search(id, Tipo3.class);
    }

    public void updateOperacion(Operacion op) throws Exception {
        opeacionT1Dao.update(op);
    }

    public void guardarDesembolso(int idOperacion, Desembolso desembolso) throws Exception {

        Operacion operacion = (Operacion) this.getOperacionSafely(idOperacion);

        operacion.setDesembolso(desembolso);

        opeacionT1Dao.update(operacion);
    }
}