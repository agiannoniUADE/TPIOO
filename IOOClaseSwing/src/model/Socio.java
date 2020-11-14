package model;

import java.time.LocalDate;
import java.util.*;

/**
 *
 */
public class Socio {

    /**
     * ctor socio
     */
    public Socio(String cuit, TipoSocio tipoSocio, String razonSocial, LocalDate fechaInicioActividad,
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
    public Socio(String cuit, TipoSocio tipoSocio, String razonSocial, LocalDate fechaInicioActividad,
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
    private EstadoSocio estado;

    /**
     *
     */
    private String razonSocial;

    /**
     *
     */
    private LocalDate fechaInicioActividad;

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
            if (a.getCuit().equals(cuit)) {
                return a;
            }
        }
        return null;
    }


    /**
     * @param accion
     */
    public Boolean venderAcciones(int accion) {
        if (accion > this.accion)
            return false;
        this.accion -= accion;
        return true;
    }


    /**
     * @param accion
     */
    public void getAccionista(int accion) {
        // TODO implement here
    }

    public List<Accionista> getAccionistas() {
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

    public EstadoSocio getEstado() {
        return estado;
    }

    public void setEstado(EstadoSocio estado) {
        this.estado = estado;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public LocalDate getFechaInicioActividad() {
        return fechaInicioActividad;
    }

    public void setFechaInicioActividad(LocalDate fechaInicioActividad) {
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

    /**
     * @param accion
     */
    public boolean comprarAcciones(int accion) {
        acciones += accion;
        return true;
    }

    public DocumentoRegistro getDocumentoRegistro(int id) {
        for (DocumentoRegistro doc : this.documentosRegistro) {
            if (doc.equals(id)) {
                return doc;
            }
        }
        return null;
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
