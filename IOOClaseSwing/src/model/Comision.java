package model;


import java.time.LocalDate;

public class Comision {

    private int id;
    private float monto;
    private float tasaUtilizada;
    private EstadoComision estadoComision;
    private FacturaComision factura;
    private LocalDate fechaCalculocomision;

    public Comision(float montoBrutoOperacion, float tasaUtilizada) {
        this.monto = montoBrutoOperacion * tasaUtilizada;
        this.tasaUtilizada = tasaUtilizada;
        this.estadoComision = EstadoComision.CALCULADA;
        this.fechaCalculocomision = LocalDate.now();
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

    public float getTasaUtilizada() {
        return tasaUtilizada;
    }

    public void setTasaUtilizada(float tasaUtilizada) {
        this.tasaUtilizada = tasaUtilizada;
    }

    public EstadoComision getEstadoComision() {
        return estadoComision;
    }

    public void setEstadoComision(EstadoComision estadoComision) {
        this.estadoComision = estadoComision;
    }

    public FacturaComision getFactura() {
        return factura;
    }

    public void GenerarFactura(String razonSocial) {
        this.factura = new FacturaComision(this.monto, razonSocial);
    }

    public LocalDate getFechaCalculocomision() {
        return fechaCalculocomision;
    }

    public void setFechaCalculocomision(LocalDate fechaCalculocomision) {
        this.fechaCalculocomision = fechaCalculocomision;
    }
}
