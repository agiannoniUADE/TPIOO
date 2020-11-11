package model;

import java.util.Arrays;

public enum EstadoComision {
    CALCULADA("calculada"),
    FACTURADA("facturada");

    private final String name;

    EstadoComision(final String theName) {
        name = theName;
    }

    public static boolean isValidValue(final String value) {
        return value != null && Arrays.stream(EstadoComision.values())
            .anyMatch(e -> value.equalsIgnoreCase(e.toString()));
    }

    public static EstadoComision lookUp(final String value) {
        return Arrays.stream(EstadoComision.values())
            .filter(e -> value.equalsIgnoreCase(e.toString()))
            .findFirst()
            .orElse(null);
    }
}