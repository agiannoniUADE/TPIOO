package Test;

import Controllers.SGRController;
import Controllers.SocioController;
import model.*;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SGRControllerTest {

    SGRController target = new SGRController();
    SocioController socioController = new SocioController();

    public SGRControllerTest() throws Exception {
    }

   //para agregar SGR no borrar
   @Test
    void agregarSGR() throws Exception {
        target.saveSGR();
    }

   @Test
    void getSGR_sucess() throws Exception {
        assertNotNull(target.GetSGR());
    }

    @Test
    void AgregarAporte_sucess() throws Exception {
       SGR obj = target.GetSGR();

        //Aporte
        Aporte a = new Aporte();
        a.setId(1);
        SocioProtector socioProtector =(SocioProtector) socioController.getSocioProtector(1);
        a.setSocio(socioProtector);
        a.setFechaInicio(LocalDate.of(2020,1,20));
        a.setMonto(700000);
        a.setRetirado(false);

        target.agregarAporte(a);
    }
}

