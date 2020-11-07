package model;
import java.util.*;

/**
 * 
 */
public class Operacion {


  public Operacion(int id, float monto, Date fecha, EstadoOperacion estado, Date fechaVencimiento) {
    this.id = id;
    this.monto = monto;
    this.fecha = fecha;
    this.estado = estado;
    this.fechaVencimiento = fechaVencimiento;
  }

  /**
     * Default constructor
     */
    public Operacion() {
    }

    public Operacion(float monto, Date fechaIngreso, Date fechaVencimiento) {
        this.monto = monto;
        this.fecha = fechaIngreso;
        this.estado = EstadoOperacion.INGRESADO;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private float monto;

    /**
     * 
     */
    private Date fecha;

    /**
     * 
     */
    private EstadoOperacion estado;

    /**
     * 
     */
    private Date fechaVencimiento;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public float getMonto() {
    return monto;
  }

  public void setMonto(float monto) {
    this.monto = monto;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public EstadoOperacion getEstado() {
    return estado;
  }

  public void setEstado(EstadoOperacion estado) {
    this.estado = estado;
  }

  public Date getFechaVencimiento() {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(Date fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
  }

  /**
     * 
     */
    private void Operation1() {
        // TODO implement here
    }

    /**
     * 
     */
    private void getGarantia() {
        // TODO implement here
    }

    /**
     * 
     */
    private void Operation2() {
        // TODO implement here
    }

    /**
     * 
     */
    private void calcularComision() {
        // TODO implement here
    }



    /**
     * @param nroDegarantia
     */
    private void getGarantia(int nroDegarantia) {
        // TODO implement here
    }

    /**
     * @param id
     */
    private void getOperacion(int id) {
        // TODO implement here
    }


    /**
     * 
     */
    private float getComision() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * 
     */
    private void getIdOperacion() {
        // TODO implement here
    }


    /**
     * 
     */
    private void getIdSocio() {
        // TODO implement here
    }


    /**
     * @return
     */
    private Desembolso getDesembolso() {
        // TODO implement here
        return null;
    }

}