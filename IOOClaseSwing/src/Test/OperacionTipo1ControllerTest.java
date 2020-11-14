package Test;

import Controllers.OperacionController;
import Controllers.TipoOperacionController;
import model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class OperacionTipo1ControllerTest {
    OperacionController target;
    TipoOperacionController tipoOperacionController;

    public OperacionTipo1ControllerTest() throws Exception {

    }

    @Test
    public void save_t1_success() throws Exception {
        target = OperacionController.getInstance();
        tipoOperacionController = TipoOperacionController.getInstance();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        SubtipoOperacion subtipo = tipoOperacionController.getSubtipoOperacion(1);
        Tipo1 operacion = new Tipo1(5000, LocalDate.now(), LocalDate.parse("06-09-2021", formato), subtipo, "222222", 0.10f);

        target.AgregarOperacion(operacion, "20-1000-2");
    }

    @Test
    public void save_t2_success() throws Exception {
        tipoOperacionController = TipoOperacionController.getInstance();
        OperacionController target = OperacionController.getInstance();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        SubtipoOperacion subtipo = tipoOperacionController.getSubtipoOperacion(4);
        Tipo2 operacion = new Tipo2(5000, LocalDate.now(), LocalDate.parse("26-04-2021", formato), subtipo, "empresa2");

        target.AgregarOperacion(operacion, "20-333333-2");
    }

    @Test
    public void save_t3_success() throws Exception {

        tipoOperacionController = TipoOperacionController.getInstance();
        target = OperacionController.getInstance();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        SubtipoOperacion subtipo = tipoOperacionController.getSubtipoOperacion(6);
        Tipo3 operacion = new Tipo3(45678, LocalDate.now(), LocalDate.parse("06-06-2022", formato), subtipo, "Santander", 0.08f, LocalDate.now(), 18, "frances");

        target.AgregarOperacion(operacion, "20-555555-2");
    }

    @Test
    public void emitir_certificado_success() throws Exception {
        target = OperacionController.getInstance();
        target.emitirCertificado(11);
    }

    @Test
    public void monetizado_success() throws Exception {
        target = OperacionController.getInstance();
        target.pasarAMonetizada(11);
    }

    @Test
    public void facturar_comisiones_success() throws Exception {
        target.facturarComisiones();
    }

    @Test
    public void Comisiones_por_fecha() throws Exception {
        target = OperacionController.getInstance();
        target.getComisionDeChequesPorFecha(LocalDate.now());
    }

    @Test
    public void getPromedioTasaDescunto() throws Exception {
        target = OperacionController.getInstance();
        target.getPromedioTasaDescuentoParaOperacionesChequeParaUntipoEmpresa(
            "Mediana",LocalDate.of(2020,11,1),LocalDate.of(2021,1,1));
    }

}
