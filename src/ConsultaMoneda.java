import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda{
     public double buscaMoneda(String base_code, String target_code){//por revizar String base_code, String target_code
        String apiKey = "cbf07d80a82cf23a1bb8493d";
       URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+base_code+"/"+target_code);
//        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+base_code);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
//            return new Gson().fromJson(response.body(),Moneda.class);
              Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            return jsonObject.get("conversion_rate").getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la Moneda");
        }


     }
}



//https://v6.exchangerate-api.com/v6/cbf07d80a82cf23a1bb8493d/pair/USD/COP
// (permite cambiar usando "pair" de dolares a pesos colombianos)aplica para otras monedas
//https://v6.exchangerate-api.com/v6/cbf07d80a82cf23a1bb8493d/latest/USD
// con latest trae todas la lista de moneda de cambios del dolar a otras monedas

//import com.google.gson.*;
//
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//public class ConsultaMoneda {
//
//    public double buscaMoneda(String base_code, String target_code) {
//        String apiKey = "cbf07d80a82cf23a1bb8493d";
//        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base_code + "/" + target_code);
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(direccion)
//                .build();
//
//        try {
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            // Configuración de Gson para que ignore mayúsculas y minúsculas
//            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
//
//            // Parseo del JSON para obtener la tasa de conversión
//            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
//            return jsonObject.get("conversion_rate").getAsDouble();
//
//        } catch (Exception e) {
//            throw new RuntimeException("No se encontró la moneda: " + e.getMessage());
//        }
//    }
//}
