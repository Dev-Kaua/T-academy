package com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.controller;

import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.DTOs.TecnicoDto;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Tecnico;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Time;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories.TecnicoRepository;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping
    public List<Tecnico> getAll (){
        return tecnicoRepository.findAll();
    }

    /**
     * Seleciona o tecnico pelo time_id
     * {time_id} -> variável de caminho
     *
     * @param time_id chave estrangeira do time
     * @Endpoint: http://localhost:8080/tecnico/time/1
     */
    @GetMapping("/time/{time_id}")
    public List<Tecnico> getByTime(@PathVariable Long time_id){
        return tecnicoRepository.findByTime_Id(time_id);
    }

    @PostMapping
    public Tecnico createTecnico(@RequestBody TecnicoDto tecnicoDto){
        Time time = timeRepository.findById(tecnicoDto.TimeId())
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));

        Tecnico tecnico = new Tecnico();
        tecnico.setNome(tecnicoDto.nome());
        tecnico.setTime(time);

        return tecnicoRepository.save(tecnico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTecnico(@PathVariable Long id){
        return tecnicoRepository.findById(id).map(tecnico -> {
            tecnicoRepository.delete(tecnico);
            return ResponseEntity.ok("O técnico com o Id: "+ id+ " foi deletado com sucesso!");
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("O técnico com o ID: "+ id +
            " não foi encontrado."));
    }
}
