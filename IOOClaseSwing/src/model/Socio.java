package model;

import java.util.*;

/**
 *
 */
public class Socio {

  /**
   * ctor socio
   */
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
    this.documentosRegistro = new ArrayList<>();
    this.accionistas = new ArrayList<>();
  }

  /**
   * ctor con accionistas y documentos
   */
  public Socio(String cuit, TipoSocio tipoSocio, String razonSocial, Date fechaInicioActividad,
               String actividadPrincipal, String direccion, String telefono, String email, String tamanioEmpresa,
               List<Accionista> accionistas, List<DocumentoRegistro> documentos) {
    this.cuit = cuit;
    this.tipoSocio = tipoSocio;
    this.razonSocial = razonSocial;
    this.fechaInicioActividad = fechaInicioActividad;
    this.actividadPrincipal = actividadPrincipal;
    this.direccion = direccion;
    this.telefono = telefono;
    this.email = email;
    this.tamanioEmpresa = tamanioEmpresa;
    this.accionistas = accionistas;
    this.documentosRegistro = documentos;
  }

  /**
   * ctor por defecto
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

  private List<Accionista> accionistas;

  private List<DocumentoRegistro> documentosRegistro;

  public void agregarDocumento(DocumentoRegistro obj) {
    this.documentosRegistro.add(obj);
  }

  public void quitarDocumentoRegistro(DocumentoRegistro obj) {
    this.documentosRegistro.remove(obj);
  }

  public void agregarAccionista(Accionista obj) {
    this.accionistas.add(obj);
  }

  public void removeAccionista(Accionista obj) {
    this.accionistas.remove(obj);
  }

  public Accionista getAccionista(String cuit) {
    for (Accionista a : this.accionistas) {
      if (a.cuit == cuit) {
        return a;
      }
    }
    return null;
  }


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