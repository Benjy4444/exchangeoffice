package principal;
import modelos.Conversion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        List<Conversion> historialDeConversiones = new ArrayList<>();
        int opcionDeMenu = 0;
        while (opcionDeMenu != 8) {
            //Menú de opciones
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
                    Conversion miConversionUsdArs = new Conversion();
                    miConversionUsdArs.setMonedaOrigen("USD");
                    miConversionUsdArs.setMonedaObjetivo("ARS");
                    System.out.println("--->>>> USD ---->>>> ARS ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (USD): ");
                    cantidadParaCambiar = Double.valueOf(lectura.nextLine());
                    miConversionUsdArs.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversionUsdArs.setTasaDeConversion(miConversionUsdArs.Resultado(miConversionUsdArs));
                        miConversionUsdArs.setCantidadConvertida(miConversionUsdArs.getCantidadParaCambiar()* miConversionUsdArs.getTasaDeConversion());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversionUsdArs.getCantidadConvertida() + " ARS");
                    System.out.println("Resumen de la operación --------------" + miConversionUsdArs.toString());
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    //Tratando de agregar fecha y hora
                    //miConversion.setFechaYHoraConversion(LocalDateTime.now());
                    //System.out.println(miConversion.toString());
                    historialDeConversiones.add(miConversionUsdArs);
                    System.in.read();
                    break;
                case 2:
                    Conversion miConversionArsUsd = new Conversion();
                    miConversionArsUsd.setMonedaOrigen("ARS");
                    miConversionArsUsd.setMonedaObjetivo("USD");
                    System.out.println("--->>>> ARS ---->>>> USD ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (ARS): ");
                    cantidadParaCambiar = Double.valueOf(lectura.nextLine());
                    miConversionArsUsd.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversionArsUsd.setTasaDeConversion(miConversionArsUsd.Resultado(miConversionArsUsd));
                        miConversionArsUsd.setCantidadConvertida(miConversionArsUsd.getCantidadParaCambiar()* miConversionArsUsd.getTasaDeConversion());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversionArsUsd.getCantidadConvertida() + " ARS");
                    System.out.println("Resumen de la operación --------------" + miConversionArsUsd.toString());
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    historialDeConversiones.add(miConversionArsUsd);
                    System.in.read();
                    break;
                case 3:
                    Conversion miConversionUsdBrl = new Conversion();
                    miConversionUsdBrl.setMonedaOrigen("USD");
                    miConversionUsdBrl.setMonedaObjetivo("BRL");
                    System.out.println("--->>>> USD ---->>>> BRL ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (USD): ");
                    cantidadParaCambiar = Double.valueOf(lectura.nextLine());
                    miConversionUsdBrl.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversionUsdBrl.setTasaDeConversion(miConversionUsdBrl.Resultado(miConversionUsdBrl));
                        miConversionUsdBrl.setCantidadConvertida(miConversionUsdBrl.getCantidadParaCambiar()*miConversionUsdBrl.getTasaDeConversion());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversionUsdBrl.getCantidadConvertida() + " ARS");
                    System.out.println("Resumen de la operación --------------" + miConversionUsdBrl.toString());
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    historialDeConversiones.add(miConversionUsdBrl);
                    System.in.read();
                    break;
                case 4:
                    Conversion miConversionBrlUsd = new Conversion();
                    miConversionBrlUsd.setMonedaOrigen("BRL");
                    miConversionBrlUsd.setMonedaObjetivo("USD");
                    System.out.println("--->>>> BRL ---->>>> USD ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (BRL): ");
                    cantidadParaCambiar = Double.valueOf(lectura.nextLine());
                    miConversionBrlUsd.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversionBrlUsd.setTasaDeConversion(miConversionBrlUsd.Resultado(miConversionBrlUsd));
                        miConversionBrlUsd.setCantidadConvertida(miConversionBrlUsd.getCantidadParaCambiar()*miConversionBrlUsd.getTasaDeConversion());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversionBrlUsd.getCantidadConvertida() + " ARS");
                    System.out.println("--------------" + miConversionBrlUsd.toString());
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    historialDeConversiones.add(miConversionBrlUsd);
                    System.in.read();
                    break;
                case 5:
                    Conversion miConversionUsdCop = new Conversion();
                    miConversionUsdCop.setMonedaOrigen("USD");
                    miConversionUsdCop.setMonedaObjetivo("COP");
                    System.out.println("--->>>> USD ---->>>> COP ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (USD): ");
                    cantidadParaCambiar = Double.valueOf(lectura.nextLine());
                    miConversionUsdCop.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversionUsdCop.setTasaDeConversion(miConversionUsdCop.Resultado(miConversionUsdCop));
                        miConversionUsdCop.setCantidadConvertida(miConversionUsdCop.getCantidadParaCambiar()*miConversionUsdCop.getTasaDeConversion());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversionUsdCop.getCantidadConvertida() + " ARS");
                    System.out.println("--------------" + miConversionUsdCop.toString());
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    historialDeConversiones.add(miConversionUsdCop);
                    System.in.read();
                    break;
                case 6:
                    Conversion miConversionCopUsd = new Conversion();
                    miConversionCopUsd.setMonedaOrigen("COP");
                    miConversionCopUsd.setMonedaObjetivo("USD");
                    System.out.println("--->>>> COP ---->>>> USD ---->>>>");
                    System.out.println("Ingrese el monto para intercambiar (COP): ");
                    cantidadParaCambiar = Double.valueOf(lectura.nextLine());
                    miConversionCopUsd.setCantidadParaCambiar(cantidadParaCambiar);
                    try {
                        miConversionCopUsd.setTasaDeConversion(miConversionCopUsd.Resultado(miConversionCopUsd));
                        miConversionCopUsd.setCantidadConvertida(miConversionCopUsd.getCantidadParaCambiar()*miConversionCopUsd.getTasaDeConversion());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("El monto resultante es: " + miConversionCopUsd.getCantidadConvertida() + " ARS");
                    System.out.println("--------------" + miConversionCopUsd.toString());
                    System.out.println("--->>>> ... ---->>>> ... ---->>>>");
                    System.out.println("Presione una tecla para continuar...");
                    historialDeConversiones.add(miConversionCopUsd);
                    System.in.read();
                    break;
                case 7:
                    System.out.println("---------------------------------------------");
                    System.out.println("Historial de intercambios de monedas en esta sesión: ");
                    System.out.println("---------------------------------------------");
                    for (Conversion item:historialDeConversiones){
                        System.out.println(item.toString());
                    }
                    System.out.println("---------------------------------------------");
                    System.out.println("Presione una tecla para continuar...");
                    System.in.read();
                case 8:
                    System.out.println("¡Gracias por usar la aplicación!");
                    break;
                default:
                    // No sé que incluir acá
            }
        }
    }
}