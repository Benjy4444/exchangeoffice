package principal;

import modelos.Conversion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Principal {

    private static final Scanner lectura = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<Conversion> historialDeConversiones = new ArrayList<>();
        int opcionDeMenu;

        do {
            mostrarMenu();
            opcionDeMenu = leerOpcion();
            procesarOpcion(opcionDeMenu, historialDeConversiones);
        } while (opcionDeMenu != 8);

        System.out.println("¡Gracias por usar la aplicación de conversión de monedas!");
    }

    private static void mostrarMenu() {
        System.out.println("*********************************************");
        System.out.println("Sea bienvenido/a al Conversor de Monedas =)");
        System.out.println("1 --- Dólar ==>> Peso argentino");
        System.out.println("2 --- Peso argentino ==>> Dólar");
        System.out.println("3 --- Dólar ==>> Real brasileño");
        System.out.println("4 --- Real brasileño ==>> Dólar");
        System.out.println("5 --- Dólar ==>> Peso colombiano");
        System.out.println("6 --- Peso colombiano ==>> Dólar");
        System.out.println("7 --- Historial de conversiones de la sesión");
        System.out.println("8 --- SALIR");
        System.out.println("*********************************************");
    }

    private static int leerOpcion() {
        int opcion = -1;
        boolean opcionValida = false;
        while (!opcionValida) {
            System.out.println("Ingrese una opción: ");
            try {
                opcion = Integer.parseInt(lectura.nextLine());
                if (opcion >= 1 && opcion <= 8) {
                    opcionValida = true;
                } else {
                    System.out.println("Por favor ingrese una opción válida (1-8).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        return opcion;
    }

    private static void procesarOpcion(int opcion, List<Conversion> historial) throws IOException {
        switch (opcion) {
            case 1 -> realizarConversion("USD", "ARS", historial);
            case 2 -> realizarConversion("ARS", "USD", historial);
            case 3 -> realizarConversion("USD", "BRL", historial);
            case 4 -> realizarConversion("BRL", "USD", historial);
            case 5 -> realizarConversion("USD", "COP", historial);
            case 6 -> realizarConversion("COP", "USD", historial);
            case 7 -> mostrarHistorial(historial);
            case 8 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    private static void realizarConversion(String monedaOrigen, String monedaObjetivo, List<Conversion> historial) throws IOException {
        System.out.println("--->>>> " + monedaOrigen + " ---->>>> " + monedaObjetivo + " ---->>>>");
        System.out.println("Ingrese el monto para intercambiar (" + monedaOrigen + "): ");
        double cantidadParaCambiar = Double.parseDouble(lectura.nextLine());

        Conversion conversion = new Conversion();
        conversion.setMonedaOrigen(monedaOrigen);
        conversion.setMonedaObjetivo(monedaObjetivo);
        conversion.setCantidadParaCambiar(cantidadParaCambiar);

        try {
            double tasaDeConversion = conversion.obtenerTasaDeConversion();
            conversion.setTasaDeConversion(tasaDeConversion);
            conversion.setCantidadConvertida(cantidadParaCambiar * tasaDeConversion);

            //conversion.setFechaYHoraConversion(LocalDateTime.now());  // Agregar fecha y hora de la conversión

            System.out.println("El monto resultante es: " + conversion.getCantidadConvertida() + " " + monedaObjetivo);
            System.out.println("Resumen de la operación -------------- " + conversion);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }

        historial.add(conversion);
        System.out.println("Presione una tecla para continuar...");
        System.in.read();
    }

    private static void mostrarHistorial(List<Conversion> historial) throws IOException {
        System.out.println("Historial de conversiones de esta sesión:");
        System.out.println("---------------------------------------------");
        if (historial.isEmpty()) {
            System.out.println("No se han realizado conversiones aún.");
        } else {
            for (Conversion item : historial) {
                System.out.println(item);
            }
        }
        System.out.println("---------------------------------------------");
        System.out.println("Presione una tecla para continuar...");
        System.in.read();
    }
}
