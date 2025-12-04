package com.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de registro de usuarios.
 */
public class UserRegistrationService {

    /**
     * Último mensaje de error generado.
     */
    private String lastErrorMessage = "";

    /**
     * Lista de usuarios registrados.
     */
    private final List<String> users = new ArrayList<>();

    /**
     * Longitud mínima permitida para contraseñas.
     */
    private static final int MIN_PASSWORD_LENGTH = 8;

    /**
     * Constructor del servicio.
     */
    public UserRegistrationService() {
        System.out.println("Constructor llamado");
    }

    /**
     * Registra un usuario, validando los campos.
     *
     * @param username nombre del usuario
     * @param password contraseña
     * @param email    correo electrónico
     * @return true si se registra, false si hay error
     */
    public boolean registerUser(
            final String username,
            final String password,
            final String email) {

        if (username == null || username.trim().isEmpty()) {
            this.lastErrorMessage = "El nombre de usuario está vacío.";
            return false;
        }

        if (password == null) {
            this.lastErrorMessage = "La contraseña es null.";
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            this.lastErrorMessage = "La contraseña es muy corta.";
            return false;
        }

        if (!email.contains("@") || !email.contains(".")) {
            this.lastErrorMessage = "El correo electrónico no parece válido.";
            return false;
        }

        try {
            saveUser(username, password, email);
        } catch (Exception e) {
            this.lastErrorMessage =
                    "Error desconocido al guardar el usuario.";
            return false;
        }

        System.out.println("Usuario registrado: " + username);
        return true;
    }

    /**
     * Guarda el usuario en memoria simulando base de datos.
     *
     * @param username nombre del usuario
     * @param password contraseña
     * @param email    correo
     * @throws Exception error si el nombre no está permitido
     */
    private void saveUser(
            final String username,
            final String password,
            final String email) throws Exception {

        this.users.add(username);

        if ("error".equals(username)) {
            throw new Exception("Nombre no permitido.");
        }
    }

    /**
     * Devuelve la longitud del texto.
     *
     * @param s cadena
     * @return longitud o -1 si es null
     */
    public int x(final String s) {
        if (s == null) {
            return -1;
        }
        return s.length();
    }

    /**
     * Obtiene el último mensaje de error.
     *
     * @return mensaje de error
     */
    public String getLastErrorMessage() {
        return this.lastErrorMessage;
    }
}
