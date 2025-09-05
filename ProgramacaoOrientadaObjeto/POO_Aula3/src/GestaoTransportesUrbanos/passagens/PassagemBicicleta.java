package GestaoTransportesUrbanos.passagens;

public class PassagemBicicleta extends Passagem{
    private static final double valorPassagem = 2;

    public PassagemBicicleta(int id, double saldoInicial) {
        super(id, saldoInicial);
    }

    @Override
    public boolean validarPassagem(double custo) {
        if(getSaldo() >= valorPassagem){
            debitar(valorPassagem);
            System.out.println("Passagem de bicicleta validada com sucesso! Saldo restante: R$" + getSaldo());
            return true;
        }else {
            System.out.println("Saldo insuficiente pra comprar a passagem de bicicleta!");
            return false;
        }
    }
}
