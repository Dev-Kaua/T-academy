package com.APIs.aula3.projeto3.Spring.boot.T_academy.repositories;

import com.APIs.aula3.projeto3.Spring.boot.T_academy.models.Fossil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FossilRepository extends JpaRepository<Fossil, Long> {
}
