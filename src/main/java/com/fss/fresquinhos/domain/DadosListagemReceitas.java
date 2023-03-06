package com.fss.fresquinhos.domain;
import java.math.BigDecimal;


public record DadosListagemReceitas(Long id, String nome, String ingredientes, Categorias categoria, String descricao, String tempo, String porcao, Preparo preparo, BigDecimal preco) {

    public DadosListagemReceitas(Receitas receitas){
        this(receitas.getId(), receitas.getNome(), receitas.getIngredientes(),receitas.getCategorias(), receitas.getDescricao(), receitas.getTempo(), receitas.getPorcao(), receitas.getPreparo(), receitas.getPreco());

    }
}
