package br.com.fiap.models;
//Quando eu definir uma superclasse como abstract
//Eu estou dizendo que não pode ser instanciada
//porque o objeto não existe no mundo real.
public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected String numeroCtps;
    protected double salario;

    //Só existe em classes abstratas
    //Obrigar os filhos (subclasses) a implementar o método
    public abstract void calcularSalario();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroCtps() {
        return numeroCtps;
    }

    public void setNumeroCtps(String numeroCtps) {
        this.numeroCtps = numeroCtps;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
