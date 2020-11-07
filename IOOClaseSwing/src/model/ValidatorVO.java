package model;
import Controllers.SocioController;

import java.util.*;

/**
 * 
 */
public class ValidatorVO {

    /**
     * Default constructor
     */
    public ValidatorVO(SocioController socioController) {
    }

    /**
     * @param
     */
    private void ValidarMontoOperacion(float monto) {
        // TODO implement here
    }

    /**
     * @param socioId
     */
    public void ValidarMoraMenorAl10deLineaAsignada(int socioId) {
        // TODO implement here
    }

    /**
     * @param CUIT
     */
    public static boolean ValidarSocioProtector(SocioController controller, String CUIT) throws Exception {
        List<SocioParticipe> lista = controller.getSociosParticipe();
            for(SocioParticipe socio : lista) {
                if(socio.getAccionista(CUIT) != null){
                    return false;
                }
            }
        return true;
    }

    /**
     * @param cuit 
     * @param monto
     */
    public void validarChequesMismoFirmante(String cuit, float monto) {
        // TODO implement here
    }

    /**
     * @param CUIT 
     * @param monto
     */
    public void validarOperacionParaSociosQueTienenMismoAccionista(String CUIT,
                                                                   float monto) {
        // TODO implement here
    }

}