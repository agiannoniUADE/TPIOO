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
    this.estado = accion == 0
        ? EstadoSocio.POSTULANTE_A_SOCIO
        : EstadoSocio.SOCIO_PLENO;
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
      this.estado = accion == 0
          ? EstadoSocio.POSTULANTE_A_SOCIO
          : EstadoSocio.SOCIO_PLENO;
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
  private EstadoSocio estado;

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
      if (a.cuit.equals(cuit)) {
        return a;
      }
    }
    return null;
  }


  /**
   * @param accion
   */
  public Boolean venderAcciones(int accion) {
    if(accion > this.accion)
        return false;
    this.accion -= accion;
    return true;
  }

  /**
   * @param accion
   */
  public void comprarAcciones(int accion) {
    this.accion += accion;
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

    public EstadoSocio getEstado() {
        return estado;
    }

    public void setEstado(EstadoSocio estado) {
        this.estado = estado;
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