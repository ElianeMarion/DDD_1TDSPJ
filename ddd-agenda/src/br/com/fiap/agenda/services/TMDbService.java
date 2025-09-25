package br.com.fiap.agenda.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TMDbService {

    private static final String API_KEY = "0e365a36e39a13480d4651810a1ba982";
    private static final String BASE_URL = "https://api.themoviedb.org/3";

    private final HttpClient client;

    public TMDbService() {
        this.client = HttpClient.newHttpClient();
    }

    public String getPopularMovies() throws IOException, InterruptedException {
        String url = BASE_URL + "/movie/popular?api_key=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
