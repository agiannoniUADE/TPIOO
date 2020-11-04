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

  public boolean delete(int id) throws Exception {
    boolean wasDeleted = false;
    try {
      BufferedReader b = new BufferedReader(new FileReader(archivo));
      StringBuffer inputBuffer = new StringBuffer();
      String line;
      JsonParser parser = new JsonParser();

      while ((line = b.readLine()) != null) {
        JsonObject jsonObject = parser.parse(line).getAsJsonObject();
        if(Integer.parseInt(jsonObject.get("id").toString())!= id) {
          inputBuffer.append(line);
          inputBuffer.append('\n');
        } else{
          wasDeleted = true;
        }
      }
      b.close();
      String inputStr = inputBuffer.toString();

      System.out.println(inputStr);

      FileOutputStream fileOut = new FileOutputStream(archivo);
      fileOut.write(inputStr.getBytes());
      fileOut.close();

    } catch (Exception e) {
      System.out.println("Problem reading file.");
    }
    return wasDeleted;
  }

  public boolean update(T obj) throws Exception {
    Boolean wasUpdate = false;
    try {
      BufferedReader b = new BufferedReader(new FileReader(archivo));
      StringBuffer inputBuffer = new StringBuffer();
      String line;
      JsonParser parser = new JsonParser();
      Gson g = new Gson();

      while ((line = b.readLine()) != null) {
        JsonObject jsonObject = parser.parse(line).getAsJsonObject();
        if(g.fromJson(jsonObject, clase).equals(obj)){
          line = g.toJson(obj);
          wasUpdate = true;
        }
        inputBuffer.append(line);
        inputBuffer.append('\n');
      }
      b.close();
      String inputStr = inputBuffer.toString();

      System.out.println(inputStr);

      FileOutputStream fileOut = new FileOutputStream(archivo);
      fileOut.write(inputStr.getBytes());
      fileOut.close();

    } catch (Exception e) {
      System.out.println("Problem reading file.");
    }
    return wasUpdate;
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
