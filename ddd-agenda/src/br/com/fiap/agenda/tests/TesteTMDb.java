package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.services.TMDbService;

import java.io.IOException;

public class TesteTMDb {

    public static void main(String[] args) {
        TMDbService tmdbService = new TMDbService();
        try {
            String popularMovies = tmdbService.getPopularMovies();
            System.out.println(popularMovies);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
