package ex2_GestaoDeEstoque;

public class Main {
    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        Produto produto1 = new Produto("Maquita", 129.90);
        Produto produto2 = new Produto("Acer Aspire", 1199.90);

        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);

        estoque.adicionarEstoqueProduto("Maquita", 10);                // Sem desconto
        estoque.adicionarEstoqueProduto("Acer Aspire", 5, 120.0);      // Com desconto

        System.out.println("\nAntes das vendas:");
        estoque.listarProdutos();

        estoque.venderProduto("Maquita", 3);
        estoque.venderProduto("Acer Aspire", 2);

        System.out.println("\nApós vendas:");
        estoque.listarProdutos();

        //historico da maquita
        produto1.mostrarHistorico();

        //historico do notebook
        produto2.mostrarHistorico();
    }
}
