package model;

import principal.BusquedaDivisas;

import java.util.Map;

public class ConvertirMoneda {
    private Map<String, Double> tasasDeCambio;

    public ConvertirMoneda() {
        var busqudaDivisas = new BusquedaDivisas();
        this.tasasDeCambio = busqudaDivisas.obtenerTasaDeCambio();
    }

    public double convertir(double cantidad, String divisaOrigen, String divisaDestino) {
        double tasaOrigen = tasasDeCambio.getOrDefault(divisaOrigen, 1.0);
        double tasaDestino = tasasDeCambio.getOrDefault(divisaDestino, 1.0);
        return cantidad * (1 / tasaOrigen) * tasaDestino;
    }
}
