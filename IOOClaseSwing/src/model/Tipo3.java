package model;
import java.util.*;

/**
 * 
 */
public class Tipo3 extends Operacion {

    /**
     * Default constructor
     */
    public Tipo3() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String entidad;

    /**
     * 
     */
    private float monto;

    /**
     * 
     */
    private float tasa;

    /**
     * 
     */
    private Date fechaDeAcreditacion;

    /**
     *
     */
    private int cantidadCuotas;

    /**
     * 
     */
    private String sistemaAmortizacion;

    /**
     * 
     */
    private float comision;

    /**
     * 
     */
    private Date fechaDeVencimiento;



    /**
     * @return
     */
    public int getId() {
        // TODO implement here
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }
    public String getEntidad() {
        // TODO implement here
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad=entidad;
    }

    public float getMonto() {
        // TODO implement here
        return monto;
    }

    public void setMonto(float monto) {
        this.monto=monto;
    }
    public float getTasa() {
        // TODO implement here
        return tasa;
    }

    public void setTasa(float tasa) {
        // TODO implement here
      this.tasa=tasa;
    }

    public Date getFechaDeAcreditacion() {
        // TODO implement here
        return fechaDeAcreditacion;
    }

    public void setFechaDeAcreditacion(Date fechaDeAcreditacion) {
        // TODO implement here
      this.fechaDeAcreditacion=fechaDeAcreditacion;
    }
    public int getCantidadCuotas() {
        // TODO implement here
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas=cantidadCuotas;
    }

    public String getSistemaAmortizacion() {
        // TODO implement here
        return sistemaAmortizacion;
    }

    public void setSistemaAmortizacion(String sistemaAmortizacion) {
        this.sistemaAmortizacion=sistemaAmortizacion;
    }

    public float getComision() {
        // TODO implement here
        return comision;
    }

    public void setComision(float comision) {
        this.comision=comision;
    }

    /**
     * @return
     */
    public Date getFechaDeVencimiento() {

        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento=fechaDeVencimiento;
    }

    /**
     * @return
     */
    public List<Cuota> getCuotas() {
        // TODO implement here

        return null;
    }

}