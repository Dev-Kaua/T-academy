package com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories;

import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    List<Tecnico> findByTime_Id(Long id);
}
