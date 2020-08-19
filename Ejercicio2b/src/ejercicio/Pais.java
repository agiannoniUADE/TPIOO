package ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	
	private String nombre;
	private List<Provincia> provincias = new ArrayList<Provincia>();
	private List<Pais> paisesLimitrofes = new ArrayList<Pais>();
	
	
	public Pais(String nombre) {
		this.nombre = nombre;
	}

	public void generarProvincias (String nombre){
		provincias.add(new Provincia(nombre));
	}
	
	public void listarProvincias() {
		for (Provincia item: provincias) {
			System.out.println(item.GetNombre());
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
