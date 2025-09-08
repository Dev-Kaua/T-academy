package ex5_OrdensCompras;

public class DescontoFixo implements Desconto{
    private double valorFixo;

    public DescontoFixo(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    @Override
    public double aplicarDesconto(double valor) {
        return Math.max(0, valor - valorFixo);
    }
}
