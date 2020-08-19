package ejercicio;

public class main {

	public static void main(String[] args) {
	
		Pais pais1 = new Pais("Argentina");
		Provincia prov1 = new Provincia("Buenos aires");
		Provincia prov2 = new Provincia("Misiones");
		Provincia prov3 = new Provincia("Neuquen");
	
		System.out.println(pais1.getNombre());
		pais1.generarProvincias("Buenos aires");
		pais1.generarProvincias("Salta");
		
		pais1.listarProvincias();
		
		
		Continente c = new Continente("Africa");
		
		c.setNombre("America");
	}
}


