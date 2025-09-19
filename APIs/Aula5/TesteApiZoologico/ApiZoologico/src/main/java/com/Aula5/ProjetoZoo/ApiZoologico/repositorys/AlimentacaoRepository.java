package com.Aula5.ProjetoZoo.ApiZoologico.repositorys;

import com.Aula5.ProjetoZoo.ApiZoologico.models.Alimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long> {

    List<Alimentacao> findByTipoComida(Alimentacao.TipoComida tipoComida);

    List<Alimentacao> findByAnimalId(Long animalId);
}
