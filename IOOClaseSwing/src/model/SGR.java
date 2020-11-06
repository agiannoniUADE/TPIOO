package model;
import java.util.*;

/**
 * 
 */
public class SGR {

  public SGR(int id, String razonSocial) {
    this.id = id;
    this.razonSocial = razonSocial;
  }

  /**
     * Default constructor
     */
    private SGR() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String razonSocial;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  /**
     * 
     */
    private int getRiesgoVivo() {
        // TODO implement here
      return 2;
    }

    /**
     * 
     */
    private void calcularFondoDeRiego() {
        // TODO implement here
    }

    /**
     * 
     */
    private void getSocioParticipe() {
        // TODO implement here
    }

    /**
     * @param id
     */
    private int getAporte(int id) {
        // TODO implement here
        return 0;
    }

    /**
     * @param id
     */
    private int getSocio(int id) {
        // TODO implement here
        return  0;
    }

}