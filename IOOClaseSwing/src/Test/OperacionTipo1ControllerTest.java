package Test;

import Controllers.OperacionController;
import Controllers.TipoOperacionController;
import model.Operacion;
import model.SubtipoOperacion;
import model.Tipo1;
import model.Tipo2;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class OperacionTipo1ControllerTest {
    OperacionController target = new OperacionController();
    TipoOperacionController tipoOperacionController = new TipoOperacionController();

    public OperacionTipo1ControllerTest() throws Exception {

    }

    @Test
    public void save_t1_success() throws Exception {

        SubtipoOperacion subtipo = tipoOperacionController.getSubtipoOperacion(1);
        Tipo1 operacion = new Tipo1(5000, new Date(), new Date("06/30/2021"), subtipo,"1111111", 0.15f);

        target.AgregarOperacion(operacion, "20-44444444-2");
    }
    @Test
    public void save_t2_success() throws Exception {

        SubtipoOperacion subtipo = tipoOperacionController.getSubtipoOperacion(4);
        Tipo2 operacion = new Tipo2(5000, new Date(), new Date("06/30/2021"), subtipo, "empresa2");

        target.AgregarOperacion(operacion, "20-333333-2");
    }
    @Test
    public void save_t3_success() throws Exception {

        SubtipoOperacion subtipo = tipoOperacionController.getSubtipoOperacion(6);
        Tipo1 operacion = new Tipo1(5000, new Date(), new Date("06/30/2021"), subtipo,"1111111", 0.15f);

        target.AgregarOperacion(operacion, "20-44444444-2");
    }

    @Test
    public void emitir_certificado_success() throws Exception {
        target.emitirCertificado(7);
    }

    @Test
    public void monetizado_success() throws Exception {
        target.pasarAMonetizada(7);
    }

    @Test
    public void facturar_comisiones_success() throws Exception {
        target.facturarComisiones();
    }

    @Test
    public void Comisiones_por_fecha() throws Exception {
        target.getComisionPorFecha(new Date());
    }
}
