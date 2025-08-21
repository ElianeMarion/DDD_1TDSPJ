package br.com.fiap.agenda.tests;

import br.com.fiap.agenda.dao.ConnectionFactory;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("Teste de conexão com o banco de dados");
        if(ConnectionFactory.obterConexao() == null){
            System.out.println("Erro ao estabelecer a conexão");
        }else{
            System.out.println("Conexão foi estabelecida com sucesso!");
        }
    }
}
