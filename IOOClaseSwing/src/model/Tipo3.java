package model;

import java.util.*;

/**
 *
 */
public class Tipo3 extends Operacion {

    public Tipo3(float monto, Date fechaIngreso, Date fechaVencimiento, SubtipoOperacion subtipoOperacion, String entidad, float tasa, Date fechaDeAcreditacion, int cantidadCuotas, String sistemaAmortizacion) {
        super(monto, fechaIngreso, fechaVencimiento, subtipoOperacion);
        this.entidad = entidad;
        this.tasa = tasa;
        this.fechaDeAcreditacion = fechaDeAcreditacion;
        this.cantidadCuotas = cantidadCuotas;
        this.sistemaAmortizacion = sistemaAmortizacion;
        incicalizarCuotas(monto, fechaDeAcreditacion, cantidadCuotas);

    }


    /**
     * Default constructor
     */
    public Tipo3() {
    }

    /**
     *
     */
    private String entidad;

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

    private List<Cuota> cuotas;


    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public Date getFechaDeAcreditacion() {
        return fechaDeAcreditacion;
    }

    public void setFechaDeAcreditacion(Date fechaDeAcreditacion) {
        this.fechaDeAcreditacion = fechaDeAcreditacion;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public String getSistemaAmortizacion() {
        return sistemaAmortizacion;
    }

    public void setSistemaAmortizacion(String sistemaAmortizacion) {
        this.sistemaAmortizacion = sistemaAmortizacion;
    }

    /**
     * @return
     */
    public List<Cuota> getCuotas() {
        // TODO implement here

        return null;
    }

    private void incicalizarCuotas(float monto, Date fechaDeAcreditacion, int cantidadCuotas) {
       /* this.cuotas = new ArrayList<>();
        float montoCuota = monto / cantidadCuotas;
        for (int i = 1; i <= cantidadCuotas; i++) {
            new Cuota(i, montoCuota, EstadoCuotas.EN_FECHA, i);
            cuotas.add();
        }*/
    }
}