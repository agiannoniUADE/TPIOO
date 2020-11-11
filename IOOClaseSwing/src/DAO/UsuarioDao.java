package DAO;

import model.Usuario;

public class UsuarioDao extends GenericDAO {

    public UsuarioDao() throws Exception {
        super(Usuario.class, "repo/usuario.json");
    }


}
