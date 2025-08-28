package br.com.fiap.assistencia.tests;

import br.com.fiap.assistencia.models.Assistencia;
import br.com.fiap.assistencia.models.Cliente;
import br.com.fiap.assistencia.models.Equipamento;
import br.com.fiap.assistencia.models.Servico;

public class TesteAssistencia {

    public static void main(String[] args) {
        Servico servico = new Servico("Troca de tela", 500);
        Servico s2 = new Servico("Formatação do S.O.", 150);
        Equipamento equipamento = new Equipamento("123", "Samsung A73");
        equipamento.adicionarServico(servico);
        equipamento.adicionarServico(s2);

        Cliente cliente = new Cliente("1234", "João dos Santos");
        cliente.cadastrarEquipamento(equipamento);

        System.out.println(cliente);
        Assistencia assistencia = new Assistencia();
        assistencia.registrarCliente(cliente);
        assistencia.salvarClienteJson("clientes.json");

        assistencia.salvarRelatorioTxt("relatorio.txt");

    }
}
