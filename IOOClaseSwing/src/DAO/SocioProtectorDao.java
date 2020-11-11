package DAO;

import model.Socio;
import model.SocioProtector;

public class SocioProtectorDao extends GenericDAO {


  public SocioProtectorDao() throws Exception {
    super(SocioProtector.class, "repo/socioProtector.json");
  }
}
