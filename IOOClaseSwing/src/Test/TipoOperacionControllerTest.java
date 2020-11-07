package Test;

import Controllers.TipoOperacionController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TipoOperacionControllerTest {

    TipoOperacionController target = new TipoOperacionController();

    public TipoOperacionControllerTest() throws Exception {
    }

    @Test
    public void AgregarTipoOperacion() throws Exception {
        target.saveTipoOperacion();
    }

    @Test
    public void AgregarSubTipoOperacion() throws Exception {
        target.saveSubTipoOperacion();
    }

    @Test
    public void GetComision() throws Exception {
        float value = target.getComsionPorTipo(1);
        assertNotNull(value);
    }
}
