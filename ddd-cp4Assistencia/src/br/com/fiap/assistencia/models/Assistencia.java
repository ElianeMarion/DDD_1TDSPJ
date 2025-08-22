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
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
    public Cliente buscarCliente(String cpf) throws ClienteNaoEncontradoException{
        return clientes.stream()
                .filter(cliente -> cpf.equalsIgnoreCase(cliente.getCpf()))
                .findFirst()
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente com CPF \" + cpf + \" não encontrado."));
    }
    public Cliente buscarClienteForEach(String cpf) throws ClienteNaoEncontradoException{
        for(Cliente cli : clientes) {
            if (cli.getCpf().equalsIgnoreCase(cpf)) {
                return cli;
            }
        }
            throw new ClienteNaoEncontradoException("Cliente não encontrado");
    }
    public Equipamento buscarEquipamento(String numeroSerie) throws EquipamentoNaoEncontradoException {
        List<Equipamento> equipamentos = clientes.stream()
                .flatMap(cliente -> cliente.getEquipamentos().stream())
                .collect(Collectors.toList());

        return equipamentos.stream()
                .filter(equipamento -> numeroSerie.equalsIgnoreCase(equipamento.getNumeroSerie()))
                .findFirst()
                .orElseThrow(() -> new EquipamentoNaoEncontradoException("Equipamento com número de série " + numeroSerie  + " não encontrado."));
    }
    public void salvarClienteJson(String path){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("clientes.json")) {
            clientes.forEach(c -> gson.toJson(c, writer));
            System.out.println("Arquivo JSON escrito com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever o arquivo JSON: " + e.getMessage());
        }
    }
    public static void carregarClienteJon(String path){
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("clientes.json")) {
            Cliente cliente = gson.fromJson(reader, Cliente.class);
            System.out.println(cliente);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }
    public void salvarRelatorioTxt(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {

            for (Cliente cliente : clientes) {
                writer.write("Cliente: " + cliente.getNome() + " | CPF: " + cliente.getCpf());
                writer.newLine();

                for (Equipamento equipamento : cliente.getEquipamentos()) {
                    writer.write("  Equipamento: " + equipamento.getModelo()
                            + " | Nº Série: " + equipamento.getNumeroSerie());
                    writer.newLine();

                    for (Servico servico : equipamento.getServicos()) {
                        writer.write("    Serviço: " + servico.getDescricao()
                                + " | Valor: R$ " + servico.getValor());
                        writer.newLine();
                    }
                }
                writer.newLine();
            }

            writer.flush();
            System.out.println("Relatório salvo em " + path);

        } catch (IOException e) {
            System.err.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }

}
