package Test;

import Controllers.SocioController;
import model.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SociosControllerTest {

    SocioController socioController = new SocioController();

    public SociosControllerTest() throws Exception {
    }


    @Test
    void AgregarSocio_Success() throws Exception {
        int id = insertSocio();
        assertNotNull(socioController.getSocioParticipe(1));
        socioController.delete(id);
    }

    @Test
    void searchByIdTest_Fail() throws Exception {
        int id = socioController.getLastInsertId();
        Socio socio = socioController.getSocioParticipe(id + 1);
        assertNull(socio);
    }

    @Test
    void searchByIdTest_Success() throws Exception {
        int id = insertSocio();
        Socio socio = socioController.getSocioParticipe(9);
        assertNotNull(socio);
        socioController.delete(id);
    }

    @Test
    void DeleteByIdTest_Success() throws Exception {
        int id = insertSocio();
        assertTrue(socioController.delete(id));
    }

    @Test
    void UpdateSocio_Success() throws Exception {

        int id = insertSocio();
        String cuit = "202020";
        String razonSocial = "TEST";
        Date inicioActividad = new Date();
        String actividadPrincipal = "Manufactura";
        TipoSocio tipoSocio = TipoSocio.PARTICIPE;
        String direccion = "FAKE street 123";
        String telefono = "428123132";
        String email = "info@test.com";
        String tamanioEmpresa = "pyme";

        SocioParticipe nuevoSocio = new SocioParticipe(
            cuit,
            tipoSocio,
            razonSocial,
            inicioActividad,
            actividadPrincipal,
            direccion,
            telefono,
            email,
            tamanioEmpresa);

        nuevoSocio.setId(id);
        assertTrue(socioController.updateSocio(nuevoSocio));
        socioController.delete(id);
    }

    private int insertSocio() throws Exception {
        String cuit = "20-37987765-2";
        String razonSocial = "Lavadero SRL";
        Date inicioActividad = new Date();
        String actividadPrincipal = "Servicio";
        TipoSocio tipoSocio = TipoSocio.PROTECTOR;
        String direccion = "Av. de mayo 987";
        String telefono = "428123132";
        String email = "info@lavadero.com";
        String tamanioEmpresa = "Mediana";

        Accionista accionista = new Accionista("111111", "Accionista1", 20);
        Accionista accionista2 = new Accionista("222222", "Accionista2", 55);

        DocumentoRegistro documentoRegistro1 = new DocumentoRegistro("Documento 1",
            "mgonzales", false, TipoDocumento.MANIFESTACION_BIENES);

        DocumentoRegistro documentoRegistro2 = new DocumentoRegistro("Documento 2",
            "mgonzales", true, TipoDocumento.CONTRATO_SOCIAL);

        Socio nuevoSocio = new SocioParticipe(
            cuit,
            tipoSocio,
            razonSocial,
            inicioActividad,
            actividadPrincipal,
            direccion,
            telefono,
            email,
            tamanioEmpresa);

        nuevoSocio.agregarAccionista(accionista);
        nuevoSocio.agregarAccionista(accionista2);
        nuevoSocio.agregarDocumento(documentoRegistro1);
        nuevoSocio.agregarDocumento(documentoRegistro2);

        return socioController.AgregarNuevoSocio(nuevoSocio);
    }
}

