package Test;

import Controllers.UsuarioController;
import model.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuariosControllerTest {

    UsuarioController target = UsuarioController.getInstance();

    public UsuariosControllerTest() throws Exception {
    }

    @Test
    void AgregarNuevoUsuario_Success() throws Exception {
        int id = insertUser();

        assertNotNull(target.getUsuario(id));
    }

    @Test
    void searchByIdTest_Fail() throws Exception {
        int id = target.getLastInsertId();
        Usuario usuario = target.getUsuario(id + 1);
        assertNull(usuario);
    }


    @Test
    void searchByIdTest_Success() throws Exception {
        int id = insertUser();
        Usuario usuario = target.getUsuario(1);
        assertNotNull(usuario);
        target.delete(id);
    }

    @Test
    void DeleteByIdTest_Success() throws Exception {
        int id = insertUser();
        assertTrue(target.delete(2));
    }

    @Test
    void UpdateUser_Success() throws Exception{


        int id = insertUser();
        String nombre = "DEF";
        String password = "456";


        Usuario nuevoUsuario = new Usuario(
            nombre,
            password
            );
        nuevoUsuario.setId(id);
        assertTrue(target.updateUsuario(nuevoUsuario));
        //assertTrue(target.updateUsuario(nuevoUsuario));
        //target.delete(id);

    }


    @Test
    void testPass_Success() throws Exception {

        target.verificarIngreso("ABC","123");

    }



    private int insertUser() throws Exception {
        //int id = target.getLastInsertId()+1;
        String nombre = "DEF";
        String password = "123";

        Usuario nuevoUsuario = new Usuario(
            nombre,
            password
            );


         return target.AgregarNuevoUsuario(nuevoUsuario);
    }
}

