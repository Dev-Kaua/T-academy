package com.example.Projeto_Relacoes.controllers;

import com.example.Projeto_Relacoes.models.Livro;
import com.example.Projeto_Relacoes.services.LivroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<Page<Livro>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5")int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
    ){
        Sort.Direction direction = sort[1].equalsIgnoreCase("desc") ?
                Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));
        return ResponseEntity.ok(livroService.findAll(pageable));
    }


    @PostMapping
    public ResponseEntity<Livro> add(@RequestBody Livro livro){
        return ResponseEntity.ok(livroService.create(livro));
    }
    @GetMapping("/autor/nacionalidade/{nacionalidade}")
    public ResponseEntity<List<Livro>> getByAutorNacion(@PathVariable String nacionalidade){
        return ResponseEntity.ok(livroService.findByAutorNaciolidade(nacionalidade));
    }
}
