package model;

import java.time.LocalDate;
import java.util.*;

/**
 *
 */
public class Cuota {

    /**
     * Default constructor
     */
    public Cuota() {
    }

    public Cuota(int cuotaId, float monto, EstadoCuotas estado, int numeroCuota, LocalDate fechaVencimiento) {
        this.cuotaId = cuotaId;
        this.monto = monto;
        this.estado = estado;
        this.numeroCuota = numeroCuota;
        this.fechaVencimiento = fechaVencimiento;
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
    private EstadoCuotas estado;

    /**
     *
     */
    private int numeroCuota;

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    private LocalDate fechaVencimiento;


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

    public EstadoCuotas getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuotas estado) {
        this.estado = estado;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }
}