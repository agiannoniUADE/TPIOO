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

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    public String cuit;

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

}