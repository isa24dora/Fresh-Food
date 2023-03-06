package com.fss.fresquinhos.ingredientes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    public Ingredientes(DadosCadastroIngredientes dados) {
        this.nome = dados.nome();
    }
}
