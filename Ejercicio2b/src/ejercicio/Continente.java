package ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Continente {

	private String nombre;
	private List<Pais> paises = new ArrayList<Pais>();
	
	public Continente(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
