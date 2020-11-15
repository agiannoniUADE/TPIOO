package DAO;

import model.SGR;
import model.TipoOperacion;

public class TipoOperacionDao extends GenericDAO {

  public TipoOperacionDao() throws Exception {
    super(TipoOperacion.class, "C:\\Users\\Gus Capparelli\\Documents\\Facultad\\Introduccion a la orientacion a objetos\\TPO_IOO\\IOOClaseSwing\\repo\\tipoOperacion.json");
  }
}
