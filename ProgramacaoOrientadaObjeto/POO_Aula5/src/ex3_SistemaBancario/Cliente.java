package ex3_SistemaBancario;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<ContaBancaria> contas;

    public Cliente(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta){
        for (ContaBancaria c : contas) {
            if (c.getId() == conta.getId()) {
                System.out.println("Conta com o ID " + conta.getId() + " já associada ao cliente.");
                return;
            }
        }
        contas.add(conta);
        System.out.println("Conta com ID " + conta.getId() + " associada ao cliente " + nome+"\n");
    }

    public ContaBancaria getContaById(int id) {
        for (ContaBancaria conta : contas) {
            if (conta.getId() == id) {
                return conta;
            }
        }
        System.out.println("Conta com ID " + id + " não encontrada.");
        return null;
    }


    public void imprimirExtratoCliente() {
        System.out.println("Extrato do cliente ->" + nome + "<- :");
        for (ContaBancaria conta : contas) {
            conta.imprimirExtrato();
            System.out.println("------------------------------");
        }
    }
}
