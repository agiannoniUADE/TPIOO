package DAO;

import model.Socio;
import utils.GenericDAO;

public class SociosDao extends GenericDAO {


  public SociosDao() throws Exception {
    super(Socio.class, "repo/socio.json");
  }
}
