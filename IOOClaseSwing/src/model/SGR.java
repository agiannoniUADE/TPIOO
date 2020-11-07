package model;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 */
public class SGR {

    /**
     * Default constructor
     */
    public SGR() {
        socios = new ArrayList<>();
        aportes = new ArrayList<>();
    }

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    private String razonSocial;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

    private List<Aporte> aportes;

    private List<Socio> socios;


    public List<Socio> getSocios() {
        return socios;
    }

    public void addSocios(List<Socio> socios) {
        if(socios != null)
            this.socios.addAll(socios);
    }


    public List<Aporte> getAportes() {
        return aportes;
    }

    public void setAportes(List<Aporte> aportes) {
        this.aportes = aportes;
    }

    public int addAportes(Aporte aporte) {
        int id  = aportes.size()+1;
        aporte.setId(id);
        this.aportes.add(aporte);
        return id;
    }


    /**
     * 
     */
    public void getRiesgoVivo() {
        // TODO implement here
    }
    /**
     *
     */
    public float calcularFondoDeRiego() {
        double response =   aportes.stream().filter(x -> !x.FueRetirado())
            .map(x -> x.getMonto())
            .collect(Collectors.summingDouble(Float::doubleValue));

        return (float)response;
    }

    /**
     *
     */
    private void getSocioParticipe() {
        // TODO implement here
    }

    /**
     * @param id
     */
    public Aporte getAporte(int id) {
        return aportes.stream().filter(e -> id == e.getId())
            .findFirst()
            .orElse(null);
    }

    /**
     * @param id
     */
    public Socio getSocio(int id) {
        return socios.stream().filter(e -> id == e.getId())
            .findFirst()
            .orElse(null);
    }

    public void retirarAporte(int id) throws Exception {
       Aporte aporte = getAporte(id);
       if(aporte == null){
           throw new Exception("No se pudo encontrar el aporte indicado.");
       } else if(!aporte.estaDisponibleParaRetiro()){
           throw new Exception("No se puede retirar un aporte antes de transcurrido dos años.");
       }else if(aporte.FueRetirado()){
           throw new Exception("El aporte ya fue retirado");
       }else{
           aporte.setRetirado(true);
       }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SGR sgr = (SGR) o;
        return id == sgr.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, razonSocial, aportes, socios);
    }
}