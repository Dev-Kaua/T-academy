package GestaoTransportesUrbanos.passagens;

public class PassagemMetro extends Passagem{

    private static final double valorPassagem = 5;

    public PassagemMetro(int id, double saldoInicial) {
        super(id, saldoInicial);
    }

    @Override
    public boolean validarPassagem(double custo) {
        if(getSaldo() >= valorPassagem){
            System.out.println("Passagem de metro validada com sucesso! Saldo restante: R$"+ getSaldo());
            return true;
        }else{
            System.out.println("Saldo insuficiente para pagar a passagem de metrô");
            return false;
        }
    }
}
