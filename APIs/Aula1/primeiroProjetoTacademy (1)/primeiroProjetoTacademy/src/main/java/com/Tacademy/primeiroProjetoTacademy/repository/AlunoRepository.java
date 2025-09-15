package com.Tacademy.primeiroProjetoTacademy.repository;

import com.Tacademy.primeiroProjetoTacademy.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
