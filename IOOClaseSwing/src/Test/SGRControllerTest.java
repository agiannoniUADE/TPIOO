package Test;

import Controllers.SGRController;
import Controllers.SocioController;
import model.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SGRControllerTest {

    SGRController controller = new SGRController();

    public SGRControllerTest() throws Exception {
    }

   /* //para agregar SGR no borrar
   @Test
    void agregarSGR() throws Exception {
        controller.saveSGR();
    }
    */
   @Test
    void getSGR_sucess() throws Exception {
        assertNotNull(controller.GetSGR());
    }

    @Test
    void AgregarAporte_sucess() throws Exception {
       SGR obj = controller.GetSGR();
       obj.
    }
}

