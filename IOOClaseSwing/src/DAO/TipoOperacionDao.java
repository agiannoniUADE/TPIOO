package DAO;

import model.SGR;
import model.TipoOperacion;

public class TipoOperacionDao extends GenericDAO {


  public TipoOperacionDao() throws Exception {
    super(TipoOperacion.class, "repo/tipoOperacion.json");
  }
}
