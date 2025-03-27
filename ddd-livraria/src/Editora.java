public class Editora {
    String nome;
    String site;
    String telefone;

    /*
    * Construtor -> descrever como o objeto será criado
    * Deve ter obrigatoriamente o nome da classe
    * Não tem retorno
    * No momento em que eu crio um construtor o padrão deixa de existir
    * */

    public Editora(String nome){
        this.nome = nome;
    }
    public Editora(){}
    public void exibirEditora(){
        System.out.println("Editora " + nome);
        System.out.println("Site: " + site);
        System.out.println("Telefone: " + telefone);
    }
}
