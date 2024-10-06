//ESTO LO VOY A USAR PARA TRAER LOS MENUS DE OPCIONES

package procesos;

import modelos.Conversion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImpresionDeMenu {

    public void MenuPrincipal() {

        Scanner lectura = new Scanner(System.in);

        List<Conversion> historialDeConversiones = new ArrayList<>();

        int opcionDeMenu = 0;

        //Conversion miConversion = new Conversion();
        //CalculoDeConversion miCalculoDeConversion = new CalculoDeConversion();

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

        }
    }

    public void OpcionConversion (Conversion conversion) throws IOException, InterruptedException {

        List<Conversion> historialDeConversiones = new ArrayList<>();

        Scanner lectura = new Scanner(System.in);

        Conversion miConversionUsdArs = new Conversion();
        //CalculoDeConversion miCalculoDeConversion = new CalculoDeConversion();
        miConversionUsdArs.setMonedaOrigen("USD");
        miConversionUsdArs.setMonedaObjetivo("ARS");
        System.out.println("--->>>> USD ---->>>> ARS ---->>>>");
        System.out.println("Ingrese el monto para intercambiar (USD): ");
        Double cantidadParaCambiar = Double.valueOf(lectura.nextLine());
        miConversionUsdArs.setCantidadParaCambiar(cantidadParaCambiar);
        try {
            miConversionUsdArs.Resultado(miConversionUsdArs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("El monto resultante es: " + miConversionUsdArs.Resultado(miConversionUsdArs) + " ARS");

        //Esto no funciona... al intentar separar el calculo del resultado de la conversión
        //System.out.println("El monto resultante es: " + miCalculoDeConversion.Resultado(miConversion) + " ARS");

        System.out.println("--->>>> ... ---->>>> ... ---->>>>");
        System.out.println("Presione una tecla para continuar...");

        //Tratando de agregar fecha y hora
        //miConversion.setFechaYHoraConversion(LocalDateTime.now());
        //System.out.println(miConversion.toString());

        historialDeConversiones.add(miConversionUsdArs);

        System.in.read();

    }

}
