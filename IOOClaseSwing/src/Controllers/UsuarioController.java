package Controllers;
import DAO.UsuarioDao;
import model.*;

import java.io.FileNotFoundException;
import java.util.List;

public class UsuarioController {

    private UsuarioDao usuarioDao;

    private UsuarioController() throws Exception {
        this.usuarioDao = new UsuarioDao();
   }


    static UsuarioController instance;

    public static UsuarioController getInstance() throws Exception {
        if (instance == null) {
            instance = new UsuarioController();
        }
        return instance;
    }




  
    public int AgregarNuevoUsuario(Usuario usuario) throws Exception {

        String nombre = usuario.getNombre();
        if(verificarUsuario(nombre)){
        int lastId= usuarioDao.getLastInsertId();
        lastId++;
        usuario.setId(lastId);
        usuarioDao.save(usuario);
        return lastId;
        }
        else{
            throw new Exception("no se pudo ingresar el usuario");
        }

    }
    public Usuario getUsuario (int id) throws FileNotFoundException {
        Object obj = usuarioDao.search(id);
        return obj != null ? (Usuario)obj: null;
    }


    public Boolean updateUsuario (Usuario usuario) throws Exception {


        return usuarioDao.update(usuario);


    }


    public Usuario getUsuarioByName(String nombre) throws Exception {
        List<Usuario> obj = usuarioDao.getAll();
        return obj.stream()
            .filter(e -> nombre.equalsIgnoreCase(e.getNombre()))
            .findFirst()
            .orElse(null);
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


    public Boolean verificarIngreso(String us, String pass) throws Exception {

        Usuario user = this.getUsuarioByName(us);
        if (user == null){
            throw new Exception("El usuario no existe");
        }
        if (pass.equals(user.getPassword())){
            return true;
        }
        else {
            throw new Exception("Contraseña incorrecta, porfavor ingresela nuevamente");
        }

    }

    public Boolean verificarUsuario (String nom) throws Exception{
        Usuario user = this.getUsuarioByName(nom);
        if (user == null){
            return true;
        }
        else{
            throw new Exception("el nombre de usuario ya existe");
        }

    }


}

