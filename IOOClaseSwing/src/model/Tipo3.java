package model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class Tipo3 extends Operacion {

    public Tipo3(float monto, LocalDate fechaIngreso, LocalDate fechaVencimiento, SubtipoOperacion subtipoOperacion, String entidad, float tasa, LocalDate fechaDeAcreditacion, int cantidadCuotas, String sistemaAmortizacion) {
        super(monto, fechaIngreso, fechaVencimiento, subtipoOperacion);
        this.entidad = entidad;
        this.tasa = tasa;
        this.fechaDeAcreditacion = fechaDeAcreditacion;
        this.cantidadCuotas = cantidadCuotas;
        this.sistemaAmortizacion = sistemaAmortizacion;
        incicalizarCuotas(monto, tasa, fechaDeAcreditacion, cantidadCuotas);

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
    private LocalDate fechaDeAcreditacion;

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

    public LocalDate getFechaDeAcreditacion() {
        return fechaDeAcreditacion;
    }

    public void setFechaDeAcreditacion(LocalDate fechaDeAcreditacion) {
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
        return cuotas;
    }

    public void pagarCuotas(int numeroCuota) {
        Cuota cuotaAPagar = cuotas.stream()
            .filter(x -> x.getNumeroCuota() == numeroCuota)
            .findFirst()
            .orElse(null);

        if (cuotaAPagar != null && cuotaAPagar.getEstado() != EstadoCuotas.PAGADA) {
            cuotaAPagar.setEstado(EstadoCuotas.PAGADA);
        }
    }

    /**
     * retorna el monto que esta en mora.
     */
    public float montoEnMora() {

        double monto;
        monto = cuotas.stream()
            .filter(x -> x.getEstado() == EstadoCuotas.VENCIDA || x.getFechaVencimiento().compareTo(LocalDate.now()) < 0)
            .map(x -> x.getMonto())
            .collect(Collectors.summingDouble(Float::doubleValue));

        return (float) monto;
    }

    /**
     * retorna el monto que resta pagar, incluyendo las no vencidas.
     */
    public float montoRestanteDePago() {

        double monto;
        monto = cuotas.stream()
            .filter(x -> x.getEstado() != EstadoCuotas.PAGADA)
            .map(x -> x.getMonto())
            .collect(Collectors.summingDouble(Float::doubleValue));

        return (float) monto;
    }

    private void incicalizarCuotas(float monto, float tasa, LocalDate fechaDeAcreditacion, int cantidadCuotas) {
        this.cuotas = new ArrayList<>();
        monto += (monto * tasa);
        float montoCuota = monto / cantidadCuotas;
        for (int i = 1; i <= cantidadCuotas; i++) {
            fechaDeAcreditacion = fechaDeAcreditacion.plusMonths(1);
            cuotas.add(new Cuota(i, montoCuota, EstadoCuotas.EN_FECHA, i, fechaDeAcreditacion));
        }
    }
}