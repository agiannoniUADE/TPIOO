package model;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 */
public class Aporte {

    /**
     * Default constructor
     */
    public Aporte() {
    }

    /**
     *
     */
    private int id;

    /**
     *
     */
    private LocalDate fechaInicio;

    /**
     *
     */
    private float monto;

    private SocioProtector socio;

    private Boolean retirado;

    public SocioProtector getSocio() {
        return socio;
    }

    public void setSocio(SocioProtector socio) {
        this.socio = socio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }


    public Boolean FueRetirado() {
        return retirado;
    }

    public void setRetirado(Boolean estado) {
        this.retirado = estado;
    }


    public Boolean estaDisponibleParaRetiro() {

        Period age = Period.between(fechaInicio, LocalDate.now());
        return age.getYears() > 2;
    }
}