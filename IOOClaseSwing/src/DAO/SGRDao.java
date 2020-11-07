package DAO;

import model.SGR;

public class SGRDao extends GenericDAO {


  public SGRDao() throws Exception {
    super(SGR.class, "repo/sgr.json");
  }
}
