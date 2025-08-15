package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.models.Cliente;
import br.com.fiap.agenda.models.ManipularAgenda;
import br.com.fiap.agenda.enums.TipoEnum;

import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {

        ManipularAgenda ma = new ManipularAgenda();

        // Adicionando alguns clientes para teste
        ma.adicionarCliente(new Cliente(1, "João Silva", "11987654321", "joao.silva@email.com", "@joaosilva", "Rua A, 123", TipoEnum.VIP));
        ma.adicionarCliente(new Cliente(2, "Maria Souza", "11912345678", "maria.souza@fiap.com.br", "@maria123", "Rua B, 456", TipoEnum.PREMIUM));
        ma.adicionarCliente(new Cliente(3, "Pedro Santos", "11955558888", "pedro.santos@email.com", "@pedrosantos", "Rua C, 789", TipoEnum.VIP));
        ma.adicionarCliente(new Cliente(4, "Ana Oliveira", "11933337777", "ana.oliveira@fiap.com.br", "@anaoliveira", "Rua D, 101", TipoEnum.PREMIUM));
        ma.adicionarCliente(new Cliente(5, "Carlos Lima", "11988884444", "carlos.lima@email.com", "@limac", "Rua E, 202", TipoEnum.COMUM));


        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("--- Menu Agenda ---");
            System.out.println("1. Escrever no arquivo");
            System.out.println("2. Ler arquivo");
            System.out.println("3. Listar Clientes VIP");
            System.out.println("4. Listar Clientes Premium");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    ma.escrever();
                    break;
                case 2:
                    ma.lerArquivo();
                    break;
                case 3:
                    ma.listarClienteVip();
                    break;
                case 4:
                    ma.listarClientePremium();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 0);

        scanner.close();
    }
}

