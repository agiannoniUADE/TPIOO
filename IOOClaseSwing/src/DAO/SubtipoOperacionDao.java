package DAO;

import model.SubtipoOperacion;

public class SubtipoOperacionDao extends GenericDAO {

    public SubtipoOperacionDao() throws Exception {
        super(SubtipoOperacion.class, "repo/subtipoOperacion.json");
    }
}
