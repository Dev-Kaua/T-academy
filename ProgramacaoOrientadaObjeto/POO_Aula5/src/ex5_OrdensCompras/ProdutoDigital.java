package ex5_OrdensCompras;

public class ProdutoDigital extends Item{
    public ProdutoDigital( String nome, double preco) {
        super(nome, preco);
        this.categoria = Categoria.DIGITAL;
    }

    @Override
    public double calcularPreco() {
        return preco;
    }
}
