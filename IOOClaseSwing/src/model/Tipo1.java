package model;

import com.sun.istack.internal.Nullable;

import java.util.*;

/**
 *
 */
public class Tipo1 extends Operacion {

    public Tipo1(float monto, Date fecha, Date fechaVencimiento,SubtipoOperacion subtipoOperacion, String cuitDelFirmante, Float tasaDeDescuento) {
        super(monto, fecha, fechaVencimiento, subtipoOperacion);
        this.cuitDelFirmante = cuitDelFirmante;
        this.fechaDeCobro = fechaDeCobro;
        this.tasaDeDescuento = tasaDeDescuento != null ? tasaDeDescuento.floatValue() : 0f;
    }

    /**
     * Default constructor
     */
    public Tipo1() {
    }

    /**
     *
     */
    private String cuitDelFirmante;


    /**
     *
     */
    private Date fechaDeCobro;

    /**
     *
     */
    private float tasaDeDescuento;

    @Override
    public float getMonto() {
        if (tasaDeDescuento != 0) {
            return monto - (monto * tasaDeDescuento);
        }
        return 0;
    }

    public float getTasaDeDescuento() {
        return tasaDeDescuento;
    }

    public void setTasaDeDescuento(float tasaDeDescuento) {
        this.tasaDeDescuento = tasaDeDescuento;
    }

    /**
     *
     */
    public boolean tieneTasadeDescuento() {
        return tasaDeDescuento != 0;
    }

    /**
     * @return
     */
    public String getCuitDelFirmante() {
        return cuitDelFirmante;
    }

    public void setCuitDelFirmante(String cuitDelFirmante) {
        this.cuitDelFirmante = cuitDelFirmante;
    }

    /**
     * @return
     */
    public Date getFechaDeCobro() {
        return fechaDeCobro;
    }

    /**
     *
     */
    public void setFechaDeCobro(Date fechaDeCobro) {
        this.fechaDeCobro = fechaDeCobro;
    }

}