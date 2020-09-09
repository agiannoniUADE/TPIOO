package TPO;

import java.text.DateFormat;

public class Socio {

    String cuit;
    String tipoSocio;
    String estado;
    String razonSocial;
    DateFormat fechaInicioActividad;
    String actividadPrincipal;
    String direccion;
    String telefono;
    String correoElectronico;
    int Accion;

    public Socio ( String Cuit, String tipoSocio, String Estado, String razonSocial, DateFormat fechaInicioActividad, String actividadPrincipal, String Direccion, String Telefono, String Email, int Accion){
        this.Cuit = Cuit;
        this.tipoSocio = tipoSocio;
        this.Estado = Estado;
        this.razonSocial = razonSocial;
        this.fechaInicioActividad = fechaInicioActividad;
        this.actividadPrincipal = actividadPrincipal;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Accion = Accion;

    }



}
