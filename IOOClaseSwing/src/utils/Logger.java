package utils;

import DAO.LogDao;
import model.TipoLog;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Logger {

    private int id;
    private int idEntidad;

    private Logger(int idEntidad, String estadoAnterior, String estadoActual, TipoLog tipoLog, LocalDate fecha, String nombreUsuario) {
        this.idEntidad = idEntidad;
        this.estadoAnterior = estadoAnterior;
        this.estadoActual = estadoActual;
        this.tipoLog = tipoLog;
        this.fecha = fecha;
        this.nombreUsuario = nombreUsuario;
    }

    private String estadoAnterior;
    private String estadoActual;
    private TipoLog tipoLog;
    private LocalDate fecha;
    private String nombreUsuario;
    private LogDao logDao;
    private static Logger log;

    private Logger() throws Exception {
        logDao = new LogDao();
    }

    public static Logger getInstance() throws Exception {
        if (log == null) {
            log = new Logger();
        }
        return log;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public TipoLog getTipoLog() {
        return tipoLog;
    }

    public void setTipoLog(TipoLog tipoLog) {
        this.tipoLog = tipoLog;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void log(int idEntidad, TipoLog tipoLog, String estadoAnterior, String estadoActual, LocalDate fecha, String nombreUsuario) throws Exception {
        this.idEntidad = idEntidad;
        this.estadoAnterior = estadoAnterior;
        this.estadoActual = estadoActual;
        this.tipoLog = tipoLog;
        this.fecha = fecha;
        this.nombreUsuario = nombreUsuario;

        Logger log = new Logger(idEntidad, estadoAnterior, estadoActual, tipoLog, LocalDate.now(), nombreUsuario);
        log.id = logDao.getLastInsertId() + 1;

        logDao.save(log);
    }

    public List<Logger> getLogs() throws Exception {
        return (List<Logger>) logDao.getAll();
    }

    public List<Logger> getLogs(int idEntidad, TipoLog tipoLog) throws Exception {
        return (List<Logger>) logDao.getAll()
            .stream()
            .filter((x -> ((Logger) x).idEntidad == idEntidad && ((Logger) x).tipoLog == tipoLog))
            .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logger logger = (Logger) o;
        return id == logger.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

