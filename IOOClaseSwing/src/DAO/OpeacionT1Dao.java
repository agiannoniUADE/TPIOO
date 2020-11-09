package DAO;


import model.Operacion;
import model.Tipo1;

public class OpeacionT1Dao extends GenericDAO {

    public OpeacionT1Dao() throws Exception {
        super(Operacion.class, "repo/tipo1.json");
    }
}


