package model;
import java.util.*;

/**
 * 
 */
public class SubtipoOperacion {

    /**
     * Default constructor
     */
    public SubtipoOperacion() {
    }

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    public String descripcion;

    public TipoOperacion tipoOperacion;

    /**
     * @param id
     */
    public void getTipoOperacion(int id) {
        // TODO implement here
    }

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
        SubtipoOperacion that = (SubtipoOperacion) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, tipoOperacion);
    }
}