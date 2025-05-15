package br.com.fiap.models;
import br.com.fiap.interfaces.ISeguroService;
public class Segurado extends Veiculo implements ISeguroService{
    //Atributo encapsulado
    private double seguro;
    //Construtor
    public Segurado(double seguro) {
        this.seguro = seguro;
    }
    //Sobrescrita da super classe
    public double doTotal(){
        return super.doTotal() - doDesconto();
    }

    //Sobrescrita -> Implementação do método da interface
    @Override
    public double doDesconto() {
        return super.doTotal() * seguro / 100;
    }
    //Sobrescrita -> SuperClasse
    public String doViewCupom(){
        return   super.doViewCupom() +
                "\nDesconto do seguro: " + doDesconto();
    }
}
