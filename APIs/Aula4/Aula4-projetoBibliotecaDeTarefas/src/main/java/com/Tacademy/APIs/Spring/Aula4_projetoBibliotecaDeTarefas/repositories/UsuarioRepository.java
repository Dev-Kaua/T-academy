package com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.repositories;

import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
