package model;

import java.util.Arrays;

/**
 *
 */
public enum EstadoOperacion {
    INGRESADO("Ingresado"),
    CERTIFICADO_EMITIDO("Certificado emitido"),
    MONETIZADO("Monetizado");

    private final String name;

    EstadoOperacion(final String theName) {
        name = theName;
    }

    public static boolean isValidValue(final String value) {
        return value != null && Arrays.stream(EstadoOperacion.values())
            .anyMatch(e -> value.equalsIgnoreCase(e.toString()));
    }

    public static EstadoOperacion lookUp(final String value) {
        return Arrays.stream(EstadoOperacion.values())
            .filter(e -> value.equalsIgnoreCase(e.toString()))
            .findFirst()
            .orElse(null);
    }
}