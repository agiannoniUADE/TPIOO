package model;

import java.time.LocalDate;
import java.util.*;

/**
 *
 */
public class Operacion {

    public Operacion() {
    }

    public Operacion(float monto, LocalDate fechaIngreso, LocalDate fechaVencimiento, SubtipoOperacion subtipoOperacion) throws Exception {

        if (monto <= 0) {
            throw new Exception("El monto de la operacion no puede ser negativo");
        }
        this.monto = monto;
        this.fecha = fechaIngreso;
        this.estado = EstadoOperacion.INGRESADO;
        this.fechaVencimiento = fechaVencimiento;
        this.subtipoOperacion = subtipoOperacion;
    }

    protected int id;
    protected float monto;
    protected LocalDate fecha;
    protected EstadoOperacion estado;
    protected LocalDate fechaVencimiento;
    protected Certificado certificado;
    protected SocioParticipe socioParticipe;
    protected SubtipoOperacion subtipoOperacion;
    protected Comision comision;
    protected Desembolso desembolso;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoOperacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoOperacion estado) {
        this.estado = estado;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
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

    public Desembolso getDesembolso() {
        return desembolso;
    }

    public void setDesembolso(Desembolso desembolso) {
        this.desembolso = desembolso;
    }

    public boolean estaEnMora() {
        return fechaVencimiento.compareTo(LocalDate.now()) < 0 && desembolso != null;
    }

    public float getMora() {
        return estaEnMora() ? this.monto : 0;
    }

    @Override
    public boolean equals(Object o) {
        Operacion operacion = (Operacion) o;
        return id == operacion.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}