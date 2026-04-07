package br.com.alura.screenmatch.service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException("Erro de I/O ao obter dados", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // boa prática
            throw new RuntimeException("Requisição interrompida", e);
        }
    }

}
