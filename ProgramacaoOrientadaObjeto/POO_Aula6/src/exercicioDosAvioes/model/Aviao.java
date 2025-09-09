package exercicioDosAvioes.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Aviao {
    private String modelo;
    private String id; // identificador único
    private int capacidade;
    private boolean emVoo = false;

    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Passageiro> passageiros = new ArrayList<>();

    private LocalTime horaChegada;

    public Aviao(String modelo, String prefixo, int capacidade) {
        this.modelo = modelo;
        this.id = prefixo;
        this.capacidade = capacidade;
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isEmVoo() {
        return emVoo;
    }

    public int getFuncionariosCount() {
        return funcionarios.size();
    }

    public int getPassageirosCount() {
        return passageiros.size();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println(funcionario.getNome() + " foi adicionado(a) à tripulação do avião " + id);
    }

    public void removerFuncionario(Funcionario funcionario) {
        if (funcionarios.remove(funcionario)) {
            System.out.println(funcionario.getNome() + " foi removido(a) da tripulação do avião " + id);
        } else {
            System.out.println(funcionario.getNome() + " não faz parte da tripulação.");
        }
    }

    public void adicionarPassageiro(Passageiro passageiro) {
        if (passageiros.size() < capacidade) {
            passageiros.add(passageiro);
            System.out.println(passageiro.getNome() + " embarcou no avião " + id);
        } else {
            System.out.println("Avião lotado! Não é possível adicionar " + passageiro.getNome());
        }
    }

    public void removerPassageiro(Passageiro passageiro) {
        if (passageiros.remove(passageiro)) {
            System.out.println(passageiro.getNome() + " desembarcou do avião " + id);
        } else {
            System.out.println(passageiro.getNome() + " não está no avião.");
        }
    }

    public void listarFuncionarios() {
        System.out.println("Tripulação do avião " + id + ":");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário registrado.");
        } else {
            for (Funcionario f : funcionarios) {
                System.out.println("- " + f.getNome());
            }
        }
    }

    public void listarPassageiros() {
        System.out.println("Passageiros do avião " + id + ":");
        if (passageiros.isEmpty()) {
            System.out.println("Nenhum passageiro registrado.");
        } else {
            for (Passageiro p : passageiros) {
                System.out.println("- " + p.getNome());
            }
        }
    }

    public void iniciarVoo(LocalTime horaPartida, LocalTime horaChegada) {
        if (emVoo) {
            System.out.println("Avião " + id + " já está em voo!");
            return;
        }
        emVoo = true;
        this.horaChegada = horaChegada;
        System.out.println("Avião " + id + " decolou às " + horaPartida + " e chegará às " + horaChegada);
    }

    public void verificarDisponibilidade(LocalTime agora) {
        if (emVoo && agora.isAfter(horaChegada)) {
            emVoo = false;
            System.out.println("Avião " + id + " pousou e está disponível novamente!");
        }
    }
}