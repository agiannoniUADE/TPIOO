package TPO;

import java.text.DateFormat;

public class OperacionTipo1 {

    int id;
    String Entidad;
    int numeroDeCheque;
    DateFormat fechaDeVencimiento;
    int Cuit;

    public OperacionTipo1(int id, String entidad, int numeroDeCheque, DateFormat fechaDeVencimiento, int cuit) {
        this.id = id;
        Entidad = entidad;
        this.numeroDeCheque = numeroDeCheque;
        this.fechaDeVencimiento = fechaDeVencimiento;
        Cuit = cuit;
    }
}
