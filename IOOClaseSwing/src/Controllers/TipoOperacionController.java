package Controllers;

import DAO.SubtipoOperacionDao;
import DAO.TipoOperacionDao;
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

    public TipoOperacionController() throws Exception {
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
    public float getComsionPorTipo(int IdTipoOperacion) throws FileNotFoundException {
        TipoOperacion tipo = (TipoOperacion) tipoOperacionDao.search(IdTipoOperacion);
        return tipo.getComision();
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