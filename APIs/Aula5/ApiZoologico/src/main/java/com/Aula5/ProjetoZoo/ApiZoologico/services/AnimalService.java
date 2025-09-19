package com.Aula5.ProjetoZoo.ApiZoologico.services;

import com.Aula5.ProjetoZoo.ApiZoologico.dtos.AnimalDto;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Animal;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Cuidador;
import com.Aula5.ProjetoZoo.ApiZoologico.models.Habitat;
import com.Aula5.ProjetoZoo.ApiZoologico.repositories.AnimalRepository;
import com.Aula5.ProjetoZoo.ApiZoologico.repositories.CuidadorRepository;
import com.Aula5.ProjetoZoo.ApiZoologico.repositories.HabitatRepository;
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


    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }


    public Animal create(AnimalDto dto) {
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

    public Animal update(Long id, AnimalDto dto) {
        Animal existente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        existente.setNome(dto.nome());
        existente.setEspecie(dto.especie());
        existente.setIdade(dto.idade());

        if (dto.habitatId() != null) {
            Habitat habitat = habitatRepository.findById(dto.habitatId())
                    .orElseThrow(() -> new RuntimeException("Habitat não encontrado"));
            existente.setHabitat(habitat);
        }

        if (dto.cuidadorId() != null) {
            Cuidador cuidador = cuidadorRepository.findById(dto.cuidadorId())
                    .orElseThrow(() -> new RuntimeException("Cuidador não encontrado"));
            existente.setCuidador(cuidador);
        }

        return animalRepository.save(existente);
    }

    public void delete(Long id) {
        Animal existente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        animalRepository.delete(existente);
    }

    public List<Animal> findByEspecie(String especie) {
        return animalRepository.findByEspecie(especie);
    }

    public List<Animal> findByIdadeBetween(int idadeMin, int idadeMax) {
        return animalRepository.findByIdadeBetween(idadeMin, idadeMax);
    }

    public List<Animal> findByNome(String nome) {
        return animalRepository.findByNome(nome);
    }
}
