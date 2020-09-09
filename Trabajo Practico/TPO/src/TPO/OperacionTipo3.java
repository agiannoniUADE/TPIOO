package TPO;

import java.text.DateFormat;

public class OperacionTipo3 {

    int id;
    String Entidad;
    float Monto;
    float Tasa;
    DateFormat fechaDeAcreditacion;
    int cantidadDeCuotas;
    String sistemaDeAmortizacion;

    public OperacionTipo3(int id, String entidad, float monto, float tasa, DateFormat fechaDeAcreditacion, int cantidadDeCuotas, String sistemaDeAmortizacion) {
        this.id = id;
        Entidad = entidad;
        Monto = monto;
        Tasa = tasa;
        this.fechaDeAcreditacion = fechaDeAcreditacion;
        this.cantidadDeCuotas = cantidadDeCuotas;
        this.sistemaDeAmortizacion = sistemaDeAmortizacion;
    }
}
