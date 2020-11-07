package model;

import com.sun.istack.internal.Nullable;

import java.util.*;

/**
 *
 */
public class Tipo1 extends Operacion {

    public Tipo1(float monto, Date fecha, Date fechaVencimiento, String cuitDelFirmante, float comision, Date fechaDeCobro, Float tasaDeDescuento) {
        super(monto, fecha, fechaVencimiento);
        this.cuitDelFirmante = cuitDelFirmante;
        this.comision = comision;
        this.fechaDeCobro = fechaDeCobro;
        this.tasaDeDescuento = tasaDeDescuento != null ? tasaDeDescuento.floatValue() : 0f;
    }

    public Tipo1(float monto, Date fecha, Date fechaVencimiento, String cuitDelFirmante, float comision, Date fechaDeCobro) {
        new Tipo1(monto, fecha, fechaVencimiento, cuitDelFirmante, comision, fechaDeCobro, null);
    }

    /**
     * Default constructor
     */
    public Tipo1() {
    }

    /**
     * 
     */
    private String cuitDelFirmante;

    /**
     * 
     */
    private float comision;

    /**
     * 
     */
    private Date fechaDeCobro;

    /**
     * 
     */
    private float tasaDeDescuento;

  public float getComision() {
    return comision;
  }

  public void setComision(float comision) {
    this.comision = comision;
  }

  public float getTasaDeDescuento() {
    return tasaDeDescuento;
  }

  public void setTasaDeDescuento(float tasaDeDescuento) {
    this.tasaDeDescuento = tasaDeDescuento;
  }

  /**
     * 
     */
  public boolean tieneTasadeDescuento() {
      return true;
  }
    /**
     * @return
     */
    public String getCuitDelFirmante() {
        return cuitDelFirmante;
    }

    public void setCuitDelFirmante(String cuitDelFirmante) {
      this.cuitDelFirmante = cuitDelFirmante;
    }

    /**
     * @return
     */
    public Date getFechaDeCobro() {
        return fechaDeCobro;
    }

    /**
     */
    public void setFechaDeCobro(Date fechaDeCobro) {
      this.fechaDeCobro=fechaDeCobro;
    }

}