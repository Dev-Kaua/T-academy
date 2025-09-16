package com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.controller;

import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.DTOs.TimeDto;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Tecnico;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Time;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories.TecnicoRepository;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {
    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @GetMapping
    public List<Time> getAll(){
        return timeRepository.findAll();
    }

    @GetMapping("/cidade/{cidade}")
    public List<Time> findByCidade (@PathVariable String cidade){
        return timeRepository.findByCidade(cidade);
    }

    @PostMapping
    public Time createTime(@RequestBody TimeDto timeDto){
        Time time = new Time();
        time.setNome(timeDto.nome());
        time.setCidade(timeDto.cidade());

        // Se vier tecnicoId, associa o técnico
        if (timeDto.tecnicoId() != null) {
            Tecnico tecnico = tecnicoRepository.findById(timeDto.tecnicoId())
                    .orElseThrow(() -> new RuntimeException("Técnico não encontrado"));
            time.setTecnico(tecnico);
        }

        return timeRepository.save(time);
    }

    @PostMapping("/criarVariosTimes")
    public List<Time> createTimes(@RequestBody List<TimeDto> dtoList){
        List<Time> times = dtoList.stream().map(dto -> {
            Time time = new Time();
            time.setNome(dto.nome());
            time.setCidade(dto.cidade());

            if (dto.tecnicoId() != null) {
                Tecnico tecnico = tecnicoRepository.findById(dto.tecnicoId())
                        .orElseThrow(() -> new RuntimeException("Técnico não encontrado"));
                time.setTecnico(tecnico);
            }

            return time;
        }).toList();

        return timeRepository.saveAll(times);
    }
}
