package br.com.fiap.assistencia.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private List<Equipamento> equipamentos;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.equipamentos = new ArrayList<>();
    }

    public void adicionarEquipamento(Equipamento e){
        equipamentos.add(e);
    }
    @Override
    public String toString() {
        return "Cliente: " +
                "Cpf: " + cpf +
                ", nome: " + nome +
                ", equipamentos: " + equipamentos ;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }
}
