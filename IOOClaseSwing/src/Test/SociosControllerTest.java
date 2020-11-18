package Test;

import Controllers.SocioController;
import Controllers.TipoOperacionController;
import model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SociosControllerTest {

    SocioController target = SocioController.getInstance();
    TipoOperacionController tipoOperacionController;

    public SociosControllerTest() throws Exception {
    }

    @Test
    void AgregarSocio_Success() throws Exception {
        int id = insertSocio();
        assertNotNull(target.getSocioParticipe(1));
       // target.delete(id);
    }

    @Test
    void searchByIdTest_Fail() throws Exception {
        int id = target.getLastInsertId();
        Socio socio = target.getSocioParticipe(id + 1);
        assertNull(socio);
    }

    @Test
    void searchByIdTest_Success() throws Exception {
        int id = insertSocio();
        Socio socio = target.getSocioParticipe(id);
        assertNotNull(socio);
        target.delete(id);
    }

    @Test
    void DeleteByIdTest_Success() throws Exception {
        int id = insertSocio();
        assertTrue(target.delete(id));
    }

    @Test
    void ChangeStatus_Success() throws Exception {


        target.cambiarEstadoSocio("1212");
    }

    @Test
    void UpdateSocio_Success() throws Exception {



        int id = insertSocio();
        String cuit = "202020";
        String razonSocial = "TEST";
        LocalDate inicioActividad = LocalDate.now();
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
        assertTrue(target.updateSocio(nuevoSocio));
        target.delete(id);
    }

    @Test
    void ChangeStatusDoc_Success() throws Exception {


        target.cambioEstadoDocumentoOk("1212", "Documento 1");
    }

    @Test
    void ChangeStatusDocRechazo_Success() throws Exception {


        target.cambioEstadoDocumentoRechazo("1212", "Documento 2");
    }

    @Test
    void getMora_Success() throws Exception {


        target.getMoraPorSocio(1);
    }


    private int insertSocio() throws Exception {

        TipoOperacionController tipoOperacionController = TipoOperacionController.getInstance();
        String cuit = "1212";
        String razonSocial = "Lavadero SRL";
        LocalDate inicioActividad = LocalDate.now();
        String actividadPrincipal = "Servicio";
        TipoSocio tipoSocio = TipoSocio.PARTICIPE;
        String direccion = "Av. de mayo 341";
        String telefono = "428123132";
        String email = "info@lavadero.com";
        String tamanioEmpresa = "Mediana";


        Accionista accionista = new Accionista("4444444", "Accionista4", 20);
        Accionista accionista2 = new Accionista("111111", "Accionista5", 55);

        DocumentoRegistro documentoRegistro1 = new DocumentoRegistro("Documento 1",
            "mgonzales", false, TipoDocumento.MANIFESTACION_BIENES);

        DocumentoRegistro documentoRegistro2 = new DocumentoRegistro("Documento 2",
            "mgonzales", true, TipoDocumento.CONTRATO_SOCIAL);

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

        nuevoSocio.agregarAccionista(accionista);
        nuevoSocio.agregarAccionista(accionista2);
        nuevoSocio.agregarDocumento(documentoRegistro1);
        nuevoSocio.agregarDocumento(documentoRegistro2);
        nuevoSocio.setAccion(200);

        nuevoSocio.setEstado(EstadoSocio.SOCIO_PLENO);

        TipoOperacion tipoOperacion = tipoOperacionController.getTipoOperacion(1);

        LineaDeCredito lineaDeCredito = new LineaDeCredito(LocalDate.of(2021,12,12), 70000, tipoOperacion);
        nuevoSocio.setLineaDeCredito(lineaDeCredito);

        Contragarantia c1 = new Contragarantia("Garantia1",20000);
        Contragarantia c2 = new Contragarantia("Garantia2",30000);

        nuevoSocio.addContragarantia(c1);
        nuevoSocio.addContragarantia(c2);

        return target.AgregarNuevoSocio(nuevoSocio);
    }

    @Test
    void GetSociosConSaldoDeAccionesDisponibles_Success() throws Exception {
        int id = insertSocio();
        assertNotNull(target.getSociosConAccionesDisponibles(TipoSocio.PARTICIPE));
    }

    @Test
    void AgregarSocioProtector_fail() throws Exception {
        SocioProtector socio = CreateSocioProtector("4444444");
        Exception exception = assertThrows(Exception.class, () -> {
            target.AgregarNuevoSocio(socio);
        });

        String expectedMessage = "Un socio protector no puede ser accionista de un socio participe.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    private SocioProtector CreateSocioProtector(String cuitSocio) throws Exception {
        String cuit = cuitSocio;
        String razonSocial = "Saveiro SRL";
        LocalDate inicioActividad = LocalDate.now();
        String actividadPrincipal = "Servicio";
        TipoSocio tipoSocio = TipoSocio.PROTECTOR;
        String direccion = "Av. de mayo 341";
        String telefono = "428123132";
        String email = "info@lavadero.com";
        String tamanioEmpresa = "Mediana";


        Accionista accionista = new Accionista("4444444", "Accionista4", 20);
        Accionista accionista2 = new Accionista("111111", "Accionista5", 55);

        DocumentoRegistro documentoRegistro1 = new DocumentoRegistro("Documento 1",
            "mgonzales", false, TipoDocumento.MANIFESTACION_BIENES);

        DocumentoRegistro documentoRegistro2 = new DocumentoRegistro("Documento 2",
            "mgonzales", true, TipoDocumento.CONTRATO_SOCIAL);

        SocioProtector nuevoSocio = new SocioProtector(
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

        nuevoSocio.setAccion(200);
        return nuevoSocio;
    }
}

