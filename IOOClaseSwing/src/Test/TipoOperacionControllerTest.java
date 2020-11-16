package Test;

import Controllers.TipoOperacionController;
import model.SubtipoOperacion;
import model.TipoOperacion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TipoOperacionControllerTest {

    TipoOperacionController target;

    public TipoOperacionControllerTest() throws Exception {
    }

    @Test
    public void AgregarTipoOperacion() throws Exception {

        target = TipoOperacionController.getInstance();
        TipoOperacion t = new TipoOperacion();

        t.setId(1);
        t.setDescripcion("tipo 1");
        t.setComision(0.03f);

        TipoOperacion t2 = new TipoOperacion();

        t2.setId(2);
        t2.setDescripcion("tipo 2");
        t2.setComision(0.03f);

        TipoOperacion t3 = new TipoOperacion();

        t3.setId(3);
        t3.setDescripcion("tipo 3");
        t3.setComision(0.04f);

        SubtipoOperacion s1 = new SubtipoOperacion();
        s1.setId(1);
        s1.setDescripcion("Cheques propios");
        //s1.tipoOperacion = t;

        SubtipoOperacion s2 = new SubtipoOperacion();
        s2.setId(2);
        s2.setDescripcion("Cheques de terceros");
        //s2.tipoOperacion = t;

        SubtipoOperacion s3 = new SubtipoOperacion();
        s3.setId(3);
        s3.setDescripcion("Pagaré Bursatil");
        //s3.tipoOperacion = t;

        SubtipoOperacion s4 = new SubtipoOperacion();
        s4.setId(4);
        s4.setDescripcion("Cuentas corrientes Comerciales");
        //s4.tipoOperacion = t2;

        SubtipoOperacion s5 = new SubtipoOperacion();
        s5.setId(5);
        s5.setDescripcion("Tarjetas de crédito");
        //s5.tipoOperacion = t2;

        SubtipoOperacion s6 = new SubtipoOperacion();
        s6.setId(6);
        s6.setDescripcion("Prestamos");
        //s6.tipoOperacion = t3;

        t.setSubtipoOperacion(Arrays.asList(s1, s2, s3));
        t2.setSubtipoOperacion(Arrays.asList(s4, s5));
        t3.setSubtipoOperacion(Arrays.asList(s6));

        target.saveTipoOperacion(Arrays.asList(t, t2, t3));
    }

    @Test
    public void AgregarSubTipoOperacion() throws Exception {
        target = TipoOperacionController.getInstance();
        TipoOperacion t = new TipoOperacion();
        t.setId(1);
        t.setDescripcion("tipo 1");
        t.setComision(0.03f);

        TipoOperacion t2 = new TipoOperacion();

        t2.setId(2);
        t2.setDescripcion("tipo 2");
        t2.setComision(0.03f);

        TipoOperacion t3 = new TipoOperacion();

        t3.setId(3);
        t3.setDescripcion("tipo 3");
        t3.setComision(0.04f);

        SubtipoOperacion s1 = new SubtipoOperacion();
        s1.setId(1);
        s1.setDescripcion("Cheques propios");
        s1.setTipoOperacion(t);

        SubtipoOperacion s2 = new SubtipoOperacion();
        s2.setId(2);
        s2.setDescripcion("Cheques de terceros");
        s2.setTipoOperacion(t);

        SubtipoOperacion s3 = new SubtipoOperacion();
        s3.setId(3);
        s3.setDescripcion("Pagaré Bursatil");
        s3.setTipoOperacion(t);

        SubtipoOperacion s4 = new SubtipoOperacion();
        s4.setId(4);
        s4.setDescripcion("Cuentas corrientes Comerciales");
        s4.setTipoOperacion(t2);

        SubtipoOperacion s5 = new SubtipoOperacion();
        s5.setId(5);
        s5.setDescripcion("Tarjetas de crédito");
        s5.setTipoOperacion(t2);

        SubtipoOperacion s6 = new SubtipoOperacion();
        s6.setId(6);
        s6.setDescripcion("Prestamos");
        s6.setTipoOperacion(t3);


        List<SubtipoOperacion> subTipos = new ArrayList();

        subTipos.add(s1);
        subTipos.add(s2);
        subTipos.add(s3);
        subTipos.add(s4);
        subTipos.add(s5);
        subTipos.add(s6);
        target.saveSubTipoOperacion(subTipos);
    }

    @Test
    public void GetComision() throws Exception {
        target = TipoOperacionController.getInstance();
        float value = target.getComsionPorTipo(1,"23-9999999-1");
        assertNotNull(value);
    }
}
