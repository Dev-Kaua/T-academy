package com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.repositories;

import com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}
