package com.Aula5.ProjetoZoo.ApiZoologico.services;

import com.Aula5.ProjetoZoo.ApiZoologico.dtos.AnimalDto;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Animal;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Cuidador;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Habitat;
import com.Aula5.ProjetoZoo.ApiZoologico.repositories.AnimalRepository;
import com.Aula5.ProjetoZoo.ApiZoologico.repositories.CuidadorRepository;
import com.Aula5.ProjetoZoo.ApiZoologico.repositories.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // ---------- ENTITY ----------
    public List<Animal> findAllEntities() {
        return animalRepository.findAll();
    }

    public Animal findByIdEntity(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    public Animal createEntity(AnimalDto dto) {
        Habitat habitat = habitatRepository.findById(dto.habitatId())
                .orElseThrow(() -> new RuntimeException("Habitat não encontrado"));

        long quantidadeAnimais = animalRepository.countByHabitatId(habitat.getId());
        if (quantidadeAnimais >= habitat.getCapacidadeMaxima()) {
            throw new RuntimeException("Capacidade máxima do habitat atingida");
        }

        Cuidador cuidador = cuidadorRepository.findById(dto.cuidadorId())
                .orElseThrow(() -> new RuntimeException("Cuidador do animal não encontrado"));

        Animal animal = new Animal();
        animal.setNome(dto.nome());
        animal.setIdade(dto.idade());
        animal.setEspecie(dto.especie());
        animal.setCuidador(cuidador);
        animal.setHabitat(habitat);

        return animalRepository.save(animal);
    }

    public Animal updateEntity(Long id, AnimalDto dto) {
        Animal existente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        existente.setNome(dto.nome());
        existente.setEspecie(dto.especie());
        existente.setIdade(dto.idade());
        existente.setHabitat(dto.habitatId() != null ? habitatRepository.findById(dto.habitatId()).orElse(null) : null);
        existente.setCuidador(dto.cuidadorId() != null ? cuidadorRepository.findById(dto.cuidadorId()).orElse(null) : null);

        return animalRepository.save(existente);
    }

    // ---------- CONSULTAS ----------
    public List<Animal> findByEspecieEntity(String especie) {
        return animalRepository.findByEspecie(especie);
    }

    public List<Animal> findByIdadeBetweenEntity(int idadeMin, int idadeMax) {
        return animalRepository.findByIdadeBetween(idadeMin, idadeMax);
    }

    public List<Animal> findByNomeEntity(String nome) {
        return animalRepository.findByNomeContainingIgnoreCase(nome);
    }

    // ---------- DELETE ----------
    public void delete(Long id) {
        Animal existente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        animalRepository.delete(existente);
    }

}
