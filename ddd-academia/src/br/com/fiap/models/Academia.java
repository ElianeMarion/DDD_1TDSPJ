package br.com.fiap.models;

import br.com.fiap.models.Aluno;
import br.com.fiap.models.Instrutor;
import br.com.fiap.models.Modalidade;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Academia {
    List<Aluno> alunos = new ArrayList<>();
    List<Instrutor> instrutores = new ArrayList<>();
    List<Modalidade> modalidades = new ArrayList<>();

    // Cadastro
    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void cadastrarInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    public void cadastrarModalidade(Modalidade modalidade) {
        modalidades.add(modalidade);
    }

    // Busca
    public Aluno buscarAlunoPorMatricula(String matricula) {
        return alunos.stream()
                .filter(aluno -> aluno.getMatricula().equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);
    }

    public Modalidade buscarModalidadePorNome(String nome) {
        return modalidades.stream()
                .filter(modalidade -> modalidade.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    // Relatórios
    public void listarModalidades() {
        if (modalidades.isEmpty()) {
            System.out.println("Nenhuma modalidade cadastrada.");
        } else {
            modalidades.stream()
                    .forEach(System.out::println);
        }
    }

    public void listarInstrutores() {
        if (instrutores.isEmpty()) {
            System.out.println("Nenhum instrutor cadastrado.");
        } else {
            instrutores.stream()
                    .forEach(System.out::println);
        }
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            alunos.stream()
                    .forEach(System.out::println);
        }
    }

    public void relatorioModalidadeComMaisAlunos() {
        if (modalidades.isEmpty()) {
            System.out.println("Não há modalidades cadastradas.");
            return;
        }

        modalidades.stream()
                .max(Comparator.comparingInt(Modalidade::getQuantidadeAlunos))
                .ifPresent(modalidade ->
                        System.out.println("Modalidade com mais alunos: "
                                + modalidade.getNome() + " ("
                                + modalidade.getQuantidadeAlunos() + " alunos)")
                );
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public List<Modalidade> getModalidades() {
        return modalidades;
    }
}
