package model;
import java.util.*;

/**
 * 
 */
public class ValidatorVO {

    /**
     * Default constructor
     */
    public ValidatorVO() {
    }




    /**
     * @param float
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
    public void ValidarSocioProtector(String CUIT) {
        // TODO implement here
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