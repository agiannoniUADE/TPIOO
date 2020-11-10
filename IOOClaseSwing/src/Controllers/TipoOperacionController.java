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

    public void saveTipoOperacion() throws Exception {

        TipoOperacion t = new TipoOperacion();

        t.setId(1);
        t.setDescripcion("tipo 1");
        t.setComision(0.03f);

        TipoOperacion t2 = new TipoOperacion();

        t2.setId(2);
        t2.setDescripcion("tipo 2");
        t2.setComision(0.03f);

        TipoOperacion t3 = new TipoOperacion();

        t3.setId(3);
        t3.setDescripcion("tipo 3");
        t3.setComision(0.04f);

        SubtipoOperacion s1 = new SubtipoOperacion();
        s1.setId(1);
        s1.setDescripcion("Cheques propios");
        //s1.tipoOperacion = t;

        SubtipoOperacion s2 = new SubtipoOperacion();
        s2.setId(2);
        s2.setDescripcion("Cheques de terceros");
        //s2.tipoOperacion = t;

        SubtipoOperacion s3 = new SubtipoOperacion();
        s3.setId(3);
        s3.setDescripcion("Pagaré Bursatil");
        //s3.tipoOperacion = t;

        SubtipoOperacion s4 = new SubtipoOperacion();
        s4.setId(4);
        s4.setDescripcion("Cuentas corrientes Comerciales");
        //s4.tipoOperacion = t2;

        SubtipoOperacion s5 = new SubtipoOperacion();
        s5.setId(5);
        s5.setDescripcion("Tarjetas de crédito");
        //s5.tipoOperacion = t2;

        SubtipoOperacion s6 = new SubtipoOperacion();
        s6.setId(6);
        s6.setDescripcion("Prestamos");
        //s6.tipoOperacion = t3;

        t.setSubtipoOperacion(Arrays.asList(s1, s2, s3));
        t2.setSubtipoOperacion(Arrays.asList(s4, s5));
        t3.setSubtipoOperacion(Arrays.asList(s6));

        tipoOperacionDao.saveAll(Arrays.asList(t, t2, t3));
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
}