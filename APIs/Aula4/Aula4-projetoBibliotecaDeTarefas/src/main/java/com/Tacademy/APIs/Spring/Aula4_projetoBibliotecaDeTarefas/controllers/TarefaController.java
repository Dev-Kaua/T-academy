package com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.controllers;

import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.DTOs.TarefaRequestDto;
import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.DTOs.TarefaResponseDto;
import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models.Status;
import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models.Tarefa;
import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.services.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
   private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok(tarefaService.findAll());
        }catch (RuntimeException e){
            return buildErrorResponse("Erro ao buscar as tarefas",
                    e.getMessage(), HttpStatus.NOT_FOUND );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(tarefaService.findById(id));
        } catch (RuntimeException e) {
            return buildErrorResponse("A tarefa de ID: "+id+" não foi encontrada"
                    , e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TarefaRequestDto dto){
        try{
            TarefaResponseDto novaTarefa =tarefaService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
        } catch (RuntimeException e) {
            return buildErrorResponse("Não foi possivel criar a tarefa",
                    e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TarefaRequestDto dto){
        try{
            return ResponseEntity.ok(tarefaService.update(id, dto));
        } catch (RuntimeException e) {
            return buildErrorResponse("Não foi possivel atualizar a tarefa. Verifique o id e" +
                    " a inserção dos dados da tarefa.", e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            tarefaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return buildErrorResponse("Não foi possivel encontrar o usuário de ID: "+id,
                    e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pesquisa")
    public ResponseEntity<?> getByStatus(@RequestParam Status status){
        try{
            return  ResponseEntity.ok(tarefaService.findByStatus(status));
        } catch (RuntimeException e) {
            return buildErrorResponse("Erro ao buscar tarefas por status",
                    e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse
            (String error, String message, HttpStatus status){
        Map<String, Object>body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("Status", status.value());
        body.put("error", error);
        body.put("message", message);

        return ResponseEntity.status(status).body(body);
    }
}
