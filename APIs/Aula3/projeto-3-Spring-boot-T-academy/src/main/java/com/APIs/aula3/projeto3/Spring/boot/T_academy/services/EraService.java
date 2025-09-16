package com.APIs.aula3.projeto3.Spring.boot.T_academy.services;

import com.APIs.aula3.projeto3.Spring.boot.T_academy.models.Era;
import com.APIs.aula3.projeto3.Spring.boot.T_academy.repositories.EraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EraService {
    private EraRepository eraRepository;

    public EraService(EraRepository eraRepository) {
        this.eraRepository = eraRepository;
    }

    public List<Era> findAll(){
        return eraRepository.findAll();
    }

    public Era create(Era era){
        return eraRepository.save(era);
    }

    public Era findById(Long id){
        return eraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("A categoria de id "+ id + " não foi encontrada."));
    }

    public Era update(Long id, Era eraAtualizada){
        Era era = findById(id);

        era.setNome(eraAtualizada.getNome());
        era.setPeriodo(eraAtualizada.getPeriodo());
        return eraRepository.save(era);
    }

    public void delete(Long id){
        Era era = findById(id);
        eraRepository.delete(era);
    }
}
