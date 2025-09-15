package com.Tacademy.primeiroProjetoTacademy.controller;

import com.Tacademy.primeiroProjetoTacademy.model.Aluno;
import com.Tacademy.primeiroProjetoTacademy.repository.AlunoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<Aluno> getAll(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    @PostMapping
    public String add(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
        return "Aluno criado com sucesso !!!";
    }
}
