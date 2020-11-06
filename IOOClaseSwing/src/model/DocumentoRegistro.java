package model;
import java.util.*;

/**
 * 
 */
public class DocumentoRegistro {


  public DocumentoRegistro(int id, String nombre, String estado, String usuario) {
    this.id = id;
    this.nombre = nombre;
    this.estado = estado;
    this.usuario = usuario;
  }

  /**
     * Default constructor
     */
    public DocumentoRegistro() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String estado;

    /**
     * 
     */
    private String usuario;



    /**
     * @param id
     */
    public void getTipoDocumentoRegistro(int  id) {
        // TODO implement here
    }

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

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
}