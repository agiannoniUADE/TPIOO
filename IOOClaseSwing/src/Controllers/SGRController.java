package Controllers;

import DAO.SGRDao;
import DAO.SocioParticipeDao;
import DAO.SocioProtectorDao;
import model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class SGRController {

    SGRDao dao = new SGRDao();
    SocioProtectorDao sociosProtectorDao = new SocioProtectorDao();
    SocioParticipeDao sociosParticipeDao = new SocioParticipeDao();

    public SGRController() throws Exception {
    }

    //Se creo para instanciar la SGR, NO borrar!!
    public void saveSGR(SGR s) throws Exception {
        dao.save(s);
    }


    public SGR GetSGR() throws Exception {
        SGR sgr = (SGR) dao.search(1);
        List<Socio> sociosProtectores = (List<Socio>) sociosProtectorDao.getAll();
        List<Socio> sociosParticipes = (List<Socio>) sociosParticipeDao.getAll();
        sgr.addSocios(sociosProtectores);
        sgr.addSocios(sociosParticipes);

        return sgr;
    }

    public void RetirarAportes(int id) throws Exception {
        SGR sgr = GetSGR();
        sgr.retirarAporte(id);
        dao.update(1);
    }

    public int agregarAporte(Aporte obj) throws Exception {
        SGR sgr = GetSGR();
        int id = sgr.addAportes(obj);
        dao.update(sgr);
        return id;
    }
}
