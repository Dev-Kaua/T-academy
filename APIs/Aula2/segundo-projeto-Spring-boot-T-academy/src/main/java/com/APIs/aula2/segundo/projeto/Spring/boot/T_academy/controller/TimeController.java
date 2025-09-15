package com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.controller;

import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Time;
import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {
    @Autowired
    private TimeRepository timeRepository;

    @GetMapping
    public List<Time> getAll(){
        return timeRepository.findAll();
    }

    @GetMapping("/cidade/{cidade}")
    public List<Time> findByCidade (@PathVariable String cidade){
        return timeRepository.findByCidade(cidade);
    }
}
