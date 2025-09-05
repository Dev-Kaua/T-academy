package GestaoTransportesUrbanos.passagens;

public class PassagemOnibus extends Passagem{
    private static final double valorPassagem = 4.5;

    public PassagemOnibus(int id, double saldoInicial) {
        super(id, saldoInicial);
    }

    @Override
    public boolean validarPassagem(double custo) {
        if(getSaldo() >= valorPassagem){
            debitar(valorPassagem);
            System.out.println("Passagem de ônibus validada! Saldo restante: R$"+ getSaldo());
            return true;
        }else{
            System.out.println("Saldo insuficiente para pagar a passagem de ônibus.");
            return false;
        }
    }
}
