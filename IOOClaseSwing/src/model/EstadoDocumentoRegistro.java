package model;

import java.util.Arrays;

public enum EstadoDocumentoRegistro {
  INGRESADO("ingresado"),
  CONTROLADO("controlado"),
  RECHAZADO("rechazado");

  private final String name;

  EstadoDocumentoRegistro(final String theName) {
    name = theName;
  }

  public static boolean isValidValue(final String value) {
    return value != null && Arrays.stream(EstadoDocumentoRegistro.values())
      .anyMatch(e -> value.equalsIgnoreCase(e.toString()));
  }

  public static EstadoDocumentoRegistro lookUp(final String value) {
    return Arrays.stream(EstadoDocumentoRegistro.values())
      .filter(e -> value.equalsIgnoreCase(e.toString()))
      .findFirst()
      .orElse(null);
  }
}
