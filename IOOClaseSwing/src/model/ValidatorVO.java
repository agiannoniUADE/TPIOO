package model;

import Controllers.OperacionController;
import Controllers.SGRController;
import Controllers.SocioController;
import Test.SGRControllerTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class ValidatorVO {

    OperacionController operacionController;
    SocioController socioController;

    /**
     * Default constructor
     */
    public ValidatorVO(SocioController socioController) throws Exception {
    }

    /**
     * @param
     */
    public static boolean ValidarMontoOperacion(float monto) throws Exception {
        SGR sgr = SGRController.getInstance().GetSGR();

        //calculo 5% del fondo de riesgo
        float porcentaje = sgr.calcularFondoDeRiego() * 0.05f;

        return monto < porcentaje;
    }

    /**
     * @param socioId
     */
    public static Boolean ValidarMoraMenorAl10deLineaAsignada(int socioId) throws Exception {
        SocioController socioController = SocioController.getInstance();
        OperacionController operacionController = OperacionController.getInstance();
        SocioParticipe socio = socioController.getSocioParticipe(socioId);
        float montoMora = 0;
        float montoPermitido = socio.getLineaDeCredito().getMontoAsignado() * 0.1f;

        List<Operacion> listaOperaciones = operacionController.getOperacionPorSocio(socioId);

        for (Operacion operacion : listaOperaciones) {
            if (operacion.estaEnMora()) {
                montoMora += operacion.getMora();
            }
        }

        return montoPermitido > montoMora;
    }

    /**
     * @param CUIT
     */
    public static boolean ValidarSocioProtector(String CUIT) throws Exception {
        List<SocioParticipe> lista = SocioController.getInstance().getSociosParticipe();
        for (SocioParticipe socio : lista) {
            if (socio.getAccionista(CUIT) != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param cuit
     * @param monto
     */
    public static boolean validarChequesMismoFirmante(String cuit, float monto) throws Exception {
        SGR sgr = SGRController.getInstance().GetSGR();
        OperacionController operacionController = OperacionController.getInstance();
        //el permitido es el 5% del FDR
        float fondoRiesgoPermitido = sgr.calcularFondoDeRiego() * 0.5f;

        double montoMismoFirmante = operacionController.getOperacionesCheque()
            .stream()
            .filter(x -> x.getCuitDelFirmante().equals(cuit))
            .map(x -> x.getMonto())
            .collect(Collectors.summingDouble(Float::doubleValue));

        return fondoRiesgoPermitido > montoMismoFirmante;
    }

    /**
     * @param CUIT
     * @param monto
     */
    public static boolean validarMontoOperacionParaSociosQueTienenMismoAccionista(String CUIT, float monto) throws Exception {

        float riesgoVivoAcumulado = 0;
        SocioController socioController = SocioController.getInstance();
        OperacionController operacionController = OperacionController.getInstance();

        List<SocioParticipe> socios = socioController.getSociosQuetienenLosMismosAccionistas(CUIT);

        for (SocioParticipe s : socios) {
            riesgoVivoAcumulado += operacionController.getRiesgoVivoPorSocio(s.getId());
        }

        float porcentaje = riesgoVivoAcumulado * 0.05f;

        return monto < porcentaje;
    }

}