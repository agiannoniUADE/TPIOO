package model;

import java.util.*;

/**
 *
 */
public class Operacion {

    public Operacion() {
    }

    public Operacion(int id, float monto, Date fecha, EstadoOperacion estado, Date fechaVencimiento) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.estado = estado;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Operacion(float monto, Date fechaIngreso, Date fechaVencimiento) {
        this.monto = monto;
        this.fecha = fechaIngreso;
        this.estado = EstadoOperacion.INGRESADO;
        this.fechaVencimiento = fechaVencimiento;
    }

    private int id;
    private float monto;
    private Date fecha;
    private EstadoOperacion estado;
    private Date fechaVencimiento;
    private Garantia garantia;
    private SocioParticipe socioParticipe;
    private SubtipoOperacion subtipoOperacion;

    public void setSocioParticipe(SocioParticipe socioParticipe) {
        this.socioParticipe = socioParticipe;
    }
    public SubtipoOperacion getSubtipoOperacion() {
        return subtipoOperacion;
    }
    public void setSubtipoOperacion(SubtipoOperacion subtipoOperacion) {
        this.subtipoOperacion = subtipoOperacion;
    }
    public SocioParticipe getSocioParticipe() {
        return socioParticipe;
    }

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

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }



}