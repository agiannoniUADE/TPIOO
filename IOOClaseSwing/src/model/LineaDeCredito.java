package model;
import java.util.*;

/**
 * 
 */
public class  LineaDeCredito {

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