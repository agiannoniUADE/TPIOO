package DAO;
import model.Tipo3;

public class OpeacionT3Dao extends GenericDAO {

    public OpeacionT3Dao() throws Exception {
        super(Tipo3.class, "repo/tipo3.json");
    }
}


