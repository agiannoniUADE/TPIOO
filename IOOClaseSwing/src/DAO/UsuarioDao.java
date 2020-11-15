package DAO;

import model.Usuario;

public class UsuarioDao extends GenericDAO {

    public UsuarioDao() throws Exception {
        super(Usuario.class, "C:\\Users\\Gus Capparelli\\Documents\\Facultad\\Introduccion a la orientacion a objetos\\TPO_IOO\\IOOClaseSwing\\repo\\usuario.json");
    }


}
