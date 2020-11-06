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
}