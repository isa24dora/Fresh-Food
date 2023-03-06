package com.fss.fresquinhos.controller;
import com.fss.fresquinhos.ingredientes.DadosCadastroIngredientes;
import com.fss.fresquinhos.ingredientes.DadosListagemIngredientes;
import com.fss.fresquinhos.ingredientes.Ingredientes;
import com.fss.fresquinhos.ingredientes.IngredientesRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("ingredientes")
public class IngredientesController {

        @Autowired
        private IngredientesRepository repository;

        @PostMapping
        @Transactional
        public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroIngredientes dados, UriComponentsBuilder uriBuilder) {
            var ingredientes = new Ingredientes(dados);
            repository.save(ingredientes);
            return ResponseEntity.ok(ingredientes);
        }

    @GetMapping
    public ResponseEntity<Page<Object>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<Object> page;
        page = repository.findAll(paginacao).map(ingrediente -> new DadosListagemIngredientes(ingrediente.getId(), ingrediente.getNome()));
        return ResponseEntity.ok(page);
        }
    }



