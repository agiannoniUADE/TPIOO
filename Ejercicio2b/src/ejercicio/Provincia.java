package ejercicio;

import java.util.ArrayList;
import java.util.List;


public class Provincia {
	
	private String nombre;
	private Boolean capital;
	private List<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	
	
	public void generarCiudades (String nombre){
		ciudades.add(new Ciudad(nombre));
	}
	
	public void listarCiudades() {
		for (Ciudad item: ciudades) {
			System.out.println(item.GetNombre());
		}
	}
	public Provincia(String nombre) {
		this.nombre = nombre;
	}

	public String GetNombre() {
		return this.nombre;
	}
}
