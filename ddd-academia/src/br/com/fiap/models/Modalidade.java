package br.com.fiap.models;

import java.util.ArrayList;
import java.util.List;

public class Modalidade {
    private String nome;
    private Instrutor instrutor;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Modalidade(String nome, Instrutor instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }
    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public void listarAlunos() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno matriculado nesta modalidade.");
        } else {
            System.out.println("Alunos matriculados em " + nome + ":");
            for (Aluno aluno : listaAlunos) {
                System.out.println(" - " + aluno);
            }
        }
    }

    public int getQuantidadeAlunos() {
        return listaAlunos.size();
    }

    @Override
    public String toString() {
        return nome + " - Instrutor: " + instrutor.getNome() + " (Alunos matriculados: " + getQuantidadeAlunos() + ")";
    }
}
