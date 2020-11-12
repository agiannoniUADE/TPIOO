package Controllers;
import DAO.UsuarioDao;
import model.*;

import java.io.FileNotFoundException;
import java.util.List;

public class UsuarioController {

    private UsuarioDao usuarioDao;

    /**
     * Default constructor
     */

    public UsuarioController() throws Exception {
         this.usuarioDao = new UsuarioDao();

    }



    public int AgregarNuevoUsuario(Usuario usuario) throws Exception {

        int lastId= usuarioDao.getLastInsertId();
        lastId++;
        usuario.setId(lastId);
        usuarioDao.save(usuario);

        return lastId;


        }

    public Usuario getUsuario (int id) throws FileNotFoundException {
        Object obj = usuarioDao.search(id);
        return obj != null ? (Usuario)obj: null;
    }


    public Boolean updateUsuario (Usuario usuario) throws Exception {

        return usuarioDao.update(usuario);
    }

    /**
     * @param id
     */
    public Boolean delete(int id) throws Exception {
        return usuarioDao.delete(id);
    }


    public int getLastInsertId() throws Exception {
        return usuarioDao.getLastInsertId();
    }

    public List<Usuario> getUsuarios() throws Exception {
        List<Usuario> lista = usuarioDao.getAll();
        return lista;
    }

/*
    public Boolean verificarIngreso(String palabra){
        if (palabra.equals(this.password)){
            return true;
        }
        else{
            return false;
        }
    }
*/
}
