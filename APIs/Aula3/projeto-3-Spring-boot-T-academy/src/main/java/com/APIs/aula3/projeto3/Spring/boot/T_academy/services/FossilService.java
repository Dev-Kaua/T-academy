package com.APIs.aula3.projeto3.Spring.boot.T_academy.services;

import com.APIs.aula3.projeto3.Spring.boot.T_academy.DTOs.FossilDto;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.models.Categoria;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.models.Era;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.models.Fossil;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.repositories.FossilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FossilService {
    private FossilRepository fossilRepository;
    private CategoriaService categoriaService;
    private EraService eraService;

    public FossilService(FossilRepository fossilRepository, CategoriaService categoriaService, EraService eraService) {
        this.fossilRepository = fossilRepository;
        this.categoriaService = categoriaService;
        this.eraService = eraService;
    }

    public List<Fossil> findAll(){
        return fossilRepository.findAll();
    }

    public Fossil createFromDTO(FossilDto fossilDto){
        Categoria categoria = categoriaService.findById(fossilDto.categoriaId());
        Era era = eraService.findById(fossilDto.eraId());

        Fossil fossil = new Fossil();
        fossil.setNome(fossilDto.nome());
        fossil.setIdade(fossilDto.idade());
        fossil.setEra(era);
        fossil.setCategoria(categoria);
        fossil.setDescricao(fossilDto.descricao());
        return fossilRepository.save(fossil);
    }

    public Fossil findById(Long id){
        return fossilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O fossil de id "+id+" não foi encontrado"));
    }

    public Fossil updateFromDto(Long id, FossilDto fossilDto){
        Fossil fossil = findById(id);
        Categoria categoria = categoriaService.findById(fossilDto.categoriaId());
        Era era = eraService.findById(fossilDto.eraId());

        fossil.setNome(fossilDto.nome());
        fossil.setIdade(fossilDto.idade());
        fossil.setEra(era);
        fossil.setCategoria(categoria);
        fossil.setDescricao(fossilDto.descricao());

        return fossilRepository.save(fossil);
    }

    public void delete(Long id){
        Fossil fossil = findById(id);

        fossilRepository.delete(fossil);
    }
}
