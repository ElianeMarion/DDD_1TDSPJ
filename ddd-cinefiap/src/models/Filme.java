package models;

import enums.ClassificacaoIndicativaEnum;
import enums.GeneroEnum;

import java.time.LocalTime;

public class Filme {

    private Long id;
    private String nome;
    private int duracao;
    private GeneroEnum genero;
    private ClassificacaoIndicativaEnum classificacao;
    private Integer ano;
    private String capa;
    private String diretor;
    private String elenco;
    private String descricao;
    private Double avaliacao;

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", genero=" + genero +
                ", classificacao=" + classificacao +
                ", ano=" + ano +
                ", capa='" + capa + '\'' +
                ", diretor='" + diretor + '\'' +
                ", elenco='" + elenco + '\'' +
                ", descricao='" + descricao + '\'' +
                ", avaliacao=" + avaliacao +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public ClassificacaoIndicativaEnum getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoIndicativaEnum classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Filme() {
    }

    public Filme(Long id, String nome, int duracao, GeneroEnum genero, ClassificacaoIndicativaEnum classificacao, Integer ano, String capa, String diretor, String elenco, String descricao, Double avaliacao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.genero = genero;
        this.classificacao = classificacao;
        this.ano = ano;
        this.capa = capa;
        this.diretor = diretor;
        this.elenco = elenco;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
    }

    //int minutos = duracao.getHour() * 60  + duracao.getMinute();
}
