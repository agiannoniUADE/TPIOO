package TPO;

import java.text.DateFormat;

public class LineaDeCredito {

    int id;
    DateFormat fechaVigencia;
    float montoAsignado;

    public LineaDeCredito(int id, DateFormat fechaVigencia, float montoAsignado) {
        this.id = id;
        this.fechaVigencia = fechaVigencia;
        this.montoAsignado = montoAsignado;
    }
}
