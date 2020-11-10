package model;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class SocioProtector extends Socio {

    /**
     * Default constructor
     */
    public SocioProtector() {
    }

    public SocioProtector(String cuit, TipoSocio tipoSocio, String razonSocial, LocalDate fechaInicioActividad, String actividadPrincipal, String direccion, String telefono, String email, String tamanioEmpresa) {
        super(cuit, tipoSocio, razonSocial, fechaInicioActividad, actividadPrincipal, direccion, telefono, email, tamanioEmpresa);
    }

    public SocioProtector(String cuit, TipoSocio tipoSocio, String razonSocial, LocalDate fechaInicioActividad, String actividadPrincipal, String direccion, String telefono, String email, String tamanioEmpresa, List<Accionista> accionistas, List<DocumentoRegistro> documentos) {
        super(cuit, tipoSocio, razonSocial, fechaInicioActividad, actividadPrincipal, direccion, telefono, email, tamanioEmpresa, accionistas, documentos);
    }
}