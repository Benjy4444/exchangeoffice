package principal;

import modelos.Conversion;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);

        List<Conversion> historialDeConversiones = new ArrayList<>();

        int opcionDeMenu = 0;

        Conversion miConversion = new Conversion();

        while (opcionDeMenu != 7) {

            //Menú de opciones
            System.out.println("*********************************************");
            System.out.println("Sea bienvenido/a al Conversor de Monedas =)");
            System.out.println("1 --- Dólar ==>> Peso argentino");
            System.out.println("2 --- Peso argentino ==>> Dólar");
            System.out.println("3 --- Dólar ==>> Real brasileño");
            System.out.println("4 --- Real brasileño ==>> Dólar");
            System.out.println("5 --- Dólar ==>> Peso colombiano");
            System.out.println("6 --- Peso colombiano ==>> Dólar");
            System.out.println("7 --- SALIR");
            System.out.println("*********************************************");

            //++++++++++++++++

            //Solicita ingreso opción de menú
            System.out.println("---------------------------------------------");
            System.out.println("Ingrese una opción: ");
            opcionDeMenu = Integer.parseInt(lectura.nextLine());
            System.out.println("---------------------------------------------");

            //++++++++++++++++

            String monedaBase = "";
            String monedaObjetivo = "";
            Double cantidadParaCambiar;
            Double resultado;

            switch (opcionDeMenu) {
                case 1:
                    miConversion.setMonedaOrigen("USD");
                    miConversion.setMonedaObjetivo("ARS");
                    System.out.println("--->>>> USD ---->>>> ARS ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (USD): ");
                    cantidadParaCambiar = (double) Integer.parseInt(lectura.nextLine());
                    miConversion.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversion.Resultado(miConversion);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversion.Resultado(miConversion) + " ARS");
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    System.in.read();
                    break;
                case 2:
                    miConversion.setMonedaOrigen("ARS");
                    miConversion.setMonedaObjetivo("USD");
                    System.out.println("--->>>> ARS ---->>>> USD ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (ARS): ");
                    cantidadParaCambiar = (double) Integer.parseInt(lectura.nextLine());
                    miConversion.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversion.Resultado(miConversion);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversion.getCantidadParaCambiar()*miConversion.Resultado(miConversion) + " USD");
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");

                    System.out.println("Presione una tecla para continuar...");
                    System.in.read();
                    break;
                case 3:
                    miConversion.setMonedaOrigen("USD");
                    miConversion.setMonedaObjetivo("BRL");
                    System.out.println("--->>>> USD ---->>>> BRL ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (USD): ");
                    cantidadParaCambiar = (double) Integer.parseInt(lectura.nextLine());
                    miConversion.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversion.Resultado(miConversion);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversion.getCantidadParaCambiar()*miConversion.Resultado(miConversion) + " BRL");
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    System.in.read();
                    break;
                case 4:
                    miConversion.setMonedaOrigen("BRL");
                    miConversion.setMonedaObjetivo("USD");
                    System.out.println("--->>>> BRL ---->>>> USD ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (BRL): ");
                    cantidadParaCambiar = (double) Integer.parseInt(lectura.nextLine());
                    miConversion.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversion.Resultado(miConversion);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversion.getCantidadParaCambiar()*miConversion.Resultado(miConversion) + " USD");
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    System.in.read();
                    break;
                case 5:
                    miConversion.setMonedaOrigen("USD");
                    miConversion.setMonedaObjetivo("COP");
                    System.out.println("--->>>> USD ---->>>> COP ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (USD): ");
                    cantidadParaCambiar = (double) Integer.parseInt(lectura.nextLine());
                    miConversion.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversion.Resultado(miConversion);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversion.getCantidadParaCambiar()*miConversion.Resultado(miConversion) + " COP");
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    System.in.read();
                    break;
                case 6:
                    miConversion.setMonedaOrigen("COP");
                    miConversion.setMonedaObjetivo("USD");
                    System.out.println("--->>>> COP ---->>>> USD ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (COP): ");
                    cantidadParaCambiar = (double) Integer.parseInt(lectura.nextLine());
                    miConversion.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversion.Resultado(miConversion);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversion.getCantidadParaCambiar()*miConversion.Resultado(miConversion) + " USD");
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    System.in.read();
                    break;
                case 7:
                    System.out.println("¡Gracias por usar la aplicación!");
                    break;
                default:
                    // Default secuencia de sentencias.
            }

        }

    }

}