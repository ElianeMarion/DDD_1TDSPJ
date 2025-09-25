package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.services.AdviceSlipService;

import java.io.IOException;

public class TesteAdviceSlip {

    public static void main(String[] args) {
        AdviceSlipService adviceSlipService = new AdviceSlipService();
        try {
            // Test fetching advice by ID
            System.out.println("Fetching advice with ID 2:");
            String adviceById = adviceSlipService.getAdviceById(2);
            System.out.println(adviceById);

            System.out.println("\n---------------------\n");

            // Test fetching a random advice
            System.out.println("Fetching random advice:");
            String randomAdvice = adviceSlipService.getRandomAdvice();
            System.out.println(randomAdvice);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
