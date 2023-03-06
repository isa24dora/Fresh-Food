package com.fss.fresquinhos.ingredientes;
import com.fss.fresquinhos.domain.Receitas;



public record DadosListagemIngredientes(Long id, String nome) {

    public DadosListagemIngredientes(Receitas receitas){
        this(receitas.getId(), receitas.getNome());

    }
}
