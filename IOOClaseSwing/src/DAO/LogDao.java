package DAO;

import utils.Logger;

public class LogDao extends GenericDAO {


    public LogDao() throws Exception {
        super(Logger.class, "repo/log.json");
    }
}
