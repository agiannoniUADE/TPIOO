package model;
import java.util.*;

/**
 * 
 */
public class Contragarantia {

    /**
     * Default constructor
     */
    public Contragarantia() {
    }

    /**
     * 
     */
    public int id;

    public Contragarantia(String tipo, float monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    /**
     * 
     */
    public String tipo;

    /**
     * 
     */
    public float monto;




    /**
     * @return
     */
    public int getId() {
        // TODO implement here
        return 0;
    }

    /**
     * @param value
     */
    public void setId(int value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getTipo() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setTipo(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public float getMonto() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param value
     */
    public void setMonto(float value) {
        // TODO implement here
    }

}