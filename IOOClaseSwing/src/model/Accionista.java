package model;

import java.util.*;

/**
 *
 */
public class Accionista {

    /**
     * Default constructor
     */
    public Accionista() {
    }

    public Accionista(String cuit, String razonSocial, int porcentaje) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.porcentaje = porcentaje;
    }

    /**
     *
     */
    public int id;

    /**
     *
     */
    public String cuit;


    /**
     *
     */
    public String razonSocial;

    /**
     *
     */
    public int porcentaje;


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
    public String getCuit() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getRazonSocial() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setRazonSocial(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public float getPorcentaje() {
        // TODO implement here
        return 0.0f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accionista that = (Accionista) o;
        return Objects.equals(cuit, that.cuit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuit);
    }
}