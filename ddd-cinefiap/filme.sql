create table tbl_filme(
    id_filme number primary key,
    tx_nome varchar2(50) not null,
    nr_duracao number not null,
    tp_genero varchar2(17) not null,
    tp_classificacao varchar2(5),
    nr_ano number,
    tx_capa varchar2(300),
    tx_diretor varchar2(300),
    tx_elenco varchar2(300),
    tx_descricao varchar2(500),
    nr_avaliacao binary_float
);
    insert into tbl_filme (id_filme, tx_nome, nr_duracao, tp_genero, tp_classificacao, nr_ano, tx_capa, tx_diretor, 
    tx_elenco, tx_descricao, nr_avaliacao) values(?,?,?,?,?,?,?,?,?,?,?);

select  sysdate from dual;