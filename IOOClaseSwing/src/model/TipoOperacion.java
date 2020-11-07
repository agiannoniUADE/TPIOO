package model;
import java.util.*;

/**
 * 
 */
public class TipoOperacion {

  public TipoOperacion(int id, String descripcion, float comision) {
    this.id = id;
    this.descripcion = descripcion;
    this.comision = comision;
  }

  /**
     * Default constructor
     */
    public TipoOperacion() {
        subtipoOperacion = new ArrayList<>();
    }

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    public String descripcion;

    /**
     * 
     */
    public float comision;

    public List<SubtipoOperacion> subtipoOperacion;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoOperacion that = (TipoOperacion) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, comision, subtipoOperacion);
    }
  public void setComision(float comision) {
    this.comision = comision;
  }
}