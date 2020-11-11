package DAO;


import model.Operacion;
import model.Tipo2;

public class OpeacionT2Dao extends GenericDAO {

    public OpeacionT2Dao() throws Exception {
        super(Tipo2.class, "repo/tipo2.json");
    }
}


