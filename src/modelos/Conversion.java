package modelos;

import java.util.Date;

public class Conversion {
    private String monedaOrigen;
    private String monedaObjetivo;
    private double cantidadParaCambiar;
    private double tasaDeConversion;
    private double cantidadConvertida;
    private Date fechaYHoraConversion;

    public Conversion(String monedaOrigen, String monedaObjetivo, double cantidadParaCambiar) {
        this.monedaOrigen = monedaOrigen;
        this.monedaObjetivo = monedaObjetivo;
        this.cantidadParaCambiar = cantidadParaCambiar;
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

    public Date getFechaYHoraConversion() {
        return fechaYHoraConversion;
    }

    public void setFechaYHoraConversion(Date fechaYHoraConversion) {
        this.fechaYHoraConversion = fechaYHoraConversion;
    }
}
