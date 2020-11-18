package Controllers;

import DAO.SGRDao;
import DAO.SocioParticipeDao;
import DAO.SocioProtectorDao;
import model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SGRController {

    SGRDao dao;
    SocioProtectorDao sociosProtectorDao;
    SocioParticipeDao sociosParticipeDao;

    static SGRController instance;

    public static SGRController getInstance() throws Exception {
        if (instance == null) {
            instance = new SGRController();
        }
        return instance;
    }

    private SGRController() throws Exception {
        sociosProtectorDao = new SocioProtectorDao();
        sociosParticipeDao = new SocioParticipeDao();
        dao = new SGRDao();
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
        dao.update(sgr);
    }

    public int agregarAporte(Aporte obj) throws Exception {
        SGR sgr = GetSGR();
        int id = sgr.addAportes(obj);
        dao.update(sgr);
        return id;
    }

    public List<Aporte> listarAportesXsocio(String cuit) throws Exception {
        SGR sgr = GetSGR();

        return sgr.getAportes()
            .stream()
            .filter(x -> x.getSocio().getCuit().equals(cuit))
            .collect(Collectors.toList());
    }

    public void HacerDesembolso(int idOperacion) throws Exception {

        OperacionController operacionController = OperacionController.getInstance();

        Operacion operacion = (Operacion) operacionController.getOperacionSafely(idOperacion);

        if (operacion == null) {
            throw new Exception("la operacion no existe.");
        }

        if (operacion.getEstado() != EstadoOperacion.MONETIZADO) {
            throw new Exception("la operacion debe estar monetizada'.");
        }

        if (operacion.getFechaVencimiento().compareTo(LocalDate.now()) > 0) {
            throw new Exception("la operacion debe estar vencida.");
        }
        Desembolso desembolso = new Desembolso();
        desembolso.setMontoAdeudado(operacion.getMora());
        desembolso.setIdOperacion(operacion.getId());

        SGR sgr = GetSGR();
        int id = sgr.addDesembolsos(desembolso);
        dao.update(sgr);

        desembolso.setId(id);

        operacionController.guardarDesembolso(idOperacion, desembolso);

    }
}
