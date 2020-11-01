package Controllers;
import java.util.*;

/**
 * 
 */
public class OperacionController {

    /**
     * Default constructor
     */
    public OperacionController() {
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