package model;
import java.util.*;

/**
 * 
 */
public class SocioParticipe extends Socio {

  public SocioParticipe() {
  }

  public SocioParticipe(String cuit, TipoSocio tipoSocio, String razonSocial, Date fechaInicioActividad,
                        String actividadPrincipal, String direccion, String telefono, String email, String tamanioEmpresa) {
      super(cuit,tipoSocio,razonSocial,fechaInicioActividad,actividadPrincipal,direccion,telefono,email,tamanioEmpresa);
  }

    /**
     * 
     */
    public void getMontoGarantia() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getRiesgo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getContragarantias() {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void getOperacion(int id) {
        // TODO implement here
    }

    /**
     * @param tipoOperacionId
     */
    public void getComisionPreferencial(int tipoOperacionId) {
        // TODO implement here
    }

    /**
     * 
     */
    public void tieneComisionPreferencial() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getTamanioEmpresa() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getMontoLineaDeCredito() {
        // TODO implement here
    }

}