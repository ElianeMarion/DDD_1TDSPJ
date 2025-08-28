package br.com.fiap.assistencia.models;

import br.com.fiap.assistencia.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.assistencia.exceptions.EquipamentoNaoEncontradoException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Assistencia {
    private List<Cliente> clientes = new ArrayList<>();
    public void registrarCliente(Cliente c){
        clientes.add(c);
    }

    public Cliente buscarCliente(String cpf) throws ClienteNaoEncontradoException{
        for(Cliente cli : clientes){
            if(cli.getCpf().equals(cpf)){
                return cli;
            }
        }
        throw new ClienteNaoEncontradoException("Cliente não encontrado");
    }

    public Cliente buscarCliente2(String cpf) throws ClienteNaoEncontradoException {
        return clientes.stream()
                .filter(cli -> cli.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));
    }
    public Equipamento buscarEquipamento(String numeroSerie) throws EquipamentoNaoEncontradoException {
        List<Equipamento> equipamentos = clientes.stream()
                .flatMap(cliente -> cliente.getEquipamentos().stream())
                .collect(Collectors.toList());

        for(Equipamento equipamento : equipamentos){
            if(equipamento.equals(numeroSerie)){
                return equipamento;
            }
        }
        throw new EquipamentoNaoEncontradoException("Equipamento não encontrado");
    }
    public void salvarClienteJson(String path){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("clientes.json")) {
            clientes.forEach(c-> gson.toJson(c, writer));

            System.out.println("Arquivo JSON escrito com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever o arquivo JSON: " + e.getMessage());
        }
    }
    public static void carregarClientesJon(String path){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("clientes.json")) {
            Cliente cliente = gson.fromJson(reader, Cliente.class);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }
    public void salvarRelatorioTxt(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            for(Cliente cli : clientes){
                writer.write("Cliente: " + cli);
                writer.newLine();
            }
            System.out.println("Relatório salvo em " + path);

        } catch (IOException e) {
            System.err.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }

}
