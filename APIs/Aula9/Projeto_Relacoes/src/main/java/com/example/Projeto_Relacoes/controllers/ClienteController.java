package com.example.Projeto_Relacoes.controllers;

import com.example.Projeto_Relacoes.Dtos.ClienteRequest;
import com.example.Projeto_Relacoes.Dtos.ClienteResponse;
import com.example.Projeto_Relacoes.models.Cliente;
import com.example.Projeto_Relacoes.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> add(@RequestBody ClienteRequest request){
        return ResponseEntity.ok(clienteService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getAll(){
        return ResponseEntity.ok(clienteService.listAll());
    }
}
