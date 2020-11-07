package model;
import java.util.*;

/**
 * 
 */
public class Socio {




  /**
   *
   */
  public Socio(String cuit, TipoSocio tipoSocio, String razonSocial, Date fechaInicioActividad,
               String actividadPrincipal, String direccion, String telefono, String email, String tamanioEmpresa,
               int acciones, List<Accionista> accionistas, List<DocumentoRegistro> documentos) {
    this.cuit = cuit;
    this.tipoSocio = tipoSocio;
    this.razonSocial = razonSocial;
    this.fechaInicioActividad = fechaInicioActividad;
    this.actividadPrincipal = actividadPrincipal;
    this.direccion = direccion;
    this.telefono = telefono;
    this.email = email;
    this.tamanioEmpresa = tamanioEmpresa;
    this.acciones = acciones;
    this.accionistas = accionistas;
    this.documentosRegistro = documentos;
  }

  /**
   *
   */
  public Socio() {

  }


  private int acciones;
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

  private List<Accionista> accionistas;

  private List<DocumentoRegistro> documentosRegistro;



  public List getAccionistas() {
    return accionistas;
  }

  public void setAccionistas(List accionistas) {
    this.accionistas = accionistas;
  }

  public int getAcciones() {
    return acciones;
  }

  public void setAcciones(int acciones) {
    this.acciones = acciones;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCuit() {
    return cuit;
  }

  public void setCuit(String cuit) {
    this.cuit = cuit;
  }

  public TipoSocio getTipoSocio() {
    return tipoSocio;
  }

  public void setTipoSocio(TipoSocio tipoSocio) {
    this.tipoSocio = tipoSocio;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public Date getFechaInicioActividad() {
    return fechaInicioActividad;
  }

  public void setFechaInicioActividad(Date fechaInicioActividad) {
    this.fechaInicioActividad = fechaInicioActividad;
  }

  public String getActividadPrincipal() {
    return actividadPrincipal;
  }

  public void setActividadPrincipal(String actividadPrincipal) {
    this.actividadPrincipal = actividadPrincipal;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAccion() {
    return accion;
  }

  public void setAccion(int accion) {
    this.accion = accion;
  }

  public String getTamanioEmpresa() {
    return tamanioEmpresa;
  }

  public void setTamanioEmpresa(String tamanioEmpresa) {
    this.tamanioEmpresa = tamanioEmpresa;
  }

  public Boolean venderAcciones(int accion) {
    if(accion > this.accion)
      return false;
    this.accion -= accion;
    return true;
  }

  /**
   * @param accion
   */
  public boolean comprarAcciones(int accion) {
    acciones += accion;
    return true;
  }

  public void agregarDocumento(DocumentoRegistro obj) {
    this.documentosRegistro.add(obj);
  }

  public void quitarDocumentoRegistro(DocumentoRegistro obj) {
    this.documentosRegistro.remove(obj);
  }

  public void agregarAccionista(Accionista obj)
  {
    this.accionistas.add(obj);
  }

  public void removeAccionista(Accionista obj)
  {
    this.accionistas.remove(obj);
  }


  public Accionista getAccionista(String cuit) {
    for (Accionista ax : this.accionistas) {
      //mati, si esto lo hago ax.cuit me dice que cuit es privado y no puede ingresar git
      if (ax.getCuit().equals(cuit)) {
        return ax;
      }
    }
    return null;
  }

  public DocumentoRegistro getDocumentoRegistro(int id){
    for (DocumentoRegistro doc : this.documentosRegistro){
      if (doc.equals(id)){
        return doc;
      }
    }
    return null;
  }





  @Override
    public boolean equals (Object o){
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Socio socio = (Socio) o;
      return id == socio.id;
    }

    @Override
    public int hashCode () {
      return Objects.hash(id);
    }
  }
