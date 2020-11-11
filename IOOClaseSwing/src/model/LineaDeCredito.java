package model;
import java.time.LocalDate;

/**
 * 
 */
public class LineaDeCredito {

  public LineaDeCredito(int id, LocalDate fechaVigencia, float montoAsignado) {
    this.id = id;
    this.fechaVigencia = fechaVigencia;
    this.montoAsignado = montoAsignado;
  }

  /**
     * Default constructor
     */
    public LineaDeCredito() {
    }

    public LineaDeCredito(LocalDate fechaVigencia, float montoAsignado, TipoOperacion tipoOperacion) {
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
    private LocalDate fechaVigencia;

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



  public LocalDate getFechaVigencia() {
    return fechaVigencia;
  }

  public void setFechaVigencia(LocalDate fechaVigencia) {
    this.fechaVigencia = fechaVigencia;
  }

  public float getMontoAsignado() {
    return montoAsignado;
  }

  public void setMontoAsignado(float montoAsignado) {
    this.montoAsignado = montoAsignado;
  }
}