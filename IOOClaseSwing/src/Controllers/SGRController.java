package Controllers;

import DAO.SGRDao;
import DAO.SocioParticipeDao;
import DAO.SocioProtectorDao;
import model.Aporte;
import model.SGR;
import model.Socio;
import model.SocioParticipe;

import java.util.List;

public class SGRController {

    SGRDao dao = new SGRDao();
    SocioProtectorDao sociosProtectorDao = new SocioProtectorDao();
    SocioParticipeDao sociosParticipeDao = new SocioParticipeDao();

    public SGRController() throws Exception {
    }

    /* //Se creo para instanciar la SGR, NO borrar!!
    public void saveSGR() throws Exception
    {

        SGR s = new SGR();
        s.id = 1;
        s.razonSocial = "Smart SGR SA";

        //Aporte
        Aporte a = new Aporte();
        a.setId(1);
        SocioProtector socioProtector =(SocioProtector) sociosDao.search(1);
        a.setSocio(socioProtector);
        a.setFechaInicio(new Date("12/10/2020"));
        a.setMonto(20000000);
        a.setEstado(false);

        Aporte a2 = new Aporte();
        a2.setId(1);
        a2.setSocio(socioProtector);
        a2.setFechaInicio(new Date("12/10/2015"));
        a2.setMonto(20000000);
        a2.setEstado(false);
        List<Aporte> aportes = new ArrayList<>();

        aportes.add(a);
        aportes.add(a2);
        //fin aportes
        s.setAportes(aportes);
        dao.save(s);
    }
    */

    public SGR GetSGR() throws Exception {
        SGR sgr =(SGR)dao.search(1);
        List<Socio> sociosProtectores =(List<Socio>) sociosProtectorDao.getAll();
        List<Socio> sociosParticipes =(List<Socio>) sociosParticipeDao.getAll();
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
        dao.update(1);
        return id;
    }
}
