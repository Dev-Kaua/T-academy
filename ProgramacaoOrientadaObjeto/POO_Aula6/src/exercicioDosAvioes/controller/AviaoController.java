package exercicioDosAvioes.controller;

import exercicioDosAvioes.model.Aviao;
import exercicioDosAvioes.model.Funcionario;
import exercicioDosAvioes.model.Passageiro;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AviaoController {
    private List<Aviao> listaAvioes = new ArrayList<>();

    public boolean adicionarAviao(Aviao aviao) {
        if (buscarPorId(aviao.getId()) != null) {
            System.out.println("Avião com ID " + aviao.getId() + " já existe!");
            return false;
        }
        listaAvioes.add(aviao);
        System.out.println("Avião " + aviao.getId() + " adicionado com sucesso.");
        return true;
    }

    public void listarAvioes() {
        System.out.println("=== Lista de aviões ===");
        for (Aviao aviao : listaAvioes) {
            String status = aviao.isEmVoo() ? "Em voo" : "Disponível";
            System.out.println("- " + aviao.getId() + " | Modelo: " + aviao.getModelo() +
                    " | Status: " + status +
                    " | Passageiros: " + aviao.getPassageirosCount() +
                    " | Tripulação: " + aviao.getFuncionariosCount());
        }
    }

    public Aviao buscarPorId(String id) {
        for (Aviao aviao : listaAvioes) {
            if (aviao.getId().equalsIgnoreCase(id)) {
                return aviao;
            }
        }
        return null;
    }

    public void adicionarPassageiro(String id, Passageiro p) {
        Aviao aviao = buscarPorId(id);
        if (aviao != null) {
            aviao.adicionarPassageiro(p);
        } else {
            System.out.println("Avião não encontrado!");
        }
    }

    public void adicionarFuncionario(String id, Funcionario f) {
        Aviao aviao = buscarPorId(id);
        if (aviao != null) {
            aviao.adicionarFuncionario(f);
        } else {
            System.out.println("Avião não encontrado!");
        }
    }

    public void removerPassageiro(String id, Passageiro p) {
        Aviao aviao = buscarPorId(id);
        if (aviao != null) {
            aviao.removerPassageiro(p);
        } else {
            System.out.println("Avião não encontrado!");
        }
    }

    public void removerFuncionario(String id, Funcionario f) {
        Aviao aviao = buscarPorId(id);
        if (aviao != null) {
            aviao.removerFuncionario(f);
        } else {
            System.out.println("Avião não encontrado!");
        }
    }

    public void iniciarVoo(String id, LocalTime horaPartida, LocalTime horaChegada) {
        Aviao aviao = buscarPorId(id);
        if (aviao != null) {
            aviao.iniciarVoo(horaPartida, horaChegada);
        } else {
            System.out.println("Avião não encontrado!");
        }
    }

    public void atualizarStatus(LocalTime agora) {
        for (Aviao aviao : listaAvioes) {
            aviao.verificarDisponibilidade(agora);
        }
    }
}