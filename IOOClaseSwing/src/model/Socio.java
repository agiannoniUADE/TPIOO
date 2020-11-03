package model;
import java.util.*;

/**
 * 
 */
public class Socio {

  /**
   *
   * */
  public Socio(String cuit, TipoSocio tipoSocio, String razonSocial, Date fechaInicioActividad,
               String actividadPrincipal, String direccion, String telefono, String email, String tamanioEmpresa) {
    this.cuit = cuit;
    this.tipoSocio = tipoSocio;
    this.razonSocial = razonSocial;
    this.fechaInicioActividad = fechaInicioActividad;
    this.actividadPrincipal = actividadPrincipal;
    this.direccion = direccion;
    this.telefono = telefono;
    this.email = email;
    this.tamanioEmpresa = tamanioEmpresa;
  }

  /**
   *
   */
  public Socio() {

  }

  /**
     * 
     */
    public int id;

    /**
     * 
     */
    public String cuit;

    /**
     * 
     */
    public TipoSocio tipoSocio;

    /**
     *
     */
    public String estado;

    /**
     * 
     */
    public String razonSocial;

    /**
     * 
     */
    public Date fechaInicioActividad;

    /**
     * 
     */
    public String actividadPrincipal;

    /**
     * 
     */
    public String direccion;

    /**
     * 
     */
    public String telefono;

    /**
     * 
     */
    public String email;

    /**
     * 
     */
    public int accion;

    /**
     * 
     */
    public String tamanioEmpresa;


    /**
     * @param accion
     */
    public void venderAcciones(int accion) {
        // TODO implement here
    }

    /**
     * @param accion
     */
    public void comprarAcciones(int accion) {
        // TODO implement here
    }

    /**
     * @param accion
     */
    public void getAccionista(int accion) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void getDocumentoRegistro(int id) {
        // TODO implement here
    }

    /**
     * 
     */
    public void getIdSocio() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getTamanioEmpresa() {
        // TODO implement here
    }

    /**
     * @return
     */
    public TipoSocio getTipoSocio() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setTipoSocio(TipoSocio value) {
        // TODO implement here
    }

    /**
     * 
     */
    public void getAccionistas() {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getCuit() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setCuit(String value) {
        // TODO implement here
    }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}