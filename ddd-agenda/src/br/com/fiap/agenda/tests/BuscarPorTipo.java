package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDao;
import br.com.fiap.agenda.models.Contato;
import enums.TipoContatoEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscarPorTipo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        List<Contato> contatos = new ArrayList<>();
        ContatoDao dao = new ContatoDao();
        String tipo;
        System.out.println("Selecione o tipo do contato:\n" +
                "[F] - Familiar\t[A] - Amigo\t[P] - Profissional");
        String opcao = leitor.next();
        if(opcao.equalsIgnoreCase("f"))
            tipo = TipoContatoEnum.FAMILIAR.name();
        else if(opcao.equalsIgnoreCase("a"))
            tipo = TipoContatoEnum.AMIGO.name();
        else
            tipo = TipoContatoEnum.PROFISSIONAL.name();

        contatos = dao.buscarPorTipo(tipo);
        System.out.println("Agenda - Filtro escolhido: " + tipo);
        System.out.println("======================================");
        contatos.forEach(System.out::println);
    }
}
