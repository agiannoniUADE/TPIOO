package modelo;

public class Usuario {
    private String dni;
    private String nombre;
    private String rol;

    public Usuario(String dni, String nombre, String rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getRol() {
        return this.rol;
    }

}
