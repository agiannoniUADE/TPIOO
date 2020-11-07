package DAO;


import model.Tipo1;

public class OpeacionDao extends GenericDAO {

    public OpeacionDao() throws Exception {
        super(Tipo1.class, "repo/tipo1.json");
    }
}


