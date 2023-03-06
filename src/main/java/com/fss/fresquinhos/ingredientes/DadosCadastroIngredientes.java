package com.fss.fresquinhos.ingredientes;
import jakarta.validation.constraints.NotBlank;


public record DadosCadastroIngredientes(
        @NotBlank
        String nome) {
}
