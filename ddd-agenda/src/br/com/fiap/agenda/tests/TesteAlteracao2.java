package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ContatoDao;
import br.com.fiap.agenda.models.Contato;

import java.util.Scanner;

public class TesteAlteracao2 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner texto = new Scanner(System.in);
        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao();

        System.out.println("Digite o id do contato desejado: ");
        int id = leitor.nextInt();

        contato = dao.buscarPorId(id);
        System.out.println(contato);
        System.out.println("Qual campo deseja alterar" +
                "\n1 - nome\n2 - email");
        int op = leitor.nextInt();
        switch (op){
            case 1:
                System.out.println("Digite o nome");
                contato.setNome(texto.nextLine());
                break;
            case 2:
                System.out.println("Digite o email");
                contato.setEmail(texto.nextLine());
                break;
        }
        dao.alterarContato(contato);
        System.out.println(contato);
    }
}
