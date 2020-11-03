package modelo;

import DAO.GenericDAO;

public class UsuarioDAO extends GenericDAO {

    public UsuarioDAO() throws Exception {
        super(Usuario.class, "/home/adearmas/Documentos/IntelliJ/IOOClaseSwing/src/txtDataFiles/usuarios.json" );
    }

}
