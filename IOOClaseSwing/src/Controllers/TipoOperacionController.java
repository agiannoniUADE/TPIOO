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

        t.id = 1;
        t.descripcion = "tipo 1";
        t.comision = 0.03f;

        TipoOperacion t2 = new TipoOperacion();

        t2.id = 2;
        t2.descripcion = "tipo 2";
        t2.comision = 0.03f;

        TipoOperacion t3 = new TipoOperacion();

        t3.id = 3;
        t3.descripcion = "tipo 3";
        t3.comision = 0.04f;

        SubtipoOperacion s1 = new SubtipoOperacion();
        s1.id = 1;
        s1.descripcion = "Cheques propios";
        //s1.tipoOperacion = t;

        SubtipoOperacion s2 = new SubtipoOperacion();
        s2.id = 2;
        s2.descripcion = "Cheques de terceros";
        //s2.tipoOperacion = t;

        SubtipoOperacion s3 = new SubtipoOperacion();
        s3.id = 3;
        s3.descripcion = "Pagaré Bursatil";
        //s3.tipoOperacion = t;

        SubtipoOperacion s4 = new SubtipoOperacion();
        s4.id = 4;
        s4.descripcion = "Cuentas corrientes Comerciales";
        //s4.tipoOperacion = t2;

        SubtipoOperacion s5 = new SubtipoOperacion();
        s5.id = 5;
        s5.descripcion = "Tarjetas de crédito";
        //s5.tipoOperacion = t2;

        SubtipoOperacion s6 = new SubtipoOperacion();
        s6.id = 6;
        s6.descripcion = "Prestamos";
        //s6.tipoOperacion = t3;

        t.subtipoOperacion.add(s1);
        t.subtipoOperacion.add(s2);
        t.subtipoOperacion.add(s3);

        t2.subtipoOperacion.add(s4);
        t2.subtipoOperacion.add(s5);

        t3.subtipoOperacion.add(s6);

        List<TipoOperacion> tipos = new ArrayList();

        tipos.add(t);
        tipos.add(t2);
        tipos.add(t3);

        tipoOperacionDao.saveAll(tipos);
    }


    public void saveSubTipoOperacion() throws Exception {

        TipoOperacion t = new TipoOperacion();

        t.id = 1;
        t.descripcion = "tipo 1";
        t.comision = 0.03f;

        TipoOperacion t2 = new TipoOperacion();

        t2.id = 2;
        t2.descripcion = "tipo 2";
        t2.comision = 0.03f;

        TipoOperacion t3 = new TipoOperacion();

        t3.id = 3;
        t3.descripcion = "tipo 3";
        t3.comision = 0.04f;

        SubtipoOperacion s1 = new SubtipoOperacion();
        s1.id = 1;
        s1.descripcion = "Cheques propios";
        s1.tipoOperacion = t;

        SubtipoOperacion s2 = new SubtipoOperacion();
        s2.id = 2;
        s2.descripcion = "Cheques de terceros";
        s2.tipoOperacion = t;

        SubtipoOperacion s3 = new SubtipoOperacion();
        s3.id = 3;
        s3.descripcion = "Pagaré Bursatil";
        s3.tipoOperacion = t;

        SubtipoOperacion s4 = new SubtipoOperacion();
        s4.id = 4;
        s4.descripcion = "Cuentas corrientes Comerciales";
        s4.tipoOperacion = t2;

        SubtipoOperacion s5 = new SubtipoOperacion();
        s5.id = 5;
        s5.descripcion = "Tarjetas de crédito";
        s5.tipoOperacion = t2;

        SubtipoOperacion s6 = new SubtipoOperacion();
        s6.id = 6;
        s6.descripcion = "Prestamos";
        s6.tipoOperacion = t3;


        List<SubtipoOperacion> subTipos = new ArrayList();

        subTipos.add(s1);
        subTipos.add(s2);
        subTipos.add(s3);
        subTipos.add(s4);
        subTipos.add(s5);
        subTipos.add(s6);

        subtipoOperacionDao.saveAll(subTipos);
    }

    /**
     * @param IdTipoOperacion
     */
    public float getComsionPorTipo(int IdTipoOperacion) throws FileNotFoundException {
        TipoOperacion tipo =(TipoOperacion)tipoOperacionDao.search(1);
        return tipo.comision;
    }

    /**
     * @param IdTipoOperacion
     */
    public TipoOperacion getTipoOperacion(int IdTipoOperacion) throws FileNotFoundException {
        return (TipoOperacion)tipoOperacionDao.search(1);
    }

}