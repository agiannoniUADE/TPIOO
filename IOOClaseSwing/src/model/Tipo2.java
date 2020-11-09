package model;

import java.util.*;

public class Tipo2 extends Operacion {


    public Tipo2(float monto, Date fechaIngreso, Date fechaVencimiento, SubtipoOperacion subtipoOperacion, String RazonSocialEmpresa) {
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