package br.com.fiap.agenda.models;

import enums.TipoContatoEnum;

public class Contato {

    private int id;
    private String nome;
    private String celular;
    private String email;
    private String instagram;
    private TipoContatoEnum tipo;
    @Override
    public String toString() {
        return "\nContato: " + id +
                "\nNome:" + nome +
                "\nCelular: " + celular +
                "\nEmail: " + email +
                "\nInstagram: " + instagram  +
                "\nTipo do Contato: " + tipo +
                "\n===================================";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public TipoContatoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoContatoEnum tipo) {
        this.tipo = tipo;
    }
}
