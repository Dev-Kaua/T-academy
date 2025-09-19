package com.Aula5.ProjetoZoo.ApiZoologico.services;

import com.Aula5.ProjetoZoo.ApiZoologico.dtos.AnimalDto;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Animal;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Cuidador;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Habitat;
import com.Aula5.ProjetoZoo.ApiZoologico.repositorys.AnimalRepository;
import com.Aula5.ProjetoZoo.ApiZoologico.repositorys.CuidadorRepository;
import com.Aula5.ProjetoZoo.ApiZoologico.repositorys.HabitatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final HabitatRepository habitatRepository;
    private final CuidadorRepository cuidadorRepository;

    public AnimalService(AnimalRepository animalRepository, HabitatRepository habitatRepository,
                         CuidadorRepository cuidadorRepository) {
        this.animalRepository = animalRepository;
        this.habitatRepository = habitatRepository;
        this.cuidadorRepository = cuidadorRepository;
    }

    private AnimalDto toDto(Animal a) {
        return new AnimalDto(
                a.getId(),
                a.getNome(),
                a.getEspecie(),
                a.getIdade(),
                a.getHabitat() != null ? a.getHabitat().getId() : null,
                a.getCuidador() != null ? a.getCuidador().getId() : null
        );
    }

    private Animal toEntity(AnimalDto dto) {
        Habitat habitat = dto.habitatId() != null ? habitatRepository.findById(dto.habitatId()).orElse(null) : null;
        Cuidador cuidador = dto.cuidadorId() != null ? cuidadorRepository.findById(dto.cuidadorId()).orElse(null) : null;

        Animal animal = new Animal();
        animal.setId(dto.id());
        animal.setNome(dto.nome());
        animal.setEspecie(dto.especie());
        animal.setIdade(dto.idade());
        animal.setHabitat(habitat);
        animal.setCuidador(cuidador);
        return animal;
    }

    public List<AnimalDto> findAll() {
        return animalRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public AnimalDto findById(Long id) {
        Animal a = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        return toDto(a);
    }

    public AnimalDto create(AnimalDto dto) {
        Animal animal = toEntity(dto);
        Animal salvo = animalRepository.save(animal);
        return toDto(salvo);
    }

    public AnimalDto update(Long id, AnimalDto dto) {
        Animal existente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        existente.setNome(dto.nome());
        existente.setEspecie(dto.especie());
        existente.setIdade(dto.idade());
        existente.setHabitat(dto.habitatId() != null ? habitatRepository.findById(dto.habitatId()).orElse(null) : null);
        existente.setCuidador(dto.cuidadorId() != null ? cuidadorRepository.findById(dto.cuidadorId()).orElse(null) : null);

        Animal atualizado = animalRepository.save(existente);
        return toDto(atualizado);
    }

    public void delete(Long id) {
        Animal existente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        animalRepository.delete(existente);
    }

    public List<AnimalDto> findByEspecie(String especie) {
        return animalRepository.findByEspecieContainingIgnoreCase(especie)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<AnimalDto> findByIdadeBetween(int idadeMin, int idadeMax) {
        return animalRepository.findByIdadeBetween(idadeMin, idadeMax)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<AnimalDto> findByNome(String nome) {
        return animalRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
