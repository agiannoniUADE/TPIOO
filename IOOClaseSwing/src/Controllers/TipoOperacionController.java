package Controllers;

import DAO.SubtipoOperacionDao;
import DAO.TipoOperacionDao;
import model.Socio;
import model.SocioParticipe;
import model.SubtipoOperacion;
import model.TipoOperacion;

import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 */
public class TipoOperacionController {

    private TipoOperacionDao tipoOperacionDao;
    private SubtipoOperacionDao subtipoOperacionDao;

    static TipoOperacionController instance;

    public static TipoOperacionController getInstance() throws Exception {
        if (instance == null) {
            instance = new TipoOperacionController();
        }
        return instance;
    }

    private TipoOperacionController() throws Exception {
        tipoOperacionDao = new TipoOperacionDao();
        subtipoOperacionDao = new SubtipoOperacionDao();
    }

    public void saveTipoOperacion(List<TipoOperacion> tipos) throws Exception {

        tipoOperacionDao.saveAll(tipos);
    }


    public void saveSubTipoOperacion(List<SubtipoOperacion> s) throws Exception {

        subtipoOperacionDao.saveAll(s);
    }

    /**
     * @param IdTipoOperacion
     */
    public float getComsionPorTipo(int IdTipoOperacion, String cuit) throws Exception {
        SocioParticipe socio = SocioController.getInstance().getSocioParticipe(cuit);
        if(socio == null) {
            throw  new Exception("No existe el socio indicado.");
        } else if(!socio.tieneComisionPreferencial()){
            TipoOperacion tipo = (TipoOperacion) tipoOperacionDao.search(IdTipoOperacion);
            return tipo.getComision();
        }else{
            return socio.getComisionPreferencial();
        }
    }

    /**
     * @param IdTipoOperacion
     */
    public TipoOperacion getTipoOperacion(int IdTipoOperacion) throws FileNotFoundException {
        return (TipoOperacion) tipoOperacionDao.search(IdTipoOperacion);
    }

    /**
     * @param IdSubTipoOperacion
     */
    public SubtipoOperacion getSubtipoOperacion(int IdSubTipoOperacion) throws FileNotFoundException {
        return (SubtipoOperacion) subtipoOperacionDao.search(IdSubTipoOperacion);
    }

    public List<SubtipoOperacion> getAllSubtipos() throws Exception {
        return (List<SubtipoOperacion>)subtipoOperacionDao.getAll();
    }

    public List<TipoOperacion> getAlltipos() throws Exception {
        return (List<TipoOperacion>)tipoOperacionDao.getAll();
    }
}