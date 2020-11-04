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
    private int id;

    /**
     * 
     */
    private String cuit;

    /**
     * 
     */
    private TipoSocio tipoSocio;

    /**
     *
     */
    private String estado;

    /**
     * 
     */
    private String razonSocial;

    /**
     * 
     */
    private Date fechaInicioActividad;

    /**
     * 
     */
    private String actividadPrincipal;

    /**
     * 
     */
    private String direccion;

    /**
     * 
     */
    private String telefono;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private int accion;

    /**
     * 
     */
    private String tamanioEmpresa;



     * @param accion
     */
    private void venderAcciones(int accion) {
        // TODO implement here
    }

    /**
     * @param accion
     */
    private void comprarAcciones(int accion) {
        // TODO implement here
    }

    /**
     * @param accion
     */
    private void getAccionista(int accion) {
        // TODO implement here
    }

    /**
     * @param id
     */
    private void getDocumentoRegistro(int id) {
        // TODO implement here
    }

    /**
     * 
     */
    private void getIdSocio() {
        // TODO implement here
    }

    /**
     * 
     */
    private void getTamanioEmpresa() {
        // TODO implement here
    }

    /**
     * @return
     */
    private TipoSocio getTipoSocio() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    private void setTipoSocio(TipoSocio value) {
        // TODO implement here
    }

    /**
     * 
     */
    private void getAccionistas() {
        // TODO implement here
    }

    /**
     * @return
     */
    private String getCuit() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    private void setCuit(String value) {
        // TODO implement here
    }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Socio socio = (Socio) o;
    return id == socio.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}