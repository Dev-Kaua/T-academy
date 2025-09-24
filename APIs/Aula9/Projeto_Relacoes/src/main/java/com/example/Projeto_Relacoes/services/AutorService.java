package com.example.Projeto_Relacoes.services;

import com.example.Projeto_Relacoes.models.Autor;
import com.example.Projeto_Relacoes.repositories.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listAll(){
        return autorRepository.findAll();
    }

    public Optional<Autor> findById(Long id){
        return autorRepository.findById(id);
    }

    public Autor create( Autor autor){
        return autorRepository.save(autor);
    }

}
