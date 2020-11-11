package model;

import java.time.LocalDate;

/**
 *
 */
public class Tipo1 extends Operacion {

    public Tipo1(float monto, LocalDate fecha, LocalDate fechaVencimiento, SubtipoOperacion subtipoOperacion, String cuitDelFirmante, Float tasaDeDescuento) throws Exception {
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
    private LocalDate fechaDeCobro;

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
    public LocalDate getFechaDeCobro() {
        return fechaDeCobro;
    }

    /**
     *
     */
    public void setFechaDeCobro(LocalDate fechaDeCobro) {
        this.fechaDeCobro = fechaDeCobro;
    }

}