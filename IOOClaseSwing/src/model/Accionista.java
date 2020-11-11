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

    public Accionista(int id, String cuit, String razonSocial, float porcentaje) {
        this.id = id;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.porcentaje = porcentaje;
    }

    /**
     * Default constructor
     */


    /**
     *
     */
    private int id;

    /**
     *
     */
    private String cuit;

    /**
     *
     */
    private String razonSocial;

    /**
     *
     */
    private float porcentaje;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
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