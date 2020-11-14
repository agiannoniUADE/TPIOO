package model;

import java.util.Arrays;

public enum TipoLog {

        SOCIOS("Socios"),
        OPERACIONES("operaciones"),
        DOCUMENTOS("documentos");

        private final String name;

    TipoLog(final String theName) {
            name = theName;
        }

        public static boolean isValidValue(final String value) {
            return value != null && Arrays.stream(TipoLog.values())
                .anyMatch(e -> value.equalsIgnoreCase(e.toString()));
        }

        public static TipoLog lookUp(final String value) {
            return Arrays.stream(TipoLog.values())
                .filter(e -> value.equalsIgnoreCase(e.toString()))
                .findFirst()
                .orElse(null);
        }
    }
