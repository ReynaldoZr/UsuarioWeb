package com.example.servicioswebs.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.servicioswebs.model.Usuario;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private static final String URL = System.getenv("SUPABASE_CUSTOMERS_URL");
    private static final String API_KEY = System.getenv("SUPABASE_API_KEY");

    public List<Usuario> obtenerUsuarios() throws IOException, InterruptedException {
        if (URL == null || URL.isBlank() || API_KEY == null || API_KEY.isBlank()) {
            throw new IOException("Configure SUPABASE_CUSTOMERS_URL y SUPABASE_API_KEY antes de ejecutar.");
        }

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .timeout(Duration.ofSeconds(15))
                .header("apikey", API_KEY)
                .GET()
                .build();

        HttpResponse<String> response = cliente.send(
                request, HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException("Error al consultar clientes. Código HTTP: " + response.statusCode());
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode datos = mapper.readTree(response.body());
        if (!datos.isArray()) {
            throw new IOException("La respuesta no contiene un formato JSON");
        }

        List<Usuario> usuarios = new ArrayList<>();
        for (JsonNode nodo : datos) {
            Usuario usuario = new Usuario(
                    nodo.path("id").asInt(),
                    nodo.path("first_name").asText(),
                    nodo.path("last_name").asText(),
                    nodo.path("email").asText(),
                    nodo.path("phone").asText(),
                    nodo.path("date_of_birth").asText(),
                    nodo.path("country").asText(),
                    nodo.path("city").asText(),
                    nodo.path("address").asText(),
                    nodo.path("annual_income").asDouble(),
                    nodo.path("credit_score").asInt(),
                    nodo.path("has_unpaid_debt").asBoolean(),
                    nodo.path("unpaid_debt_amount").asDouble(),
                    nodo.path("status").asText()
            );
            usuarios.add(usuario);
        }

        return usuarios;
    }
}
