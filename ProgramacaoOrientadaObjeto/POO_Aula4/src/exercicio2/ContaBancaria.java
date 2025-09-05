package exercicio2;

public abstract class ContaBancaria {
    private String titular;
    private Double saldo;

    public ContaBancaria(String titular, Double saldo) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public String getTitular() {
        return titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor){
        saldo += valor;
        System.out.println("--- Depósito realizado com sucesso  |  Saldo atual: R$"+ saldo);
    }

    public void sacarDinheiro(double valor){
        saldo -= valor;
        System.out.println("--- Saque realizado com sucesso  |  Saldo atual: R$"+ saldo);
    }

    public void consultarSaldo(){
        System.out.println("\nSaldo atual: R$"+ saldo);
    }
}
