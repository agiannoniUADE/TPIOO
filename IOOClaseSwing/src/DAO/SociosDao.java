package DAO;

import model.Socio;

public class SociosDao extends GenericDAO {


  public SociosDao() throws Exception {
    super(Socio.class, "repo/socio.json");
  }
}
