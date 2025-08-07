package br.com.fiap.tests;

import br.com.fiap.models.*;

import java.util.Scanner;

public class AcademiaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Academia academia = new Academia();
        int opcao;

        do {
            System.out.println("\n=== MENU ACADEMIA ===");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Instrutor");
            System.out.println("3 - Cadastrar Modalidade");
            System.out.println("4 - Matricular Aluno em Modalidade");
            System.out.println("5 - Relatório: Listar Modalidades");
            System.out.println("6 - Relatório: Listar Instrutores");
            System.out.println("7 - Relatório: Listar Alunos");
            System.out.println("8 - Relatório: Modalidade com mais alunos");
            System.out.println("9 - Listar Alunos de uma Modalidade");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();
                    academia.cadastrarAluno(new Aluno(nomeAluno, idade, matricula));
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do instrutor: ");
                    String nomeInstrutor = sc.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = sc.nextLine();
                    System.out.print("Registro profissional: ");
                    String registro = sc.nextLine();
                    academia.cadastrarInstrutor(new Instrutor(nomeInstrutor, especialidade, registro));
                    System.out.println("Instrutor cadastrado com sucesso!");
                    break;

                case 3:
                    if (academia.buscarAlunoPorMatricula("teste") == null) { }
                    System.out.print("Nome da modalidade: ");
                    String nomeModalidade = sc.nextLine();
                    System.out.println("Escolha um instrutor pelo nome:");
                    academia.listarInstrutores();
                    String instrutorEscolhido = sc.nextLine();
                    Instrutor instrutor = null;
                    for (Instrutor i : academia.getInstrutores()) {
                        if (i.getNome().equalsIgnoreCase(instrutorEscolhido)) {
                            instrutor = i;
                            break;
                        }
                    }
                    if (instrutor != null) {
                        academia.cadastrarModalidade(new Modalidade(nomeModalidade, instrutor));
                        System.out.println("Modalidade cadastrada com sucesso!");
                    } else {
                        System.out.println("Instrutor não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite a matrícula do aluno: ");
                    String mat = sc.nextLine();
                    Aluno aluno = academia.buscarAlunoPorMatricula(mat);

                    if (aluno == null) {
                        System.out.println("Aluno não encontrado.");
                        break;
                    }

                    System.out.println("Digite o nome da modalidade: ");
                    academia.listarModalidades();
                    String nome = sc.nextLine();
                    Modalidade modalidade = academia.buscarModalidadePorNome(nome);

                    if (modalidade != null) {
                        modalidade.adicionarAluno(aluno);
                        System.out.println("Aluno matriculado com sucesso!");
                    } else {
                        System.out.println("Modalidade não encontrada.");
                    }
                    break;

                case 5:
                    academia.listarModalidades();
                    break;

                case 6:
                    academia.listarInstrutores();
                    break;

                case 7:
                    academia.listarAlunos();
                    break;

                case 8:
                    academia.relatorioModalidadeComMaisAlunos();
                    break;

                case 9:
                    System.out.println("Digite o nome da modalidade: ");
                    String nomeMod = sc.nextLine();
                    Modalidade m = academia.buscarModalidadePorNome(nomeMod);
                    if (m != null) {
                        m.listarAlunos();
                    } else {
                        System.out.println("Modalidade não encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
