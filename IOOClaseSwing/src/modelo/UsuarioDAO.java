package modelo;

import utils.GenericDAO;

public class UsuarioDAO extends GenericDAO {

    public UsuarioDAO() throws Exception {
        super(Usuario.class, "/home/adearmas/Documentos/IntelliJ/IOOClaseSwing/src/txtDataFiles/usuarios.json" );
    }

}
