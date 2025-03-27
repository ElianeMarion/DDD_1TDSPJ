public class Pessoa {
    public String nome;
    public double altura;
    public double peso;

    /*O método calcularImc deverá retornar o cálculo do IMC que deve ser calculado da
    seguinte forma: peso / altura².
    +calcularImc():double
    */
    public double calcularImc(){
        return peso / (altura * altura);
    }

    /*O método exibirClassificacao deverá retornar uma mensagem dependendo o IMC
    calculado seguindo a seguinte tabela:*/
    public String exibirClassificacao(){
        String mensagem;
        double imc = calcularImc();
        if(imc < 18.5)
            mensagem = "Abaixo do peso"; //return "Abaixo do peso";
        else if(calcularImc() < 25)
            mensagem = "Peso normal";
        else if(calcularImc() < 30)
            mensagem = "Acima do peso";
        else if(calcularImc() < 35)
            mensagem = "Obesidade I";
        else if(calcularImc() < 40)
            mensagem = "Obesidade II";
        else
            mensagem = "Obesidade III";
        return mensagem;
    }

}
