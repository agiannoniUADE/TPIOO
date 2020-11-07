package model;
import java.util.*;

/**
 * 
 */
public class TipoOperacion {

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


    /**
     * 
     */
    public void getDescripcion() {
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
        TipoOperacion that = (TipoOperacion) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, comision, subtipoOperacion);
    }
}