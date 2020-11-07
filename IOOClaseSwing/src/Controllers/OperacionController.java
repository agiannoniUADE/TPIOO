package Controllers;

import DAO.OpeacionDao;
import model.*;

import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 */
public class OperacionController {

    SocioController socioController = new SocioController();
    TipoOperacionController tipoOperacionController = new TipoOperacionController();
    SGRController sgrController = new SGRController();
    OpeacionDao opeacionDao = new OpeacionDao();

    public OperacionController() throws Exception {

    }

    public void AgregarOperacion(Tipo1 operacion, String cuitSocio) throws Exception {
        SocioParticipe socio = socioController.getSocioParticipe(cuitSocio);

        if (socio == null) {
            throw new Exception("No pudo encontrarse un socio con ese cuit.");
        }
        if (socio.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO) {
            throw new Exception("Un postulante a socio no puede realizar operaciones.");
        }

        if(operacion.getSubtipoOperacion()==null)
        {
            throw new Exception("No se indico el tipo de operacion deseada.");
        }


        operacion.setSocioParticipe(socio);

        opeacionDao.save(operacion);
    }

    public void emitirCertificado(int idOperacion) throws Exception {
        Tipo1 operacion =(Tipo1) opeacionDao.search(idOperacion);

        SocioParticipe socio = operacion.getSocioParticipe();

        if (socio.getLineaDeCredito() != null && socio.getLineaDeCredito().getTipoOperacion().getId() != 1) {
            throw new Exception("La linea de credito del Socio no permite las operaciones de tipo 1");
        }
        if (socio.getMontoLineaDeCredito() == 0) {
            throw new Exception("El socio indicado no dispone de saldo en su linea de credito.");
        }

        if (!ValidatorVO.ValidarMontoOperacion(sgrController, operacion.getMonto())) {
            throw new Exception("Ningun socio puede operar por mas de 10% del fondo de la SGR");
        }

        if(socio.getLineaDeCredito().getMontoAsignado() < operacion.getMonto()){
            throw new Exception("El socio no dispone de fundos suficientes para realizar esta operacion.");
        }

        operacion.setEstado(EstadoOperacion.CERTIFICADO_EMITIDO);

        //usar certificado para agregar a la operacions

    }

    /**
     * @param id
     */
    public void getOperacionPorSocio(int id) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public float getComisionPorDiaria(int id) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param fecha
     * @param IdTipoOperacion
     */
    public void getComisionPorFecha(Date fecha, int IdTipoOperacion) {
        // TODO implement here
    }

    /**
     * @param fecha
     */
    public void getOperacionesPorFecha(Date fecha) {
        // TODO implement here
    }

    /**
     * @param idSocio
     * @param fechaDesde
     * @param fechaHasta
     */
    public void getOperacionesMonetizadasPorSocio(int idSocio, Date fechaDesde, Date fechaHasta) {
        // TODO implement here
    }

    /**
     * @param tamanioEmpresa
     * @param fechaDesde
     * @param fechaHasta
     */
    public void getPromedioDescuentoyTotalOperadoPorTamanioEmpresaPorFecha(String tamanioEmpresa, Date fechaDesde, Date fechaHasta) {
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