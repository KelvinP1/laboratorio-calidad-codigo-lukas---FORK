package com.tecsup.labs;

/**
 * Clase principal del proyecto.
 */
public final class Main {

    private Main() {
        // Constructor oculto porque esta es una clase utilitaria.
    }

    /**
     * Método principal de ejecución.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(final String[] args) {

        UserRegistrationService service = new UserRegistrationService();

        service.registerUser(
                "juan",
                "123",
                "juan@correo"
        );
        System.out.println(service.getLastErrorMessage());

        service.registerUser(
                null,
                "12345678",
                "correo-sin-arroba"
        );
        System.out.println(service.getLastErrorMessage());

        service.registerUser(
                "error",
                "12345678",
                "error@correo.com"
        );
        System.out.println(service.getLastErrorMessage());
    }
}
