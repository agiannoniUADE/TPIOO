package model;
import java.util.*;

/**
 * 
 */
public class SubtipoOperacion {

  public SubtipoOperacion(int id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
  }

  /**
     * Default constructor
     */
    public SubtipoOperacion() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String descripcion;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
     * @param id
     */
    private void getTipoOperacion(int  id) {
        // TODO implement here
    }


    /**
     * 
     */
    private void getComision() {
        // TODO implement here
    }

}