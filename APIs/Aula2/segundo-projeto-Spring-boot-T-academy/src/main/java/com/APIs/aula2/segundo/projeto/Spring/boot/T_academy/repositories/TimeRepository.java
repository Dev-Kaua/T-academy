package com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories;

import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
}
