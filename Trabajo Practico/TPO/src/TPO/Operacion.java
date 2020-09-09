package TPO;

import java.text.DateFormat;

public class Operacion {
    int id;
    float Monto;
    DateFormat Fecha;
    String Estado;

    public Operacion(int id, float monto, DateFormat fecha, String estado) {
        this.id = id;
        Monto = monto;
        Fecha = fecha;
        Estado = estado;
    }
}
