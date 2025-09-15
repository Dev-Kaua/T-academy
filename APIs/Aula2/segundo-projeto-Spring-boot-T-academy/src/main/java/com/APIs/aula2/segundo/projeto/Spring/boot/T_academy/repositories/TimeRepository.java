package com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories;

import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    List<Time> findByCidade(String cidade);
}
