package com.APIs.aula3.projeto3.Spring.boot.T_academy.controllers;

import com.APIs.aula3.projeto3.Spring.boot.T_academy.models.Era;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.services.EraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/eras")
public class EraController {
    private EraService eraService;

    public EraController(EraService eraService) {
        this.eraService = eraService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok(eraService.findAll());
        } catch (RuntimeException e) {
            return buildErrorResponse("Eras não encontradas", e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(eraService.findById(id));
        } catch (RuntimeException e) {
            return buildErrorResponse("A era de id "+ id +" não foi encontrada"
                    , e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Era era){
        try {
            Era novaEra = eraService.create(era);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaEra);
        } catch (RuntimeException e) {
            return buildErrorResponse("Não foi possível criar a nova era. verifique a formatação."
                    , e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> uodate(@PathVariable Long id, @RequestBody Era era){
        try{
            return ResponseEntity.ok(eraService.update(id, era));
        } catch (RuntimeException e) {
            return buildErrorResponse("Não foi possível atualizar a era."
                    , e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            eraService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return buildErrorResponse("Não foi possível deletar a era de id "+ id
                    , e.getMessage(), HttpStatus.NOT_FOUND);
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
