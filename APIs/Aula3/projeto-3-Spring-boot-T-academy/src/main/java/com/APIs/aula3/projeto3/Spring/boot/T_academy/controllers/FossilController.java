package com.APIs.aula3.projeto3.Spring.boot.T_academy.controllers;

import com.APIs.aula3.projeto3.Spring.boot.T_academy.DTOs.FossilDto;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.models.Fossil;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.services.CategoriaService;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.services.EraService;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.services.FossilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fosseis")
public class FossilController {
    private FossilService fossilService;

    public FossilController(FossilService fossilService, CategoriaService categoriaService, EraService eraService) {
        this.fossilService = fossilService;
    }

    @GetMapping
    public ResponseEntity<List<Fossil>> getAll(){
        return ResponseEntity.ok(fossilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fossil> getById(@PathVariable Long id){
        return ResponseEntity.ok(fossilService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Fossil> add(@RequestBody FossilDto fossilDto) {
        Fossil novoFossil = fossilService.createFromDTO(fossilDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFossil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fossil> update(@PathVariable Long id, @RequestBody FossilDto fossilDto) {
        Fossil atualizado = fossilService.updateFromDto(id, fossilDto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fossil> delete(@PathVariable Long id){
        fossilService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
