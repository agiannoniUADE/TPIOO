package Controllers;

import DAO.GenericDAO;
import DAO.OpeacionT1Dao;
import DAO.OpeacionT2Dao;
import DAO.OpeacionT3Dao;
import model.*;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class OperacionController {

    SocioController socioController = new SocioController();
    TipoOperacionController tipoOperacionController = new TipoOperacionController();
    SGRController sgrController = new SGRController();
    OpeacionT1Dao opeacionT1Dao = new OpeacionT1Dao();
    OpeacionT2Dao opeacionT2Dao = new OpeacionT2Dao();
    OpeacionT3Dao opeacionT3Dao = new OpeacionT3Dao();

    public OperacionController() throws Exception {

    }

    public void AgregarOperacion(Operacion operacion, String cuitSocio) throws Exception {

        if (operacion.getSubtipoOperacion() == null) {
            throw new Exception("No se indico el tipo de operacion deseada.");
        }

        SocioParticipe socio = socioController.getSocioParticipe(cuitSocio);

        if (socio == null) {
            throw new Exception("No pudo encontrarse un socio con ese cuit.");
        }
        if (socio.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO) {
            throw new Exception("Un postulante a socio no puede realizar operaciones.");
        }

        operacion.setSocioParticipe(socio);

        int lastId = opeacionT1Dao.getLastInsertId() + 1;
        operacion.setId(lastId);
        opeacionT1Dao.save(operacion);
    }



    public void emitirCertificado(int idOperacion) throws Exception {
        Operacion operacion = (Operacion) opeacionT1Dao.search(idOperacion);

        if (operacion == null) {
            throw new Exception("la operacion no existe.");
        }

        if (operacion.getEstado() != EstadoOperacion.INGRESADO) {
            throw new Exception("la operacion debe estar en estado ingresado.");
        }

        SocioParticipe socio = operacion.getSocioParticipe();

        if (socio.getLineaDeCredito().getFechaVigencia().compareTo(LocalDate.now())<0){
            throw new Exception("La linea de credito del socio se encuentra vencida.");
        }

        if (socio.getLineaDeCredito() != null &&
            !socio.getLineaDeCredito().getTipoOperacion().equals(operacion.getSubtipoOperacion().getTipoOperacion())) {
            throw new Exception("La linea de credito del Socio no permite este tipo de operaciones.");
        }
        if (socio.getMontoLineaDeCredito() == 0) {
            throw new Exception("El socio indicado no dispone de saldo en su linea de credito.");
        }

        if (!ValidatorVO.ValidarMontoOperacion(sgrController, operacion.getMonto())) {
            throw new Exception("Ningun socio puede operar por mas de 10% del fondo de la SGR");
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
    }


    public void pasarAMonetizada(int idOperacion) throws Exception {

        float tasaComision;
        float monto;
        Operacion operacion = (Operacion) opeacionT1Dao.search(idOperacion);

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
        if(operacion.getSubtipoOperacion().getTipoOperacion().getId() == 1)
        {
            Tipo1 tipo1 = (Tipo1)opeacionT1Dao.search(idOperacion, Tipo1.class);
            monto = tipo1.getMonto();
        }
        Comision comision = new Comision(monto, tasaComision);
        operacion.setComision(comision);
        operacion.setEstado(EstadoOperacion.MONETIZADO);

        opeacionT1Dao.update(operacion);
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
    public void getOperacionPorSocio(int id) {
        // TODO implement here
    }

    public float getComisionPorFecha(LocalDate fecha) throws Exception {
        float comision = 0;
        List<Tipo1> lista = (List<Tipo1>) opeacionT1Dao.getAll()
            .stream()
            .filter((x -> ((Tipo1) x).getEstado() == EstadoOperacion.MONETIZADO))
            .collect(Collectors.toList());

        for (Tipo1 item : lista) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String parametro = format.format(fecha);
                String fechaCalculo = format.format(item.getComision().getFechaCalculocomision());
                if (parametro.equals(fechaCalculo)) {
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
    public void getOperacionesPorTipo(int tipoId) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void getRiesgoVivoPorSocio(int id) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void getRiesgovivoYTotalUtilizadoPorSocio(int id) {
        // TODO implement here
    }
}