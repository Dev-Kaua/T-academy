package ex5_OrdensCompras;

public class ProdutoFisico extends Item{
    private double valorFrete;

    public ProdutoFisico( String nome, double preco, double valorFrete) {
        super(nome, preco);
        this.valorFrete = valorFrete;
        this.categoria = Categoria.FISICO;
    }

    @Override
    public double calcularPreco() {
        return preco + valorFrete;
    }
}
