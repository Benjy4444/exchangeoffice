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
import java.sql.Date;

public class Conversion {
    @SerializedName("base_code")
    private String monedaOrigen;
    @SerializedName("target_code")
    private String monedaObjetivo;
    private double cantidadParaCambiar;
    @SerializedName("conversion_rate")
    private double tasaDeConversion;
    private double cantidadConvertida;
    private Date fechaYHoraConversion;

    public Conversion() {
    }

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
        this.cantidadParaCambiar = cantidadParaCambiar;
    }

    public double getTasaDeConversion() {
        return tasaDeConversion;
    }

    public void setTasaDeConversion(double tasaDeConversion) {
        this.tasaDeConversion = tasaDeConversion;
    }

    public double getCantidadConvertida() {
        return cantidadConvertida;
    }

    public void setCantidadConvertida(double cantidadConvertida) {
        this.cantidadConvertida = cantidadConvertida;
    }

    public Date getFechaYHoraConversion() {
        return fechaYHoraConversion;
    }

    public void setFechaYHoraConversion(Date fechaYHoraConversion) {
        this.fechaYHoraConversion = fechaYHoraConversion;
    }

    @Override
    public String toString() {
        return "Moneda de base= " + this.monedaOrigen +
                ", Moneda objetivo =" + this.monedaObjetivo+
                ", Monto para intercambio=" + this.getCantidadParaCambiar() +
                ", Tasa de conversión=" + this.tasaDeConversion +
                ", Cantidad convertida=" + this.getCantidadConvertida() +
                ", Fecha y hora=" + this.fechaYHoraConversion;
    }

    public Double Resultado(Conversion conversion) throws IOException, InterruptedException {
        //Llamado a Gson
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).
                setPrettyPrinting()
                .create();
        //Creación de la cadena para conectarse al sitio de ExchangeRate
        String apiKeyExchangeRate = "a8b71d5baa160129e2ba346b";
        String direccionExchangeRate = "https://v6.exchangerate-api.com/v6/" + apiKeyExchangeRate + "/pair/" + this.monedaOrigen + "/" + this.monedaObjetivo;
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccionExchangeRate))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Conversion miConversionGson = gson.fromJson(json, Conversion.class);
            return miConversionGson.getTasaDeConversion();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
