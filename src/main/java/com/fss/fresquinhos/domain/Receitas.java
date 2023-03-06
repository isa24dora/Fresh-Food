package com.fss.fresquinhos.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;


@Table(name = "receitas")
@Entity(name = "Receita")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Receitas {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;

        private String ingredientes;
        @Enumerated(EnumType.STRING)
        private Categorias categorias;

        private String descricao;

        private Boolean ativo;

        private String tempo;

        @Enumerated(EnumType.STRING)
        private Preparo preparo;
        private String porcao;
        private BigDecimal preco;


        public Receitas(DadosCadastroReceitas dados) {
            this.ativo = true;
            this.nome = dados.nome();
            this.categorias = dados.categorias();
            this.ingredientes = dados.ingredientes();
            this.descricao = dados.descricao();
            this.tempo = dados.tempo();
            this.preco = dados.preco();
            this.porcao = dados.porcao();
            this.preparo = dados.preparo();
        }
    public void excluir() {
        this.ativo = false;
    }
}
