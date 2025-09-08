package ex3_SistemaBancario;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Carlos Silva");
        Cliente cliente2 = new Cliente("Ana Oliveira");
        Cliente cliente3 = new Cliente("João Souza");

        ContaBancaria contaBancaria1 = new ContaBancaria(123, 1000);
        ContaCorrente contaCorrente1 = new ContaCorrente(456, 500);

        ContaBancaria contaBancaria2 = new ContaBancaria(789, 2000);
        ContaCorrente contaCorrente2 = new ContaCorrente(101, 1500);

        ContaBancaria contaBancaria3 = new ContaBancaria(112, 300);
        ContaCorrente contaCorrente3 = new ContaCorrente(113, 700);

        cliente1.adicionarConta(contaBancaria1);
        cliente1.adicionarConta(contaCorrente1);

        cliente2.adicionarConta(contaBancaria2);
        cliente2.adicionarConta(contaCorrente2);

        cliente3.adicionarConta(contaBancaria3);
        cliente3.adicionarConta(contaCorrente3);

        contaBancaria1.depositar(500, "Depósito de salário");
        contaCorrente1.depositar(200, "Depósito de presente");

        contaBancaria1.sacar(300);
        contaCorrente1.sacar(100, 10);

        contaBancaria2.depositar(1000, "Depósito de venda");
        contaCorrente2.depositar(300, "Depósito em conta corrente");

        contaBancaria2.sacar(500);
        contaCorrente2.sacar(200, 5);

        contaBancaria3.depositar(150, "Depósito de economia");
        contaCorrente3.depositar(100, "Depósito extra");

        contaBancaria3.sacar(100);
        contaCorrente3.sacar(50, 5);

        System.out.println("\n>>>> EXTRATOS <<<<");

        cliente1.imprimirExtratoCliente();

        cliente2.imprimirExtratoCliente();

        cliente3.imprimirExtratoCliente();
    }
}
