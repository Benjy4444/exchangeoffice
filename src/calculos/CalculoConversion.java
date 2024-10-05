package calculos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CalculoConversion {
    private String monedaBase;
    private String monedaObjetivo;

    public CalculoConversion(String monedaBase, String monedaObjetivo) {
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
    }

    public static void Resultado(String monedaBase, String monedaObjetivo) {
        String apiKeyExchangeRate = "a8b71d5baa160129e2ba346b";
        String direccionExchangeRate = "https://v6.exchangerate-api.com/v6/" + apiKeyExchangeRate + "/pair/" + monedaBase + "/" + monedaObjetivo;


        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccionExchangeRate))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
