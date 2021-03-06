package model;

import java.time.LocalDate;
import java.util.*;

/**
 *
 */
public class SocioParticipe extends Socio {

    public SocioParticipe() {
    }

    public SocioParticipe(String cuit, TipoSocio tipoSocio, String razonSocial, LocalDate fechaInicioActividad,
                          String actividadPrincipal, String direccion, String telefono, String email, String tamanioEmpresa) {
        super(cuit, tipoSocio, razonSocial, fechaInicioActividad, actividadPrincipal, direccion, telefono, email, tamanioEmpresa);

        this.contragarantias = new ArrayList<>();
    }

    public SocioParticipe(String cuit, TipoSocio tipoSocio, String razonSocial, LocalDate fechaInicioActividad, String actividadPrincipal, String direccion, String telefono, String email, String tamanioEmpresa, List<Accionista> accionistas, List<DocumentoRegistro> documentos) {
        super(cuit, tipoSocio, razonSocial, fechaInicioActividad, actividadPrincipal, direccion, telefono, email, tamanioEmpresa, accionistas, documentos);
    }

    private LineaDeCredito lineaDeCredito;

    private List<Contragarantia> contragarantias;

    private TipoOperacion comisionPreferencial;

    public void setLineaDeCredito(LineaDeCredito lineaDeCredito) {
        this.lineaDeCredito = lineaDeCredito;
    }

    public void setContragarantias(List<Contragarantia> contragarantias) {
        this.contragarantias = contragarantias;
    }

    public float getComisionPreferencial() {
        return comisionPreferencial.getComision();
    }

    public void setComisionPreferencial(TipoOperacion comisionPreferencial) {
        this.comisionPreferencial = comisionPreferencial;
    }

    public float getMontoGarantia() {
        float totalContragarantias = 0;
        if (contragarantias != null) {
            for (Contragarantia item : contragarantias) {
                totalContragarantias += item.getMonto();
            }
        }
        return totalContragarantias;
    }


    public List<Contragarantia> getContragarantias() {
        return contragarantias;
    }

    public void addContragarantia(Contragarantia obj) {
        this.contragarantias.add(obj);
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
        } else if (getMontoGarantia() > lineaDeCredito.getMontoAsignado()) {
            return lineaDeCredito.getMontoAsignado();
        } else {
            return getMontoGarantia();
        }
    }

    public LineaDeCredito getLineaDeCredito() {
        return lineaDeCredito;
    }
}