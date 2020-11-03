package Test;
import Controllers.SocioController;
import model.Socio;
import model.TipoSocio;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.io.FileNotFoundException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SociosControllerTest {

  SocioController SocioController = new SocioController();

  public SociosControllerTest() throws Exception {
  }

  @Test
  void searchByIdTest_Fail() throws FileNotFoundException {
    Socio socio = SocioController.getSocioParticipe(90);
    assertNull(socio);
  }

  @Test
  void searchByIdTest_Success() throws FileNotFoundException {
    Socio socio = SocioController.getSocioParticipe(9);
    assertNotNull(socio);
  }

  @Test
  void UpdateSocio_Success() throws Exception {

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

      nuevoSocio.setId(9);

    SocioController.updateSocio(nuevoSocio);
  }


}
