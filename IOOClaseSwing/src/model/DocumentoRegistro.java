package model;

import java.util.*;

/**
 *
 */
public class DocumentoRegistro {


    /**
     * Default constructor
     */
    public DocumentoRegistro() {
    }

    public DocumentoRegistro(String nombre, String usuario, boolean obligatorio, TipoDocumento tipoDocumento) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.obligatorio = obligatorio;
        this.tipoDocumento = tipoDocumento;
        this.estado = EstadoDocumentoRegistro.INGRESADO;
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
    private String usuario;
    /**
     *
     */

    private boolean obligatorio;

    private TipoDocumento tipoDocumento;

    private EstadoDocumentoRegistro estado;

    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }


    public TipoDocumento getTipoDocumentoRegistro() {
        return tipoDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public EstadoDocumentoRegistro getEstado() {
        return estado;
    }

    public static void setEstado(EstadoDocumentoRegistro estado) {
        estado = estado;
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


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}