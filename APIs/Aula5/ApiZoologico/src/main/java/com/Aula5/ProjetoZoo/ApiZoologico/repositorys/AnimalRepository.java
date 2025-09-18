package com.Aula5.ProjetoZoo.ApiZoologico.repositorys;

import com.Aula5.ProjetoZoo.ApiZoologico.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByEspecieContainingIgnoreCase(String especie);
    List<Animal> findByIdadeBetween(int idadeMin, int idadeMax);
    List<Animal> findByNomeContainingIgnoreCase(String nome);
}
