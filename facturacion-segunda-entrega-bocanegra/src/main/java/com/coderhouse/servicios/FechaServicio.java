package com.coderhouse.servicios;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.io.IOException;
import java.net.URI;
import java.time.ZonedDateTime;

@Service
public class FechaServicio {
    // Hacemos una llamada a la API del sitio worldtimeapi.org para obtener la fecha actual
    private static final String API_URL = "http://worldtimeapi.org/api/timezone/America/Mexico_City";

    public LocalDate obtenerFechaDelServicioExterno() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(URI.create(API_URL));
            return client.execute(request, response -> {
                // Si el status code es 200, se procesa el JSON obtenido para obtener la fecha
                if (response.getStatusLine().getStatusCode() == 200) {
                    String json = EntityUtils.toString(response.getEntity());
                    return procesarFechaDesdeJSON(json);
                } else {
                    throw new RuntimeException("No se pudo obtener la fecha: " + response.getStatusLine().getStatusCode());
                }
            });
        } catch (IOException e) {
            throw new Exception("Falló el llamado a la API", e);
        }
    }

    private LocalDate procesarFechaDesdeJSON(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TimeApiResponse response = mapper.readValue(json, TimeApiResponse.class);
        return ZonedDateTime.parse(response.getDatetime()).toLocalDate();
    }
    // Clase interna con sus getters y setters.
    private static class TimeApiResponse {
        private String datetime;

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }
    }
}
