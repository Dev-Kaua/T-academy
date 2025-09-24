package com.example.Projeto_Relacoes.controllers;

import com.example.Projeto_Relacoes.models.Autor;
import com.example.Projeto_Relacoes.services.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAll(){
        return ResponseEntity.ok(autorService.listAll());
    }
    @PostMapping
    public ResponseEntity<Autor> add(@RequestBody Autor autor){
        return ResponseEntity.ok(autorService.create(autor));
    }
}
