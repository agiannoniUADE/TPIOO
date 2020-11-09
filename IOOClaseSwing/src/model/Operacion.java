package model;

import java.util.*;

/**
 *
 */
public class Operacion {

    public Operacion() {
    }

    public Operacion(float monto, Date fechaIngreso, Date fechaVencimiento, SubtipoOperacion subtipoOperacion) {
        this.monto = monto;
        this.fecha = fechaIngreso;
        this.estado = EstadoOperacion.INGRESADO;
        this.fechaVencimiento = fechaVencimiento;
        this.subtipoOperacion = subtipoOperacion;
    }

    protected int id;
    protected float monto;
    protected Date fecha;
    protected EstadoOperacion estado;
    protected Date fechaVencimiento;
    protected Certificado certificado;
    protected SocioParticipe socioParticipe;
    protected SubtipoOperacion subtipoOperacion;
    protected Comision comision;

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

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public Comision getComision() {
        return comision;
    }

    public void setComision(Comision comision) {
        this.comision = comision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operacion operacion = (Operacion) o;
        return id == operacion.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}