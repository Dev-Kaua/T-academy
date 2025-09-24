package com.example.Projeto_Relacoes.repositories;

import com.example.Projeto_Relacoes.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
