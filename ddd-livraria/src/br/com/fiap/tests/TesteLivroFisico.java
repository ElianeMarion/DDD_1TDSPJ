package br.com.fiap.tests;

import br.com.fiap.models.Carrinho;
import br.com.fiap.models.Editora;
import br.com.fiap.models.LivroDigital;
import br.com.fiap.models.LivroFisico;

import java.io.IOException;

public class TesteLivroFisico {
    public static void main(String[] args) {
        Editora novatec = new Editora();
        novatec.setNome("Novatec");
        novatec.setSite("www.novatec.com");
        novatec.setTelefone("11568958995");

        LivroFisico livroFisico = new LivroFisico();
        livroFisico.setTitulo("Livrox");
        livroFisico.setEditora(novatec);
        livroFisico.setAutor("Alguem");
        livroFisico.setEndereco("Avenida Paulista");
        livroFisico.setTaxaEntrega(14);
        livroFisico.setPreco(100);
        livroFisico.exibirLivro();
        System.out.println("Preço final R$ " + livroFisico.aplicarDesconto(15));

        LivroDigital ld = new LivroDigital(novatec);
        ld.setPreco(50);
        ld.setAudioLivro(true);
        ld.setTitulo("Sem criatividade");
        ld.exibirLivro();

        if(ld.ehMaisCaroQue(livroFisico))
            System.out.println("O " + livroFisico.getTitulo() + " é mais caro.");

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(livroFisico);
        carrinho.adicionarItem(ld);
        System.out.println("Valor total do carrinho: R$ "  + carrinho.getValorTotal());
        String path = "C:\\projetos\\2025\\ddd\\DDD_1TDSPJ\\ddd-livraria\\cupom.txt";
        try {
            carrinho.imprimirCupom(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
