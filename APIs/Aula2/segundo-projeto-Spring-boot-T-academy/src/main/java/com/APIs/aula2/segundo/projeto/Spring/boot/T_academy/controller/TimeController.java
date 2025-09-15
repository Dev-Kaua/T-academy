package com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.controller;

import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.dtos.JogadorDTO;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.dtos.TimeDTO;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Time;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/time")
public class TimeController {
    @Autowired
    private TimeRepository timeRepository;

    @GetMapping
    public List<TimeDTO> getAll() {
        return timeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TimeDTO convertToDTO(Time time) {
        List<JogadorDTO> jogadores = time.getJogadoresList()
                .stream()
                .map(j -> new JogadorDTO(j.getId(), j.getNome()))
                .collect(Collectors.toList());

        return new TimeDTO(time.getId(), time.getNome(), time.getCidade(), jogadores);
    }
}
