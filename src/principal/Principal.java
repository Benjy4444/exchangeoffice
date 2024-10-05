package principal;

import calculos.CalculoConversion;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Conversion;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        List<Conversion> historialDeConversiones = new ArrayList<>();

        int opcionDeMenu = 0;

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

            //Llamado a Gson
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).
                    setPrettyPrinting()
                    .create();

            String monedaBase = "";
            String monedaObjetivo = "";

            switch (opcionDeMenu) {
                case 1:
                    monedaBase = "USD";
                    monedaObjetivo = "ARS";
                    CalculoConversion.Resultado(monedaBase, monedaObjetivo);
                    break;
                case 2:
                    monedaBase = "ARS";
                    monedaObjetivo = "USD";
                    CalculoConversion.Resultado(monedaBase, monedaObjetivo);
                    break;
                case 3:
                    monedaBase = "USD";
                    monedaObjetivo = "BRL";
                    CalculoConversion.Resultado(monedaBase, monedaObjetivo);
                    break;
                case 4:
                    monedaBase = "BRL";
                    monedaObjetivo = "USD";
                    CalculoConversion.Resultado(monedaBase, monedaObjetivo);
                    break;
                case 5:
                    monedaBase = "USD";
                    monedaObjetivo = "COP";
                    CalculoConversion.Resultado(monedaBase, monedaObjetivo);
                    break;
                case 6:
                    monedaBase = "COP";
                    monedaObjetivo = "USD";
                    CalculoConversion.Resultado(monedaBase, monedaObjetivo);
                    break;
                case 7:
                    System.out.println("¡Gracias por usar nuestra aplicación!");
                    break;
                default:
                    // Default secuencia de sentencias.
            }

        }

    }

}