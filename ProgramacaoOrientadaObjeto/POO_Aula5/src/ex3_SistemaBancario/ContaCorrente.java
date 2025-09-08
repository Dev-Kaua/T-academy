package ex3_SistemaBancario;

public class ContaCorrente extends ContaBancaria{
    private static final double TAXA_FIXA = 3.0;

    public ContaCorrente(int id, double saldo) {
        super(id, saldo);
    }

    @Override
    public void depositar(double deposito) {
        super.depositar(deposito);
        double taxaFinal = (TAXA_FIXA / 100) * deposito;
        System.out.println("Uma taxa fixa de " + TAXA_FIXA +
                "% será aplicada(pelo depósito em conta corrente)." +
                " Valor final da taxa: R$" + taxaFinal);
        setSaldo(getSaldo() - taxaFinal);
    }

    @Override
    public void depositar(double deposito, String descricao) {
        super.depositar(deposito, descricao);
        double taxaFinal = (TAXA_FIXA / 100) * deposito;
        System.out.println("Uma taxa fixa de " + TAXA_FIXA +
                "% será aplicada(pelo depósito em conta corrente)." +
                " Valor final da taxa: R$" + taxaFinal);
        setSaldo(getSaldo() - taxaFinal);
    }
}
