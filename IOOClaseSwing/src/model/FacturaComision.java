package model;

public class FacturaComision {

    public FacturaComision(float monto, String razonSocial) {
        this.monto = monto;
        this.razonSocial = razonSocial;
    }

    private int id;
    private float monto;
    private String razonSocial;

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
