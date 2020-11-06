package model;
import java.util.*;

/**
 * 
 */
public class  TipoDocumentoRegistro {

  public TipoDocumentoRegistro(int id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  /**
     * Default constructor
     */
    public TipoDocumentoRegistro() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String nombre;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}