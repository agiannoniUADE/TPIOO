package model;

import java.util.*;

/**
 *
 */
public class Desembolso {

    public Desembolso(int id, float montoAdeudado) {
        this.id = id;
        this.montoAdeudado = montoAdeudado;
    }

    /**
     * Default constructor
     */
    public Desembolso() {
    }

    /**
     *
     */
    private int id;

    /**
     *
     */
    private float montoAdeudado;

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    private int idOperacion;


    /**
     * @param id
     */
    public void getMonto(int id) {
        // TODO implement here
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontoAdeudado() {
        return montoAdeudado;
    }

    public void setMontoAdeudado(float montoAdeudado) {
        this.montoAdeudado = montoAdeudado;
    }
}