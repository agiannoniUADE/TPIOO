package Controllers;

import DAO.UsuarioDao;
import model.*;

import java.io.FileNotFoundException;

public class UsuarioController {

    private UsuarioDao usuarioDao;

    public UsuarioController() throws Exception {
        this.usuarioDao = new UsuarioDao();

    }

    public int AgregarNuevoUsuario(Usuario usuario) throws Exception {
        int lastId = usuarioDao.getLastInsertId();
        lastId++;
       // usuario.setId(lastId);
        usuarioDao.save(usuario);
        return lastId;

    }


    public Usuario getUsuario(int id) throws FileNotFoundException {
      /*  Object obj = usuariosDAO.search(id);
        return obj != null ? (Usuario) obj : null;*/
      return null;
    }


    public Boolean updateSocio(Usuario usuario) throws Exception {
            /*
        return usuariosDAO.update(usuario);*/
            return true;
    }

    /**
     * @param id
     */
    public Boolean delete(int id) throws Exception {
       // return usuariosDAO.delete(id);
        return true;
    }

}
