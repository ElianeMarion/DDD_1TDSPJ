public class Anime {
        //Atributos
        public String nome;
        public int classificacaoIndicativa;
        public String genero;
        public String autor;
        public int qtdEpisodios;
        public int numeroTemporadas;
    public String mensagem;

    //Métodos
    /*O método chamado mediaEpisodiosPorTemporada deve retornar a média
    simples de episódios por temporada.*/
    public int mediaEpisodiosPorTemporada(){
        return qtdEpisodios/numeroTemporadas;
    }
    /*deve retornar o texto com a indicação da classificação de acordo com
    a tabela abaixo, considere o texto em negrito: (LIVRE PARA TODOS OS
    PÚBLICOS; NÃO RECOMENDADO PARA MENORES DE 10 ANOS)
    * */
    private String exibirClassificacao(){
        if(classificacaoIndicativa == 10){
            return "NÃO RECOMENDADO PARA MENORES DE 10 ANOS";
        }else if(classificacaoIndicativa == 12){
            return "NÃO RECOMENDADO PARA MENORES DE 12 ANOS";
        }else if(classificacaoIndicativa == 14){
            return "NÃO RECOMENDADO PARA MENORES DE 14 ANOS";
        }else if(classificacaoIndicativa == 16){
            return "NÃO RECOMENDADO PARA MENORES DE 16 ANOS";
        }else if (classificacaoIndicativa == 18){
            return "NÃO RECOMENDADO PARA MENORES DE 18 ANOS";
        }else{
            return "LIVRE PARA TODOS OS PÚBLICOS";
        }
    }

    /*O método exibirDadosAnime deve armazenar o texto conforme o exemplo
    abaixo no atributo mensagem.*/
    public void exibirDadosAnime(){
        mensagem = "Nome do anime: " + nome + " \nDe acordo com o ministério da justiça esse anime " +
                "é " + exibirClassificacao() + "\nA média de episódios " +
                "por temporada é " + mediaEpisodiosPorTemporada() + ".";
    }

    public Anime(String nome, int classificacao){
        this.nome = nome;
        classificacaoIndicativa = classificacao;
    }
    public Anime(){}

    public Anime(String nome, int classificacaoIndicativa, int qtdEpisodios,
                 int numeroTemporadas) {
        this.nome = nome;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.qtdEpisodios = qtdEpisodios;
        this.numeroTemporadas = numeroTemporadas;
    }
}
