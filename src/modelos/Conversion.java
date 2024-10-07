package modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Objects;

public class Conversion {

    @SerializedName("base_code")
    private String monedaOrigen;
    @SerializedName("target_code")
    private String monedaObjetivo;
    private double cantidadParaCambiar;
    @SerializedName("conversion_rate")
    private double tasaDeConversion;
    private double cantidadConvertida;
    //private LocalDateTime fechaYHoraConversion;

    // Constantes para la API
    private static final String API_KEY = "a8b71d5baa160129e2ba346b";
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";

    // Constructor
    //public Conversion() {
    //    this.fechaYHoraConversion = LocalDateTime.now();  // Fecha y hora actuales
    //}

    // Getters y Setters
    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public void setMonedaObjetivo(String monedaObjetivo) {
        this.monedaObjetivo = monedaObjetivo;
    }

    public double getCantidadParaCambiar() {
        return cantidadParaCambiar;
    }

    public void setCantidadParaCambiar(double cantidadParaCambiar) {
        if (cantidadParaCambiar <= 0) {
            throw new IllegalArgumentException("La cantidad para cambiar debe ser mayor a 0");
        }
        this.cantidadParaCambiar = cantidadParaCambiar;
    }

    public double getTasaDeConversion() {
        return tasaDeConversion;
    }

    public void setTasaDeConversion(double tasaDeConversion) {
        if (tasaDeConversion <= 0) {
            throw new IllegalArgumentException("La tasa de conversión debe ser mayor a 0");
        }
        this.tasaDeConversion = tasaDeConversion;
    }

    public double getCantidadConvertida() {
        return cantidadConvertida;
    }

    public void setCantidadConvertida(double cantidadConvertida) {
        this.cantidadConvertida = cantidadConvertida;
    }

    //public LocalDateTime getFechaYHoraConversion() {
    //    return fechaYHoraConversion;
    //}

    //public void setFechaYHoraConversion(LocalDateTime fechaYHoraConversion) {
    //    this.fechaYHoraConversion = fechaYHoraConversion;
    //}

    @Override
    public String toString() {
        return "Moneda de base= " + monedaOrigen +
                ", Moneda objetivo= " + monedaObjetivo +
                ", Monto para intercambio= " + cantidadParaCambiar +
                ", Tasa de conversión= " + tasaDeConversion +
                ", Cantidad convertida= " + cantidadConvertida;
                //", Fecha y hora= " + fechaYHoraConversion;
    }

    // Método para obtener la tasa de conversión
    public Double obtenerTasaDeConversion() throws IOException, InterruptedException {
        String url = URL_BASE + API_KEY + "/pair/" + monedaOrigen + "/" + monedaObjetivo;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new IOException("Error en la conexión a la API de ExchangeRate", e);
        }

        if (response.statusCode() != 200) {
            throw new IOException("Error en la respuesta de la API. Código de estado: " + response.statusCode());
        }

        String jsonResponse = response.body();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        Conversion conversionRespuesta = gson.fromJson(jsonResponse, Conversion.class);

        if (Objects.isNull(conversionRespuesta) || conversionRespuesta.getTasaDeConversion() <= 0) {
            throw new IOException("Respuesta inválida de la API");
        }

        this.tasaDeConversion = conversionRespuesta.getTasaDeConversion();
        return this.tasaDeConversion;
    }
}
