package ex3_SistemaBancario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaBancaria {
    private int id;
    private double saldo;
    private List<String> historicoTransacoes;

    public ContaBancaria(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;
        this.historicoTransacoes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double deposito){
        if (deposito <= 0) {
            System.out.println("\nValor de depósito inválido!");
            return;
        }
        saldo += deposito;
        adicionarHistorico("Depósito: R$" + deposito);
        System.out.println("\nDepósito realizado com sucesso! Novo saldo: R$" + saldo);
    }

    public void depositar(double deposito, String descricao){
        if (deposito <= 0) {
            System.out.println("\nValor de depósito inválido!");
            return;
        }
        saldo += deposito;
        adicionarHistorico(descricao + ": R$" + deposito);
        System.out.println(descricao + " realizado com sucesso! Novo saldo: R$" + saldo);
    }

    public void sacar(double saque){
        if (saque <= 0) {
            System.out.println("\nValor de saque inválido!");
            return;
        }
        if (saque > saldo) {
            System.out.println("\nSaldo insuficiente para o saque de R$" + saque);
            return;
        }
        saldo -= saque;
        adicionarHistorico("Saque: R$" + saque);
        System.out.println("\nSaque realizado com sucesso! Novo saldo: R$" + saldo);
    }

    public void sacar(double saque, double taxaAdicional){
        if (saque <= 0 || taxaAdicional < 0) {
            System.out.println("\nValores inválidos para saque ou taxa adicional!");
            return;
        }
        if (saque + taxaAdicional > saldo) {
            System.out.println("\nSaldo insuficiente para o saque e taxa adicional de R$" + (saque + taxaAdicional));
            return;
        }

        saldo -= (saque + taxaAdicional);

        adicionarHistorico("Saque: R$" + saque + " + Taxa: R$" + taxaAdicional);
        System.out.println("Saque com uma taxinha adicional realizada com sucesso! Novo saldo: R$"
                + saldo);
    }

    private void adicionarHistorico(String transacao) {
        String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        historicoTransacoes.add(dataHora + " - " + transacao);
    }

    public void imprimirExtrato() {
        System.out.println("\nExtrato da Conta: " + id);
        System.out.println("Saldo Atual: R$" + saldo);
        System.out.println("Histórico de Transações:");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }
}
