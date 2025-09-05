package GestaoTransportesUrbanos.passagens;

public abstract class Passagem {
    private int id;
    private double saldo;

    public Passagem(int id, double saldoInicial) {
        this.id = id;
        this.saldo = saldoInicial;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double valor){
        if(valor > 0){
            saldo += valor;
            System.out.println("Saldo adicionado: R$"+ valor + " --- Saldo total: R$"+ saldo);
        }else {
            System.out.println("O valor escolhido para ser adicionado deve ser maior que 0!");
        }
    }

    //cada transporte vai ter um jeito diferente de validar a passagem :)
    public abstract boolean validarPassagem(double custo);

    public void exibirInfo(){
        System.out.println("Passagem ID: "+ id + " --- Saldo: R$"+ saldo);
    }

    protected void debitar(double valor){
        saldo -= valor;
    }
}
