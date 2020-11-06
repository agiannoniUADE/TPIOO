package model;
import java.util.*;

/**
 * 
 */
public class  TipoOperacion {

  public TipoOperacion(int id, String descripcion, float comision) {
    this.id = id;
    this.descripcion = descripcion;
    this.comision = comision;
  }

  /**
     * Default constructor
     */
    public TipoOperacion() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String descripcion;

    /**
     * 
     */
    private float comision;


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

  public float getComision() {
    return comision;
  }

  public void setComision(float comision) {
    this.comision = comision;
  }
}