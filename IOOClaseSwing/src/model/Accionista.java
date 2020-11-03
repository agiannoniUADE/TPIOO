package model;

import java.util.*;

/**
 * 
 */
public class Accionista {

  public Accionista(int id, String cuit, String razonSocial, float porcentaje) {
    this.id = id;
    this.cuit = cuit;
    this.razonSocial = razonSocial;
    this.porcentaje = porcentaje;
  }

  /**
     * Default constructor
     */
    public Accionista() {
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
    public float porcentaje;


    /**
     * @return
     */
    public int getId() {

        return id;
    }

    /**
     * @return
     */
    public String getCuit() {

        return cuit;
    }

    /**
     * @return
     */
    public String getRazonSocial() {

        return razonSocial;
    }

    /**
     * @param value
     */
    public void setRazonSocial(String value) {

      this.razonSocial = value;
    }

    /**
     * @return
     */
    public float getPorcentaje() {

        return porcentaje;
    }

}