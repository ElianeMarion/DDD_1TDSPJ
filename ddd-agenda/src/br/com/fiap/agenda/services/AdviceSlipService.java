package br.com.fiap.agenda.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AdviceSlipService {

    private static final String BASE_URL = "https://api.adviceslip.com/advice";

    private final HttpClient client;

    public AdviceSlipService() {
        this.client = HttpClient.newHttpClient();
    }

    public String getAdviceById(int id) throws IOException, InterruptedException {
        String url = BASE_URL + "/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String getRandomAdvice() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
