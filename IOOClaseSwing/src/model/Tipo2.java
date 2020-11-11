package model;

import java.time.LocalDate;

public class Tipo2 extends Operacion {


    public Tipo2(float monto, LocalDate fechaIngreso, LocalDate fechaVencimiento, SubtipoOperacion subtipoOperacion, String RazonSocialEmpresa) throws Exception {
        super(monto, fechaIngreso, fechaVencimiento, subtipoOperacion);
        this.RazonSocialEmpresa = RazonSocialEmpresa;
    }

    /**
     * Default constructor
     */
    public Tipo2() {

    }

    private String RazonSocialEmpresa;

    public String getRazonSocialEmpresa() {
        return RazonSocialEmpresa;
    }

    public void setRazonSocialEmpresa(String razonSocialEmpresa) {
        RazonSocialEmpresa = razonSocialEmpresa;
    }
}