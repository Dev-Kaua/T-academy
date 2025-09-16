package com.APIs.aula3.projeto3.Spring.boot.T_academy.controllers;

import com.APIs.aula3.projeto3.Spring.boot.T_academy.models.Categoria;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(categoriaService.findAll());
        } catch (RuntimeException exception) {
            return buildErrorResponse("Erro ao buscar categorias",
                    exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(categoriaService.findById(id));
        }catch (RuntimeException exception){
            return buildErrorResponse("Categoria não encontrada", exception.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Categoria categoria) {
        try {
            Categoria novaCategoria = categoriaService.create(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
        } catch (RuntimeException exception) {
            return buildErrorResponse("Erro ao criar categoria",
                    exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Categoria categoria){
        try{
            return ResponseEntity.ok(categoriaService.update(id, categoria));
        }catch (RuntimeException exception){
            return buildErrorResponse("Não foi possível atualizar a categoria, categoria não encontrada."
                    , exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            categoriaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return buildErrorResponse("Não foi possível deletar a categoria",
                    exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(String error, String message,
                                                                   HttpStatus status){
        Map<String, Object>body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("Status", status.value());
        body.put("error", error);
        body.put("message", message);

        return ResponseEntity.status(status).body(body);
    }
}
