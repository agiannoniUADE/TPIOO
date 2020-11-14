package Test;

import Controllers.SGRController;
import Controllers.SocioController;
import DAO.SocioProtectorDao;
import model.*;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SGRControllerTest {

    SGRController target = SGRController.getInstance();;
    SocioController socioController = SocioController.getInstance();;
    SocioProtectorDao sociosProtectorDao = new SocioProtectorDao();

    public SGRControllerTest() throws Exception {
    }

   //para agregar SGR no borrar
   @Test
    void agregarSGR() throws Exception {

       SGR s = new SGR();
       s.id = 1;
       s.setRazonSocial("Smart SGR SA");

       //Aporte
       Aporte a = new Aporte();
       a.setId(1);
       SocioProtector socioProtector =(SocioProtector) sociosProtectorDao.search(1);
       a.setSocio(socioProtector);
       a.setFechaInicio(LocalDate.of(2020,12,10));
       a.setMonto(20000000);
       a.setRetirado(false);

       Aporte a2 = new Aporte();
       a2.setId(2);
       a2.setSocio(socioProtector);
       a2.setFechaInicio(LocalDate.of(2015,10,3));
       a2.setMonto(20000000);
       a2.setRetirado(false);
       List<Aporte> aportes = new ArrayList<>();

       aportes.add(a);
       aportes.add(a2);
       //fin aportes
       s.setAportes(aportes);

       target.saveSGR(s);
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

