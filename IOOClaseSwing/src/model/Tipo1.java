package model;

import com.sun.istack.internal.Nullable;

import java.util.*;

/**
 *
 */
public class Tipo1 extends Operacion {

    public Tipo1(float monto, Date fecha, Date fechaVencimiento, String cuitDelFirmante, float comision, Date fechaDeCobro, Float tasaDeDescuento) {
        super(monto, fecha, fechaVencimiento);
        this.cuitDelFirmante = cuitDelFirmante;
        this.comision = comision;
        this.fechaDeCobro = fechaDeCobro;
        this.tasaDeDescuento = tasaDeDescuento != null ? tasaDeDescuento.floatValue() : 0f;
    }

    public Tipo1(float monto, Date fecha, Date fechaVencimiento, String cuitDelFirmante, float comision, Date fechaDeCobro) {
        new Tipo1(monto, fecha, fechaVencimiento, cuitDelFirmante, comision, fechaDeCobro, null);
    }

    /**
     * Default constructor
     */
    public Tipo1() {
    }

    /**
     *
     */
    public int id;

    /**
     *
     */
    public String cuitDelFirmante;

    /**
     *
     */
    public float comision;

    /**
     *
     */
    public Date fechaDeCobro;

    /**
     *
     */
    public float tasaDeDescuento;


    /**
     *
     */
    public void tieneTasadeDescuento() {
        // TODO implement here
    }

    /**
     *
     */
    public void getTasaDeDesceunto() {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getCuitDelFirmante() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setCuitDelFirmante(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Date getFechaDeCobro() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setFechaDeCobro(Date value) {
        // TODO implement here
    }

}