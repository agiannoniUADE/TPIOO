package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

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
    FileWriter fileWriter = new FileWriter(archivo, true);
    fileWriter.write(texto);
    BufferedWriter bwEscritor = new BufferedWriter(fileWriter);
    bwEscritor.close();
    getLastInsertId();

  }

  public int getLastInsertId() throws Exception {

    BufferedReader input = new BufferedReader(new FileReader(archivo));
    String last = "";
    String line;
    String index = "0";

    while ((line = input.readLine()) != null) {
      last = line;
    }

    if (last != "") {
      index = last.substring(last.indexOf(":") + 1, last.indexOf(","));
    }
    return Integer.parseInt(index);
  }

  public boolean delete() throws Exception {
    //TODO
    return true;
  }

  public boolean update(T obj) throws Exception {
    try {
      BufferedReader b = new BufferedReader(new FileReader(archivo));
      StringBuffer inputBuffer = new StringBuffer();
      String line;
      JsonParser parser = new JsonParser();
      Gson g = new Gson();
      Boolean flag = false;

      while ((line = b.readLine()) != null) {
        JsonObject jsonObject = parser.parse(line).getAsJsonObject();
        if(Integer.parseInt(jsonObject.get("id").toString())== 2) {
          line = g.toJson(obj);
        }
        inputBuffer.append(line);
        inputBuffer.append('\n');
      }
      b.close();
      String inputStr = inputBuffer.toString();

      System.out.println(inputStr); // display the original file for debugging

      // display the new file for debugging
      System.out.println("----------------------------------\n" + inputStr);

      // write the new string with the replaced line OVER the same file
      FileOutputStream fileOut = new FileOutputStream(archivo);
      fileOut.write(inputStr.getBytes());
      fileOut.close();

    } catch (Exception e) {
      System.out.println("Problem reading file.");
    }
    return true;
  }

  public T search(int id) throws FileNotFoundException {
      BufferedReader b = new BufferedReader(new FileReader(archivo));
      String line;
      JsonParser parser = new JsonParser();
      Gson g = new Gson();
      Boolean flag = false;

    try {
        while ((line = b.readLine()) != null && flag == false) {
          JsonObject jsonObject = parser.parse(line).getAsJsonObject();
          if(Integer.parseInt(jsonObject.get("id").toString())== id) {
            b.close();
            return g.fromJson(jsonObject, clase);
          }
        }
      b.close();
    } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }

}
