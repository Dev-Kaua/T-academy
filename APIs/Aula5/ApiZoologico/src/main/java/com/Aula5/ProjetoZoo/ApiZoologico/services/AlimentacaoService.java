package com.Aula5.ProjetoZoo.ApiZoologico.services;

import com.Aula5.ProjetoZoo.ApiZoologico.models.Alimentacao;
import com.Aula5.ProjetoZoo.ApiZoologico.repositorys.AlimentacaoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlimentacaoService{

    private final AlimentacaoRepository alimentacaoRepository;

    public AlimentacaoService(AlimentacaoRepository alimentacaoRepository) {
        this.alimentacaoRepository = alimentacaoRepository;
    }

    public List<Alimentacao> findAll() {
        return alimentacaoRepository.findAll();
    }

    public Alimentacao create(Alimentacao alimentacao) {
        return alimentacaoRepository.save(alimentacao);
    }

    public Alimentacao findById(Long id) {
        return alimentacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alimentação não encontrada"));
    }

    public Alimentacao update(Long id, Alimentacao alimentacaoAtualizada) {
        Alimentacao alimentacao = findById(id);
        alimentacao.setTipoComida(alimentacaoAtualizada.getTipoComida());
        alimentacao.setQuantidadeDiaria(alimentacaoAtualizada.getQuantidadeDiaria());
        alimentacao.setAnimal(alimentacaoAtualizada.getAnimal());
        return alimentacaoRepository.save(alimentacao);
    }

    public void delete(Long id) {
        Alimentacao alimentacao = findById(id);
        alimentacaoRepository.delete(alimentacao);
    }

    public List<Alimentacao> findByTipoComida(String tipoComidaStr) {
        try {
            Alimentacao.TipoComida tipo = Alimentacao.TipoComida.valueOf(tipoComidaStr.toUpperCase());
            return alimentacaoRepository.findByTipoComida(tipo);
        } catch (IllegalArgumentException e) {
            return new ArrayList<>();
        }
    }

    public List<Alimentacao> findByAnimalId(Long animalId) {
        return alimentacaoRepository.findByAnimalId(animalId);
    }
}
