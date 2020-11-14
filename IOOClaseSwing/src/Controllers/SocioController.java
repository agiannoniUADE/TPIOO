package Controllers;

import DAO.GenericDAO;
import DAO.SocioParticipeDao;
import DAO.SocioProtectorDao;
import model.*;
import utils.Logger;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class SocioController {

    private SocioParticipeDao socioParticipeDao;
    private SocioProtectorDao socioProtectorDao;


    static SocioController instance;

    public static SocioController getInstance() throws Exception {
        if (instance == null) {
            instance = new SocioController();
        }
        return instance;
    }

    /**
     * Default constructor
     */
    private SocioController() throws Exception {
        this.socioParticipeDao = new SocioParticipeDao();
        this.socioProtectorDao = new SocioProtectorDao();
    }

    public int AgregarNuevoSocio(Socio socio) throws Exception {
        GenericDAO dao = socio.getTipoSocio() == TipoSocio.PARTICIPE ? socioParticipeDao : socioProtectorDao;
        if (socio.getTipoSocio() == TipoSocio.PROTECTOR) {
            if (!ValidatorVO.ValidarSocioProtector(socio.getCuit())) {
                throw new Exception("Un socio protector no puede ser accionista de un socio participe.");
            }
        }
        int lastId = dao.getLastInsertId();
        lastId++;
        socio.setId(lastId);
        dao.save(socio);
        return lastId;
    }

    /**
     * @param id
     */
    public SocioParticipe getSocioParticipe(int id) throws FileNotFoundException {

        Object obj = socioParticipeDao.search(id);
        return obj != null ? (SocioParticipe) obj : null;
    }

    public SocioParticipe getSocioParticipe(String cuit) throws Exception {

        List<SocioParticipe> obj = socioParticipeDao.getAll();
        return obj.stream()
            .filter(e -> cuit.equalsIgnoreCase(e.getCuit()))
            .findFirst()
            .orElse(null);
    }

    public Socio getSocioProtector(int id) throws FileNotFoundException {
        Object obj = socioProtectorDao.search(id);
        return obj != null ? (Socio) obj : null;
    }

    public SocioProtector getSocioProtector(String cuit) throws Exception {

        List<SocioProtector> obj = socioProtectorDao.getAll();
        return obj.stream()
            .filter(e -> cuit.equalsIgnoreCase(e.getCuit()))
            .findFirst()
            .orElse(null);
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


    public int getLastInsertId() throws Exception {
        return socioParticipeDao.getLastInsertId();
    }

    public List<SocioParticipe> getSociosParticipe() throws Exception {
        List<SocioParticipe> lista = socioParticipeDao.getAll();
        return lista;
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
    public void getMoraPorSocioPorFecha(int socioId, LocalDate fecha) {
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


    public Socio getSocioByCuit (String cuit) throws Exception {

        Socio socio= null;

        if (this.getSocioParticipe(cuit) != null){
            socio = this.getSocioParticipe(cuit);
        } else {
            socio = this.getSocioProtector(cuit);
        }

        return socio;
    }


    public Dictionary<String, Integer> getSociosConAccionesDisponibles(TipoSocio tipoSocio) throws Exception {
        Socio socio;
        GenericDAO dao = tipoSocio == TipoSocio.PARTICIPE ? socioParticipeDao : socioProtectorDao;
        Dictionary<String, Integer> dic = new Hashtable<String, Integer>();
        for (Object item : dao.getAll()) {
            socio = (Socio) item;
            if (socio.getAccion() > 1)
                ((Hashtable<String, Integer>) dic).put(socio.getCuit(), Integer.valueOf(socio.getAcciones()));
        }
        return dic;
    }

    public void suscribirAcciones(Socio comprador, Socio vendedor, int cantidad) throws Exception {
        GenericDAO dao;

        if (comprador.getTipoSocio() != vendedor.getTipoSocio()) {
            throw new Exception("No se puede suscribir acciones entre socios de distinto tipo");
        }
        if (vendedor.getAccion() < cantidad)
            throw new Exception("El socio vendedor no dispone de la cantidad solicitada.");

        dao = vendedor.getTipoSocio() == TipoSocio.PARTICIPE ? socioParticipeDao : socioProtectorDao;

        int accionesNuevas = comprador.getAcciones() + cantidad;
        int restaAciones = vendedor.getAcciones() - cantidad;
        comprador.setAccion(accionesNuevas);
        vendedor.setAccion(restaAciones);
        comprador.setEstado(EstadoSocio.SOCIO_PLENO);

        dao.update(comprador);
        dao.update(vendedor);
    }

    public List<SocioParticipe> getSociosQuetienenLosMismosAccionistas(String cuit) throws Exception {

        SocioParticipe socio = this.getSocioParticipe(cuit);
        List<SocioParticipe> respuesta = new ArrayList<>();

        for (Accionista a : socio.getAccionistas()) {
            for (SocioParticipe s : this.getSociosParticipe()){
                if (!s.getCuit().equals(cuit) && s.getAccionista(a.getCuit()) != null){
                    if(!respuesta.contains(s)){
                        respuesta.add(s);
                    }
                }
            }
        }

        return respuesta ;
    }
    public void cambiarEstadoSocio (String cuit) throws Exception {


        SocioController sc = SocioController.getInstance();

        Socio socio = sc.getSocioByCuit(cuit);


        if (socio == null) {
            throw new Exception("El Socio no existe");
        }

        GenericDAO dao = socio.getTipoSocio() == TipoSocio.PARTICIPE ? socioParticipeDao : socioProtectorDao;




        if (socio.getEstado() == EstadoSocio.SOCIO_PLENO) {
            throw new Exception("Un Socio Pleno no puede cambiar su estado a postulante");
        }
        if (socio.getAcciones() <= 0) {
            throw new Exception("El socio no tiene acciones, suscriba acciones y vuelva a intentarlo");
        }
        if (socio.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO) {
            socio.setEstado(EstadoSocio.SOCIO_PLENO);
        }

        dao.update(socio);

        Logger logger=Logger.getInstance();

        logger.log(socio.getId(),TipoLog.SOCIOS,EstadoSocio.POSTULANTE_A_SOCIO.toString(),EstadoSocio.SOCIO_PLENO.toString(),LocalDate.now(),"usuario1");


    }
}