package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.enums.TipoEnum;
import br.com.fiap.agenda.models.Cliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestJson {

    public static void leituraJson(){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("cliente.json")) {
            Cliente pessoa = gson.fromJson(reader, Cliente.class);
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Celular: " + pessoa.getCelular());
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }
    public static void main(String[] args) {

        Cliente pessoa = new Cliente(1, "João Silva", "11987654321", "joao.silva@email.com", "@joaosilva", "Rua A, 123", TipoEnum.VIP);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("cliente.json")) {
            gson.toJson(pessoa, writer);
            System.out.println("Arquivo JSON escrito com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever o arquivo JSON: " + e.getMessage());
        }
        leituraJson();
    }

}
