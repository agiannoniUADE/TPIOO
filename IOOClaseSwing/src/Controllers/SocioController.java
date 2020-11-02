package Controllers;
import DAO.SociosDao;
import model.Socio;

import java.util.*;

/**
 * 
 */
public class SocioController {

  private SociosDao sociosDao;

    /**
     * Default constructor
     */
    public SocioController() throws Exception {
      this.sociosDao = new SociosDao();
    }

    public boolean AgregarNuevoSocio(Socio socio){
      try {
        int lastId = sociosDao.getLastInsertId();
        lastId++;
        socio.setId(lastId);
        sociosDao.save(socio);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return true;
    }
    /**
     * @param id
     */
    public void getSocioParticipe(int id) {
        // TODO implement here
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