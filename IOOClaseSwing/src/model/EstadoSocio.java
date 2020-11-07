package model;

import java.util.Arrays;

public enum EstadoSocio {
    POSTULANTE_A_SOCIO("postulante a socio"),
    SOCIO_PLENO("socio pleno");

    private final String name;

    EstadoSocio(final String theName) {
        name = theName;
    }

    public static boolean isValidValue(final String value) {
        return value != null && Arrays.stream(EstadoSocio.values())
            .anyMatch(e -> value.equalsIgnoreCase(e.toString()));
    }

    public static EstadoSocio lookUp(final String value) {
        return Arrays.stream(EstadoSocio.values())
            .filter(e -> value.equalsIgnoreCase(e.toString()))
            .findFirst()
            .orElse(null);
    }
}