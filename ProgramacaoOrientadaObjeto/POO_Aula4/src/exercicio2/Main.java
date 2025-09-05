package exercicio2;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("Kauã reis", 3500.0, 1500.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("Luis Javeiro", 12200.50, 0.03);

        contaCorrente.depositar(2800);
        contaPoupanca.depositar(6000);

        contaCorrente.sacarDinheiro(3000);
        contaCorrente.sacarDinheiro(1000);

        contaPoupanca.sacarDinheiro(750);

        contaPoupanca.aplicarJuros();

        contaCorrente.consultarSaldo();
        contaPoupanca.consultarSaldo();
    }
}
