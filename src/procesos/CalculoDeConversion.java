//ESTA CLASE LA CREE PARA SEPARAR EL CODIGO Y NO PUEDO HACER FUNCIONAR LA CUESTION

package procesos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Conversion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CalculoDeConversion{

    public Double Resultado(Conversion conversion) throws IOException, InterruptedException {

        //Llamado a Gson
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).
                setPrettyPrinting()
                .create();

        String apiKeyExchangeRate = "a8b71d5baa160129e2ba346b";
        String direccionExchangeRate = "https://v6.exchangerate-api.com/v6/" + apiKeyExchangeRate + "/pair/" + conversion.getMonedaOrigen() + "/" + conversion.getMonedaObjetivo();


        HttpClient client = HttpClient.newHttpClient();

        //try {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccionExchangeRate))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        //System.out.println(json);

        Conversion miConversion = gson.fromJson(json, Conversion.class);

        //System.out.println(this.cantidadParaCambiar);
        //System.out.println(miOtraConversion.tasaDeConversion);

        //System.out.println(miOtraConversion);

        //this.cantidadConvertida = cantidadParaCambiar * tasaDeConversion;

        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //}

        System.out.println("-------------------" + miConversion.getCantidadParaCambiar()*miConversion.getTasaDeConversion());
        return miConversion.getCantidadParaCambiar()*miConversion.getTasaDeConversion();
    }

}
