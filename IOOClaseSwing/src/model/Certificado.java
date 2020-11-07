package model;
import java.util.*;

/**
 * 
 */
public class Certificado {

    /**
     * Default constructor
     */
    public Certificado() {
    }

    public Certificado(int numeroCertificado, String razonSocial) {
        this.numeroCertificado = numeroCertificado;
        this.razonSocial = razonSocial;
    }

    private int numeroCertificado;
    private String razonSocial;

    public int getNumeroCertificado() {
        return numeroCertificado;
    }

    public void setNumeroCertificado(int numeroCertificado) {
        this.numeroCertificado = numeroCertificado;
    }
}