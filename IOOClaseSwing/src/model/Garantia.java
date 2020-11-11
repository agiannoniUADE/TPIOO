package model;

import java.util.*;

/**
 *
 */
public class Garantia {

    public Garantia(int nroDeGarantia, String responsable, float monto) {
        this.nroDeGarantia = nroDeGarantia;
        this.responsable = responsable;
        this.monto = monto;
    }

    /**
     * Default constructor
     */
    public Garantia() {
    }

    /**
     *
     */
    private int nroDeGarantia;

    /**
     *
     */
    private String responsable;

    /**
     *
     */
    private float monto;


    /**
     *
     */
    private void Operation1() {
        // TODO implement here
    }

    public int getNroDeGarantia() {
        return nroDeGarantia;
    }

    public void setNroDeGarantia(int nroDeGarantia) {
        this.nroDeGarantia = nroDeGarantia;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}