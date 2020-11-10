package model;

import java.util.Arrays;

/**
 *
 */

public enum TipoSocio {
    PARTICIPE("participe"),
    PROTECTOR("protector");

    private final String name;

    TipoSocio(final String theName) {
        name = theName;
    }

    public static boolean isValidValue(final String value) {
        return value != null && Arrays.stream(TipoSocio.values())
            .anyMatch(e -> value.equalsIgnoreCase(e.toString()));
    }

    public static TipoSocio lookUp(final String value) {
        return Arrays.stream(TipoSocio.values())
            .filter(e -> value.equalsIgnoreCase(e.toString()))
            .findFirst()
            .orElse(null);
    }
}


