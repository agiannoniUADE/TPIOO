package DAO;

import model.Socio;
import model.SocioParticipe;

public class SocioParticipeDao extends GenericDAO {


  public SocioParticipeDao() throws Exception {
    super(SocioParticipe.class, "repo/socioParticipe.json");
  }
}
