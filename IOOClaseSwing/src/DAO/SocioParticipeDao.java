package DAO;

import model.Socio;
import model.SocioParticipe;

public class SocioParticipeDao extends GenericDAO {


    public SocioParticipeDao() throws Exception {
        super(SocioParticipe.class, "C:\\Users\\Gus Capparelli\\Documents\\Facultad\\Introduccion a la orientacion a objetos\\TPO_IOO\\IOOClaseSwing\\repo\\socioParticipe.json");
    }
}
