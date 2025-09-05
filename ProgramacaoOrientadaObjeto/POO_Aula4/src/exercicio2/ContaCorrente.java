package exercicio2;

public class ContaCorrente extends ContaBancaria{
    private double limiteChequeEspecial;

    public ContaCorrente(String titular, Double saldo, double limiteChequeEspecial) {
        super(titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacarDinheiro(double valor) {
        if(valor <= limiteChequeEspecial){
        super.sacarDinheiro(valor);
        }else{
            System.out.println("O valor de saque excedeu seu limite! não foi possivel realizar o saque.");
        }
    }
}
