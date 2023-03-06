package com.fss.fresquinhos.controller;
import com.fss.fresquinhos.domain.DadosCadastroReceitas;
import com.fss.fresquinhos.domain.DadosListagemReceitas;
import com.fss.fresquinhos.domain.Receitas;
import com.fss.fresquinhos.domain.ReceitasRepository;
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
@RequestMapping("receitas")
public class ReceitasController {

    @Autowired
    private ReceitasRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroReceitas dados, UriComponentsBuilder uriBuilder) {
        var receitas = new Receitas(dados);
        repository.save(receitas);
        return ResponseEntity.ok(receitas);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemReceitas>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemReceitas::new);
        return ResponseEntity.ok(page);
    }
}




