package model;

import java.util.Arrays;

public enum TipoDocumento {
    CONTRATO_SOCIAL("Contrato Social"),
    BALANCE_CERTIFICADO("balances certificados"),
    MANIFESTACION_BIENES("Manifestación de bienes");

    private final String name;

    TipoDocumento(final String theName) {
        name = theName;
    }

    public static boolean isValidValue(final String value) {
        return value != null && Arrays.stream(TipoDocumento.values())
            .anyMatch(e -> value.equalsIgnoreCase(e.toString()));
    }

    public static TipoDocumento lookUp(final String value) {
        return Arrays.stream(TipoDocumento.values())
            .filter(e -> value.equalsIgnoreCase(e.toString()))
            .findFirst()
            .orElse(null);
    }

    public static TipoDocumento lookUpWithName(final String value) {
        return Arrays.stream(TipoDocumento.values())
            .filter(e -> e.name == value)
            .findFirst()
            .orElse(null);
    }
}
