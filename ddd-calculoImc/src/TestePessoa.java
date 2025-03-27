public class TestePessoa {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.nome = "Maria";
        p.altura = 1.65;
        p.peso = 70;
        System.out.println("IMC = " + p.calcularImc());
        System.out.println(p.exibirClassificacao());


    }
}
