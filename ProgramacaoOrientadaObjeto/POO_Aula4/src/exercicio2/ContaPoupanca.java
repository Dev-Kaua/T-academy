package exercicio2;

public class ContaPoupanca extends ContaBancaria{
    private double taxaJuros;

    public ContaPoupanca(String titular, Double saldo, double taxaJuros) {
        super(titular, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void aplicarJuros(){
        double novoSaldo = getSaldo() * (1 + taxaJuros);
        setSaldo(novoSaldo);
        System.out.println("--> Os juros foram aplicados com sucesso! Saldo atual: "+ getSaldo());
    }
}
