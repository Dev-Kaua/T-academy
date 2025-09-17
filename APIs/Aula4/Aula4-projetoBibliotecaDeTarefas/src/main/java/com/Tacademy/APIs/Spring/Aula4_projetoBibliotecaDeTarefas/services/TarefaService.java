package com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.services;

import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.DTOs.TarefaRequestDto;
import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.DTOs.TarefaResponseDto;
import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models.Status;
import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models.Tarefa;
import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TarefaService {
    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<TarefaResponseDto> findAll(){
        return tarefaRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public TarefaResponseDto create(TarefaRequestDto dto){
        if (dto.prazo() != null && dto.prazo().isBefore(LocalDate.now())) {
            throw new RuntimeException("O prazo não pode ser anterior à data de criação.");
        }

        Tarefa tarefaNova = new Tarefa();
        tarefaNova.setTitulo(dto.titulo());
        tarefaNova.setDescricao(dto.descricao());
        tarefaNova.setStatus(dto.status());
        tarefaNova.setPrazo(dto.prazo());

        Tarefa salva = tarefaRepository.save(tarefaNova);
        return toResponseDto(salva);
    }

    private TarefaResponseDto toResponseDto(Tarefa tarefa) {
        return new TarefaResponseDto(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getDataCriacao(),
                tarefa.getPrazo()
        );
    }

    public TarefaResponseDto findById(Long id){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("A tarefa de ID: "+ id + " não foi encontrada."));
        return toResponseDto(tarefa);
    }

    public TarefaResponseDto update(Long id, TarefaRequestDto dto){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("A tarefa de ID: " + id + " não foi encontrada."));

        if (dto.prazo() != null && dto.prazo().isBefore(tarefa.getDataCriacao())) {
            throw new RuntimeException("O prazo não pode ser anterior à data de criação.");
        }

        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setStatus(dto.status());
        tarefa.setPrazo(dto.prazo());

        Tarefa updated = tarefaRepository.save(tarefa);
        return toResponseDto(updated);
    }

    public void delete(Long id){
        if(!tarefaRepository.existsById(id)){
            throw new RuntimeException("A tarefa com o ID: "+id+" não foi encontrada");
        }
        tarefaRepository.deleteById(id);
    }

    public List<TarefaResponseDto> findByStatus(Status status){
        return tarefaRepository.findByStatus(status)
                .stream()
                .map(this::toResponseDto)
                .toList();
    }
}
