package model;
import java.util.*;

/**
 * 
 */
public class  Contragarantia {

    /**
     * Default constructor
     */
    public Contragarantia() {
    }

    /**
     * 
     */
    private int id;

    public Contragarantia(String tipo, float monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    /**
     * 
     */
    private String tipo;

    /**
     * 
     */
    private float monto;




    public int getId() {
        return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }



}