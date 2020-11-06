package DAO;

import model.Socio;

public class SocioParticipeDao extends GenericDAO {


  public SocioParticipeDao() throws Exception {
    super(Socio.class, "repo/socioParticipe.json");
  }
}
