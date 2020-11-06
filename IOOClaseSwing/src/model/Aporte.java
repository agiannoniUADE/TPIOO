package  model;
import utils.DateUtils;

import java.util.*;

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
    private Date fechaInicio;

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean estaDisponibleParaRetiro()
    {
        return DateUtils.getDiffYears(fechaInicio, new Date()) >= 2;
    }
}