package com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.repositories;

import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models.Status;
import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByStatus(Status status);
}
