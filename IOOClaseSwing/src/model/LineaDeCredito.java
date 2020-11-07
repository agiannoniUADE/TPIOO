package model;
import java.util.*;

/**
 * 
 */
public class LineaDeCredito {

  public LineaDeCredito(int id, Date fechaVigencia, float montoAsignado) {
    this.id = id;
    this.fechaVigencia = fechaVigencia;
    this.montoAsignado = montoAsignado;
  }

  /**
     * Default constructor
     */
    public LineaDeCredito() {
    }

    public LineaDeCredito(Date fechaVigencia, float montoAsignado, TipoOperacion tipoOperacion) {
        this.fechaVigencia = fechaVigencia;
        this.montoAsignado = montoAsignado;
        this.tipoOperacion = tipoOperacion;
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private Date fechaVigencia;

    /**
     * 
     */
    private float montoAsignado;

    private TipoOperacion tipoOperacion;


    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }



    public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }



  public Date getFechaVigencia() {
    return fechaVigencia;
  }

  public void setFechaVigencia(Date fechaVigencia) {
    this.fechaVigencia = fechaVigencia;
  }

  public float getMontoAsignado() {
    return montoAsignado;
  }

  public void setMontoAsignado(float montoAsignado) {
    this.montoAsignado = montoAsignado;
  }
}