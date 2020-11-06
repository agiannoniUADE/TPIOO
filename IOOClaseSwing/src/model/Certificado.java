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

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String Estado;

    /**
     * 
     */
    private int certifivadoDeGarantia;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEstado() {
    return Estado;
  }

  public void setEstado(String estado) {
    Estado = estado;
  }

  public int getCertifivadoDeGarantia() {
    return certifivadoDeGarantia;
  }

  public void setCertifivadoDeGarantia(int certifivadoDeGarantia) {
    this.certifivadoDeGarantia = certifivadoDeGarantia;
  }
}