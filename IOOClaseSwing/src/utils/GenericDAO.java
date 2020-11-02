package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public abstract class GenericDAO<T> {
    final Class<T> clase;
	protected File archivo;
	
	public GenericDAO(Class<T> clase, String file) throws Exception {
        this.clase = clase;

		this.archivo = new File(file);
		this.archivo.createNewFile();
    }

	public List<T> getAll() throws Exception {
		List<T> list = new ArrayList<T>();
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		
		try {
			String cadena = b.readLine();
			
			if (cadena == null) {
				this.saveAll(list);
				cadena = "[]";
			}
			
			JsonParser parser = new JsonParser();
			JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
			Gson g = new Gson();
			for (JsonElement js : gsonArr) {
				list.add(g.fromJson(js, clase));
			}
			b.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public void saveAll(List<T> list) throws Exception {
		Gson g = new Gson();
		String texto = g.toJson(list);
		FileWriter fileWriter = new FileWriter(archivo);
		fileWriter.write(texto);
		BufferedWriter bwEscritor = new BufferedWriter(fileWriter);
		bwEscritor.close();
	}

  public void save(T obj) throws Exception {
    Gson g = new Gson();
    String texto = g.toJson(obj);
    texto = texto.concat(System.lineSeparator());
    FileWriter fileWriter = new FileWriter(archivo,true);
    fileWriter.write(texto);
    BufferedWriter bwEscritor = new BufferedWriter(fileWriter);
    bwEscritor.close();
    getLastInsertId();

  }

  public int getLastInsertId()throws Exception {

	  BufferedReader input = new BufferedReader(new FileReader(archivo));
    String last="";
    String line;
    String index = "0";

    while ((line = input.readLine()) != null) {
      last = line;
    }

    if(last != "") {
       index = last.substring(last.indexOf(":") + 1, last.indexOf(","));
    }
    return Integer.parseInt(index);
  }

}
