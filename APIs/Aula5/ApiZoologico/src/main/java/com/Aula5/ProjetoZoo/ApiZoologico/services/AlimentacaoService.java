package com.Aula5.ProjetoZoo.ApiZoologico.services;

import com.Aula5.ProjetoZoo.ApiZoologico.dtos.AlimentacaoDto;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Alimentacao;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Animal;
import com.Aula5.ProjetoZoo.ApiZoologico.repositorys.AlimentacaoRepository;
import com.Aula5.ProjetoZoo.ApiZoologico.repositorys.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlimentacaoService{

    private final AlimentacaoRepository alimentacaoRepository;
    private final AnimalRepository animalRepository;

    public AlimentacaoService(AlimentacaoRepository alimentacaoRepository, AnimalRepository animalRepository) {
        this.alimentacaoRepository = alimentacaoRepository;
        this.animalRepository = animalRepository;
    }

    private AlimentacaoDto toDto(Alimentacao a) {
        return new AlimentacaoDto(
                a.getId(),
                a.getTipoComida(),
                a.getQuantidadeDiaria(),
                a.getAnimal() != null ? a.getAnimal().getId() : null
        );
    }

    private Alimentacao toEntity(AlimentacaoDto dto) {
        Alimentacao alimentacao = new Alimentacao();
        alimentacao.setId(dto.id());
        alimentacao.setTipoComida(dto.tipoComida());
        alimentacao.setQuantidadeDiaria(dto.quantidadeDiaria());

        if (dto.animalId() != null) {
            Animal animal = animalRepository.findById(dto.animalId())
                    .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
            alimentacao.setAnimal(animal);
        }
        return alimentacao;
    }

    public List<AlimentacaoDto> findAllDto() {
        return alimentacaoRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public AlimentacaoDto create(AlimentacaoDto alimentacaoDto) {
        Alimentacao entity = toEntity(alimentacaoDto);
        Alimentacao alimentacaoSalvo = alimentacaoRepository.save(entity);
        return toDto(alimentacaoSalvo);
    }

    public AlimentacaoDto findDtoById(Long id) {
        return alimentacaoRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Alimentação não encontrada"));
    }

    public AlimentacaoDto update(Long id, AlimentacaoDto dto) {
        Alimentacao existente = alimentacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alimentação não encontrada"));

        existente.setTipoComida(dto.tipoComida());
        existente.setQuantidadeDiaria(dto.quantidadeDiaria());

        if (dto.animalId() != null) {
            Animal animal = animalRepository.findById(dto.animalId())
                    .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
            existente.setAnimal(animal);
        } else {
            existente.setAnimal(null);
        }

        Alimentacao atualizado = alimentacaoRepository.save(existente);
        return toDto(atualizado);
    }

    public void delete(Long id) {
        Alimentacao existente = alimentacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alimentação não encontrada"));
        alimentacaoRepository.delete(existente);
    }

    public List<AlimentacaoDto> findDtoByTipoComida(String tipoComidaStr) {
        try {
            Alimentacao.TipoComida tipo = Alimentacao.TipoComida.valueOf(tipoComidaStr.toUpperCase());
            return alimentacaoRepository.findByTipoComida(tipo)
                    .stream()
                    .map(this::toDto)
                    .toList();
        } catch (IllegalArgumentException e) {
            return new ArrayList<>();
        }
    }

    public List<AlimentacaoDto> findDtoByAnimalId(Long animalId) {
        return alimentacaoRepository.findByAnimalId(animalId)
                .stream()
                .map(this::toDto)
                .toList();
    }
}
