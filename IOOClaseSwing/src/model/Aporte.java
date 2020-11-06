
import java.util.*;

/**
 * 
 */
public class Aporte {


    /**
     * Default constructor
     */
    public Aporte() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private Date fechaInicio;

    /**
     * 
     */
    private float monto;

    /**
     * 
     */
    private Boolean estado;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public float getMonto() {
    return monto;
  }

  public void setMonto(float monto) {
    this.monto = monto;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }
}