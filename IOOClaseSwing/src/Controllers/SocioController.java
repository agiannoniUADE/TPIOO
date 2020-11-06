package Controllers;
import DAO.SocioParticipeDao;
import model.Socio;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 */
public class SocioController {

  private SocioParticipeDao sociosDao;

    /**
     * Default constructor
     */
    public SocioController() throws Exception {
      this.sociosDao = new SocioParticipeDao();
    }

    public int AgregarNuevoSocio(Socio socio) throws Exception {
      int lastId = sociosDao.getLastInsertId();
        lastId++;
        socio.setId(lastId);
        sociosDao.save(socio);
      return lastId;
    }
    /**
     * @param id
     */
    public Socio getSocioParticipe(int id) throws FileNotFoundException {

      Object obj = sociosDao.search(id);
      return obj != null ? (Socio)obj: null;
    }

  /**
   * @param obj
   */
  public Boolean updateSocio(Socio obj) throws Exception {

   return sociosDao.update(obj);
  }

  /**
   * @param id
   */
  public Boolean delete(int id) throws Exception {

    return sociosDao.delete(id);
  }


  public int getLastInsertId() throws Exception
  {
    return sociosDao.getLastInsertId();
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

}