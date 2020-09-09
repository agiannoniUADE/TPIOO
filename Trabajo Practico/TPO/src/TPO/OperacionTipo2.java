package TPO;

import java.text.DateFormat;

public class OperacionTipo2 {
    int id;
    String Entidad;
    float Monto;
    DateFormat fechaDeVencimiento;

    public OperacionTipo2(int id, String entidad, float monto, DateFormat fechaDeVencimiento) {
        this.id = id;
        Entidad = entidad;
        Monto = monto;
        this.fechaDeVencimiento = fechaDeVencimiento;
    }
}
