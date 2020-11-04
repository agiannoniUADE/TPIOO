package Test;
import Controllers.SocioController;
import model.Socio;
import model.TipoSocio;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
 import static org.junit.jupiter.api.Assertions.assertTrue;

public class SociosControllerTest {

  SocioController SocioController = new SocioController();

  public SociosControllerTest() throws Exception {
  }

  @Test
  void searchByIdTest_Fail() throws Exception {
    int id = SocioController.getLastInsertId();
    Socio socio = SocioController.getSocioParticipe(id + 1);
    assertNull(socio);
  }

  @Test
  void searchByIdTest_Success() throws Exception {
    int id = insertSocio();
    Socio socio = SocioController.getSocioParticipe(9);
    assertNotNull(socio);
    SocioController.delete(id);
  }

  @Test
  void DeleteByIdTest_Success() throws Exception {
    int id = insertSocio();
   assertTrue(SocioController.delete(id));
  }

  @Test
  void UpdateSocio_Success() throws Exception {

    int id = insertSocio();
    String cuit = "202020";
    String razonSocial = "TEST";
    Date inicioActividad = new Date();
    String actividadPrincipal =  "Manufactura";
    TipoSocio tipoSocio = TipoSocio.PARTICIPE;
    String direccion = "FAKE street 123";
    String telefono = "428123132";
    String email = "info@test.com";
    String tamanioEmpresa = "pyme";

    Socio nuevoSocio = new Socio(
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
      assertTrue(SocioController.updateSocio(nuevoSocio));
      SocioController.delete(id);
  }

  private int insertSocio() throws Exception {
    String cuit = "202020";
    String razonSocial = "TEST";
    Date inicioActividad = new Date();
    String actividadPrincipal =  "Manufactura";
    TipoSocio tipoSocio = TipoSocio.PARTICIPE;
    String direccion = "FAKE street 123";
    String telefono = "428123132";
    String email = "info@test.com";
    String tamanioEmpresa = "pyme";

    Socio nuevoSocio = new Socio(
      cuit,
      tipoSocio,
      razonSocial,
      inicioActividad,
      actividadPrincipal,
      direccion,
      telefono,
      email,
      tamanioEmpresa);

    return SocioController.AgregarNuevoSocio(nuevoSocio);
  }
}

