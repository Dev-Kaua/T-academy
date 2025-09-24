package com.example.Projeto_Relacoes.services;

import com.example.Projeto_Relacoes.models.Livro;
import com.example.Projeto_Relacoes.repositories.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Page<Livro> findAll(Pageable pageable){
        return livroRepository.findAll(pageable);
    }

    public Livro create(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> findByAutorNaciolidade(String nacionalidade){
        return livroRepository.findByAutoresNacionalidadeIgnoreCase(nacionalidade);
    }
}
