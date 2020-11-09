package model;

import java.util.Arrays;

public enum EstadoCuotas {
    EN_FECHA("en fecha"),
    PAGADA("pagada"),
    VENCIDA("vencida");

    private final String name;

    EstadoCuotas(final String theName) {
        name = theName;
    }

    public static boolean isValidValue(final String value) {
        return value != null && Arrays.stream(EstadoCuotas.values())
            .anyMatch(e -> value.equalsIgnoreCase(e.toString()));
    }

    public static EstadoCuotas lookUp(final String value) {
        return Arrays.stream(EstadoCuotas.values())
            .filter(e -> value.equalsIgnoreCase(e.toString()))
            .findFirst()
            .orElse(null);
    }
}