package model;
import java.util.*;

/**
 * 
 */
public class Tipo2 extends Operacion {


  public Tipo2(int id, float monto, Date fecha, EstadoOperacion estado, Date fechaVencimiento, int id1, String banco, float monto1, float comision) {
    super(id, monto, fecha, estado, fechaVencimiento);
    this.id = id1;
    this.banco = banco;
    this.monto = monto1;
    this.comision = comision;
  }

  public Tipo2(int id, String banco, float monto, float comision) {
    this.id = id;
    this.banco = banco;
    this.monto = monto;
    this.comision = comision;
  }

  /**
     * Default constructor
     */
    public Tipo2() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String banco;

    /**
     * 
     */
    private float monto;

    /**
     * 
     */
    private float comision;


  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  public String getBanco() {
    return banco;
  }

  public void setBanco(String banco) {
    this.banco = banco;
  }

  @Override
  public float getMonto() {
    return monto;
  }

  @Override
  public void setMonto(float monto) {
    this.monto = monto;
  }

  public float getComision() {
    return comision;
  }

  public void setComision(float comision) {
    this.comision = comision;
  }
}