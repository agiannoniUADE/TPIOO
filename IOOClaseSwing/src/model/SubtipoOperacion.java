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

    public SubtipoOperacion() {
    }

    private int id;
    private String descripcion;
    private TipoOperacion tipoOperacion;


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

    public void getTipoOperacion(int id) {
        // TODO implement here
    }

    public float getComision() {
        return tipoOperacion.getComision();
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
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