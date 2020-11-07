package model;
import java.util.*;

/**
 * 
 */
public class LineaDeCredito {

    /**
     * Default constructor
     */
    public LineaDeCredito() {
    }

    public LineaDeCredito(Date fechaVigencia, float montoAsignado, TipoOperacion tipoOperacion) {
        this.fechaVigencia = fechaVigencia;
        this.montoAsignado = montoAsignado;
        this.tipoOperacion = tipoOperacion;
    }

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    public Date fechaVigencia;

    /**
     * 
     */
    public float montoAsignado;

    public TipoOperacion tipoOperacion;

    /**
     * @return
     */
    public int getId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Date getFechaVigencia() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public float getMontoAsignado() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param value
     */
    public void setMontoAsignado(float value) {
        // TODO implement here
    }


}