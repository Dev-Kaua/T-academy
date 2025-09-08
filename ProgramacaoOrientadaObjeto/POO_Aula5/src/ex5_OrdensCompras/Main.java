package ex5_OrdensCompras;

public class Main {
    public static void main(String[] args) {
        CarrinhodeCompras carrinho = new CarrinhodeCompras();

        carrinho.adicionarItem(new ProdutoFisico("Impressora", 800.0, 90.0));
        carrinho.adicionarItem(new ProdutoDigital("E-book de Python", 50.0));
        carrinho.adicionarItem(new ProdutoFisico("Notebook", 3500.0, 150.0));

        carrinho.imprimirResumo();

    }
}
