package Controllers;
import DAO.GenericDAO;
import DAO.UsuariosDAO;
import model.*;

import java.io.FileNotFoundException;
import java.util.*;

public class UsuariosController {

    private UsuariosDAO usuariosDAO;

    public UsuariosController() throws Exception {
         this.usuariosDAO = new UsuariosDAO();

    }



    public int AgregarNuevoUsuario(Usuario usuario) throws Exception {
        GenericDAO dao = usuario.getUsuario(usuario);


        int lastId = dao.getLastInsertId();
            lastId++;
            usuario.setId(lastId);
            usuariosDAO.save(usuario);
        return lastId;


        }

    public Usuario getUsuario(int id) throws FileNotFoundException {
        Object obj = usuariosDAO.search(id);
        return obj != null ? (Usuario)obj: null;
    }


    public Boolean updateSocio(Usuario usuario) throws Exception {

        return usuariosDAO.update(usuario);
    }

    /**
     * @param id
     */
    public Boolean delete(int id) throws Exception {
        return usuariosDAO.delete(id);
    }




}
