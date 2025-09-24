package com.example.Projeto_Relacoes.services;

import com.example.Projeto_Relacoes.Dtos.ClienteRequest;
import com.example.Projeto_Relacoes.Dtos.ClienteResponse;
import com.example.Projeto_Relacoes.Dtos.ViaCepResponse;
import com.example.Projeto_Relacoes.models.Cliente;
import com.example.Projeto_Relacoes.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final RestTemplate restTemplate;

    public ClienteService(ClienteRepository clienteRepository, RestTemplate restTemplate) {
        this.clienteRepository = clienteRepository;
        this.restTemplate = restTemplate;
    }

    public ClienteResponse create(ClienteRequest request){
        String url = "https://viacep.com.br/ws/" + request.cep() + "/json/";
        ViaCepResponse viaCep = restTemplate.getForObject(url, ViaCepResponse.class);

        if (viaCep == null || viaCep.cep() == null) {
            throw new RuntimeException("CEP inválido ou não encontrado.");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setEmail(request.email());
        cliente.setCep(request.cep());
        cliente.setCidade(viaCep.localidade());
        cliente.setEstado(viaCep.uf());
        cliente.setBairro(viaCep.bairro());

        Cliente saved = clienteRepository.save(cliente);

        return new ClienteResponse(
                saved.getId(),
                saved.getNome(),
                saved.getEmail(),
                saved.getCep(),
                saved.getCidade(),
                saved.getEstado(),
                saved.getBairro()
        );
    }

    public List<ClienteResponse> listAll() {
        return clienteRepository.findAll().stream()
                .map(c -> new ClienteResponse(
                        c.getId(),
                        c.getNome(),
                        c.getEmail(),
                        c.getCep(),
                        c.getCidade(),
                        c.getEstado(),
                        c.getBairro()
                ))
                .toList();
    }
}
