package br.com.fiap.agenda.models;

import br.com.fiap.agenda.enums.TipoEnum;

public class Cliente {

    private int cod;
    private String nome;
    private String celular;
    private String email;
    private String instagram;
    private String endereco;
    private TipoEnum tipo;

    public Cliente(int cod, String nome, String celular, String email, String instagram,
                   String endereco, TipoEnum tipo) {
        this.cod = cod;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.instagram = instagram;
        this.endereco = endereco;
        this.tipo = tipo;

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "\t"  + cod +
                "\t"  + nome +
                "\t "  + celular +
                "\t"  + email +
                "\t\t"  + instagram +
                "\t\t"  + tipo +
                "\t\t"  + endereco;
    }

}
