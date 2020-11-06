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
  public int id;

  /**
   *
   */
  public String nombre;

  /**
   *
   */
  public String usuario;

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

  public void setEstado(EstadoDocumentoRegistro estado) {
    this.estado = estado;
  }

}