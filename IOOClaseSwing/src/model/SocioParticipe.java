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
        super(cuit, tipoSocio, razonSocial, fechaInicioActividad, actividadPrincipal, direccion, telefono, email, tamanioEmpresa);
    }

    public SocioParticipe(String cuit, TipoSocio tipoSocio, String razonSocial, Date fechaInicioActividad, String actividadPrincipal, String direccion, String telefono, String email, String tamanioEmpresa, List<Accionista> accionistas, List<DocumentoRegistro> documentos) {
        super(cuit, tipoSocio, razonSocial, fechaInicioActividad, actividadPrincipal, direccion, telefono, email, tamanioEmpresa, accionistas, documentos);
    }

    private LineaDeCredito lineaDeCredito;

    private List<Contragarantia> contragarantias;

    public TipoOperacion comisionPreferencial;

    public void setLineaDeCredito(LineaDeCredito lineaDeCredito) {
        this.lineaDeCredito = lineaDeCredito;
    }

    public void setContragarantias(List<Contragarantia> contragarantias) {
        this.contragarantias = contragarantias;
    }

    public TipoOperacion getComisionPreferencial() {
        return comisionPreferencial;
    }

    public void setComisionPreferencial(TipoOperacion comisionPreferencial) {
        this.comisionPreferencial = comisionPreferencial;
    }

    public float getMontoGarantia() {
        float totalContragarantias = 0;
        if (contragarantias != null) {
            for (Contragarantia item : contragarantias) {
                totalContragarantias += item.monto;
            }
        }
        return totalContragarantias;
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
    public List<Contragarantia> getContragarantias() {
        return contragarantias;
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
    public Boolean tieneComisionPreferencial() {
       return comisionPreferencial != null;
    }

    /**
     *
     */
    public float getMontoLineaDeCredito() {
        if (lineaDeCredito == null) {
            return 0;
        } else if (contragarantias == null) {
            return 0;
        } else if (getMontoGarantia() > lineaDeCredito.montoAsignado) {
            return lineaDeCredito.getMontoAsignado();
        } else {
            return getMontoGarantia();
        }
    }
}