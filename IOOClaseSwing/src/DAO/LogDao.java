package DAO;

import utils.Logger;

public class LogDao extends GenericDAO {


    public LogDao() throws Exception {
        super(Logger.class, "C:\\Users\\Gus Capparelli\\Documents\\Facultad\\Introduccion a la orientacion a objetos\\TPO_IOO\\IOOClaseSwing\\log.json");
    }
}
