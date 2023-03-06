package com.fss.fresquinhos.domain;
import jakarta.validation.constraints.NotBlank;
import org.jetbrains.annotations.NotNull;
import java.math.BigDecimal;



public record DadosCadastroReceitas(
        @NotBlank
        String nome,

        @NotNull
        Categorias categorias,

        String descricao,

        String ingredientes,

        String tempo,

        Preparo preparo,

        String porcao,

        BigDecimal preco
) {
}
