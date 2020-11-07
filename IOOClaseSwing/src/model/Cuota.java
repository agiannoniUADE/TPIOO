package model;
import java.util.*;

/**
 * 
 */
public class  Cuota {

    /**
     * Default constructor
     */
    public Cuota() {
    }

    /**
     * 
     */
    private int cuotaId;

    /**
     * 
     */
    private float monto;

    /**
     * 
     */
    private String estado;

    /**
     * 
     */
    private int numeroCuota;


  public int getCuotaId() {
    return cuotaId;
  }

  public void setCuotaId(int cuotaId) {
    this.cuotaId = cuotaId;
  }

  public float getMonto() {
    return monto;
  }

  public void setMonto(float monto) {
    this.monto = monto;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public int getNumeroCuota() {
    return numeroCuota;
  }

  public void setNumeroCuota(int numeroCuota) {
    this.numeroCuota = numeroCuota;
  }
}