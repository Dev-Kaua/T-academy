package com.APIs.aula3.projeto3.Spring.boot.T_academy.services;

import com.APIs.aula3.projeto3.Spring.boot.T_academy.models.Categoria;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria findById(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("A categoria de id "+ id + " não foi encontrada."));
    }

    public Categoria update(Long id, Categoria categoriaAtualizada){
        Categoria categoria = findById(id);

        categoria.setNome(categoriaAtualizada.getNome());
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id){
        Categoria categoria = findById(id);
        categoriaRepository.delete(categoria);
    }
}
