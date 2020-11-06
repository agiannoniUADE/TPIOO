package Controllers;
import DAO.GenericDAO;
import DAO.SocioParticipeDao;
import DAO.SocioProtectorDao;
import model.Socio;
import model.SocioParticipe;
import model.SocioProtector;
import model.TipoSocio;

import java.io.FileNotFoundException;
import java.util.*;

public class SocioController {

  private SocioParticipeDao socioParticipeDao;
  private SocioProtectorDao socioProtectorDao;

    /**
     * Default constructor
     */
    public SocioController() throws Exception {
      this.socioParticipeDao = new SocioParticipeDao();
      this.socioProtectorDao = new SocioProtectorDao();
    }

    public int AgregarNuevoSocio(Socio socio) throws Exception {
      int lastId = socioParticipeDao.getLastInsertId();
        lastId++;
        socio.setId(lastId);
        socioParticipeDao.save(socio);
      return lastId;
    }
    /**
     * @param id
     */
    public Socio getSocioParticipe(int id) throws FileNotFoundException {

      Object obj = socioParticipeDao.search(id);
      return obj != null ? (Socio)obj: null;
    }

    public Socio getSocioProtector(int id) throws FileNotFoundException {
        Object obj = socioProtectorDao.search(id);
        return obj != null ? (Socio)obj: null;
    }

  /**
   * @param obj
   */
  public Boolean updateSocio(Socio obj) throws Exception {

   return socioParticipeDao.update(obj);
  }

  /**
   * @param id
   */
  public Boolean delete(int id) throws Exception {
    return socioParticipeDao.delete(id);
  }


  public int getLastInsertId() throws Exception
  {
    return socioParticipeDao.getLastInsertId();
  }
    /**
     * @param socioId
     */
    public void getMoraPorSocio(int socioId) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void getOperacionesEnMoraPorSocio(int id) {
        // TODO implement here
    }

    /**
     * @param id 
     * @param tipoOperacionId
     */
    public void getComisionPorSocio(int id, int tipoOperacionId) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void getOperacionAvaladas(int id) {
        // TODO implement here
    }

    /**
     * @param IdSocio
     */
    public void getSocioParticipePorId(int IdSocio) {
        // TODO implement here
    }

    /**
     * 
     */
    public void getSociosParticipes() {
        // TODO implement here
    }

    /**
     * @param socioId 
     * @param fecha
     */
    public void getMoraPorSocioPorFecha(int socioId, Date fecha) {
        // TODO implement here
    }

    /**
     * @param Cuit
     */
    public void getSocioParticipePorCUIT(String Cuit) {
        // TODO implement here
    }

    /**
     * @param Cuit
     */
    public void getSociosParticipePorAccionista(String Cuit) {
        // TODO implement here
    }

    /**
     * @param socioId
     */
    public void ConsultaConsolidadaPorSocioId(int socioId) {
        // TODO implement here
    }

    public Dictionary<String, Integer> getSociosConAccionesDisponibles(TipoSocio tipoSocio) throws Exception
    {
        Socio socio;
        GenericDAO dao = tipoSocio == TipoSocio.PARTICIPE ? socioParticipeDao : socioProtectorDao;
        Dictionary<String, Integer> dic = new Hashtable<String, Integer>();
        for(Object item: dao.getAll()){
            socio = (Socio)item;
                if(socio.accion > 1)
                    ((Hashtable<String, Integer>) dic).put(socio.cuit,Integer.valueOf(socio.accion));
        }
        return dic;
    }

    public void suscribirAcciones(Socio comprador, Socio vendedor, int cantidad) throws Exception {
        GenericDAO dao;

        if(comprador.tipoSocio != vendedor.tipoSocio ){
            throw new Exception("No se puede suscribir acciones entre socios de distinto tipo");
        }
        if(vendedor.accion < cantidad)
            throw new Exception("El socio vendedor no dispone de la cantidad solicitada.");

        dao = vendedor.tipoSocio == TipoSocio.PARTICIPE ? socioParticipeDao : socioProtectorDao;

        comprador.accion +=cantidad;
        vendedor.accion-=cantidad;

        dao.update(comprador);
        dao.update(vendedor);
    }
}