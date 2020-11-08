package DAO;

import model.Usuario;

public class UsuariosDAO extends GenericDAO {

    public UsuariosDAO() throws Exception {
        super(Usuario.class, "repo/usuario.json");
    }


}


