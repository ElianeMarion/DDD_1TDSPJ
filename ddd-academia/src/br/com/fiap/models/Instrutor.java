package br.com.fiap.models;

public class Instrutor {
    private String nome;
    private String especialidade;
    private String registroProfissional;

    public Instrutor(String nome, String especialidade, String registroProfissional) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " - " + especialidade + " (Registro: " + registroProfissional + ")";
    }
}
