package br.com.fiap.agenda.models;

import br.com.fiap.agenda.enums.TipoEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManipularAgenda {

    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {

        clientes.add(cliente);
    }

    public void escrever() {
        try (FileWriter writer = new FileWriter("agenda.txt")) {
            for (Cliente cliente : clientes) {
                writer.write(cliente.getCod() + ";" +
                        cliente.getNome() + ";" +
                        cliente.getCelular() + ";" +
                        cliente.getEmail() + ";" +
                        cliente.getInstagram() + ";" +
                        cliente.getEndereco() + ";" +
                        cliente.getTipo() + "\n");
            }
            System.out.println("Clientes salvos no arquivo agenda.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Cliente> lerClientesDoArquivo() {
        List<Cliente> clientesDoArquivo = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("agenda.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) { //readLine() lê uma linha inteira do arquivo.
                String[] data = line.split(";");
                if (data.length >= 7) {
                    Cliente cliente = new Cliente(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3],
                            data[4],
                            data[5],
                            TipoEnum.valueOf(data[6])
                    );
                    clientesDoArquivo.add(cliente);
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Erro ao ler ou processar o arquivo: " + e.getMessage());
        }
        return clientesDoArquivo;
    }

    public void lerArquivo() {
        System.out.println("--- Conteúdo do Arquivo agenda.txt ---");
        System.out.println("\nCódigo\tNome\t\tCelular\t\tEmail\t\t\t\t\tInstagram\t\t\tTipo\tEndereço\n");
        lerClientesDoArquivo().forEach(System.out::println);
        //lerClientesDoArquivo().forEach(c -> System.out.println(c));
    }

    public void listarClienteVip() {
        System.out.println("--- Clientes Vip ---");
        System.out.println("\nCódigo\tNome\t\tCelular\t\tEmail\t\t\t\t\tInstagram\t\t\tTipo\tEndereço\n");
        List<Cliente> clientesVip = lerClientesDoArquivo()
                .stream()
                .filter(cliente -> cliente.getTipo() == TipoEnum.VIP)
                .collect(Collectors.toList());
        clientesVip.forEach(System.out::println);
    }

    public void listarClientePremium() {
        System.out.println("--- Clientes Premium ---");
        System.out.println("\nCódigo\tNome\t\tCelular\t\tEmail\t\t\t\t\tInstagram\t\t\tTipo\tEndereço\n");
        List<Cliente> clientesPremium = lerClientesDoArquivo().stream()
                .filter(cliente -> cliente.getTipo() == TipoEnum.PREMIUM)
                .collect(Collectors.toList());
        clientesPremium.forEach(System.out::println);
    }
}

