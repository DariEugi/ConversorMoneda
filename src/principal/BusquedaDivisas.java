package principal;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BusquedaDivisas {

    public Map<String, Double> obtenerTasaDeCambio() {
        try {
            String url = "https://v6.exchangerate-api.com/v6/a90cb11bc550439142349b0e/latest/MXN";
            URL apiURL = new URL(url);
            HttpURLConnection con = (HttpURLConnection) apiURL.openConnection();
            con.setRequestMethod("GET");

            // Verificacion del código de respuesta
            int responseCode = con.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("Error al obtener tasas de cambio. Código de respuesta: " + responseCode);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(response.toString());
            JsonObject jsonobj = root.getAsJsonObject();

            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");

            Map<String, Double> tasasDeCambio = new HashMap<>();
            for (Map.Entry<String, JsonElement> entry : conversionRates.entrySet()) {
                String moneda = entry.getKey();
                Double tasa = entry.getValue().getAsDouble();
                tasasDeCambio.put(moneda, tasa);
            }
            return tasasDeCambio;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Devuelve null en caso de error
        }
    }
}
