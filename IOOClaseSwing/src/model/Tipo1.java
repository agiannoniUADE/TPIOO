package model;
import java.util.*;

/**
 * 
 */
public class Tipo1 extends Operacion {

  public Tipo1(int id, float monto, Date fecha, EstadoOperacion estado, Date fechaVencimiento, int id1, String cuitDelFirmante, float comision, Date fechaDeCobro, float tasaDeDescuento) {
    super(id, monto, fecha, estado, fechaVencimiento);
    this.id = id1;
    this.cuitDelFirmante = cuitDelFirmante;
    this.comision = comision;
    this.fechaDeCobro = fechaDeCobro;
    this.tasaDeDescuento = tasaDeDescuento;
  }

  public Tipo1(int id, String cuitDelFirmante, float comision, Date fechaDeCobro, float tasaDeDescuento) {
    this.id = id;
    this.cuitDelFirmante = cuitDelFirmante;
    this.comision = comision;
    this.fechaDeCobro = fechaDeCobro;
    this.tasaDeDescuento = tasaDeDescuento;
  }

  /**
     * Default constructor
     */
    public Tipo1() {
    }

    /**
     * 
     */
    private int id;

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


  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

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
        // TODO implement here
      return true;
    }


    /**
     * @return
     */
    public String getCuitDelFirmante() {
        // TODO implement here
        return cuitDelFirmante;
    }

    public void setCuitDelFirmante(String cuitDelFirmante) {
        // TODO implement here
      this.cuitDelFirmante = cuitDelFirmante;
    }

    /**
     * @return
     */
    public Date getFechaDeCobro() {
        // TODO implement here
        return fechaDeCobro;
    }

    /**
     * @param value
     */
    public void setFechaDeCobro(Date fechaDeCobro) {
        // TODO implement here
      this.fechaDeCobro=fechaDeCobro;
    }

}