package model;

import java.util.*;

/**
 * 
 */
public class Accionista {

  private Accionista(int id, String cuit, String razonSocial, float porcentaje) {
    this.id = id;
    this.cuit = cuit;
    this.razonSocial = razonSocial;
    this.porcentaje = porcentaje;
  }

  /**
     * Default constructor
     */
    private Accionista() {
    }

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


    /**
     * @return
     */
    private int getId() {

        return id;
    }

    /**
     * @return
     */
    private String getCuit() {

        return cuit;
    }

    /**
     * @return
     */
    private String getRazonSocial() {

        return razonSocial;
    }

    /**
     * @param value
     */
    private void setRazonSocial(String value) {

      this.razonSocial = value;
    }

    /**
     * @return
     */
    private float getPorcentaje() {

        return porcentaje;
    }

}