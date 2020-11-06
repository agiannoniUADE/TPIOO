package DAO;

import model.SGR;
import model.Socio;

public class SGRDao extends GenericDAO {


  public SGRDao() throws Exception {
    super(SGR.class, "repo/sgr.json");
  }
}
