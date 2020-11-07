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


    public TipoOperacion tipoOperacion;
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
    public void getTipoOperacion(int id) {
        // TODO implement here
    }


    /**
     * 
     */
    public void getComision() {
        // TODO implement here
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubtipoOperacion that = (SubtipoOperacion) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, tipoOperacion);
    }
}