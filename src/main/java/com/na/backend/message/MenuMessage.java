package com.na.backend.message;

public enum MenuMessage {
    ROL_NO_ENCONTRADO("Rol no encontrado para el código: "),
    MENU_ROLES("No se encontraron menús para los roles especificados: ");

    private final String mensaje;

    MenuMessage(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}