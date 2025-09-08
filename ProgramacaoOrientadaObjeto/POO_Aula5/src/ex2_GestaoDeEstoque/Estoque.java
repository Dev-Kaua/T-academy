package ex2_GestaoDeEstoque;

import java.util.HashMap;

public class Estoque {
    private HashMap<String, Produto> produtos = new HashMap<>();

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getNome(), produto);
    }

    public Produto buscarProduto(String nome) {
        return produtos.get(nome);
    }

    public void listarProdutos() {
        System.out.println("Lista de produtos no estoque:");
        for (Produto p : produtos.values()) {
            System.out.println(p.getNome() + " - Quantidade: " + p.getQuantidade() + " - Preço: " + p.getPreco()+"\n");
        }
    }

    public void adicionarEstoqueProduto(String nome, int quantidade) {
        Produto produto = buscarProduto(nome);
        if (produto != null) {
            produto.adicionarEstoque(quantidade);
            produto.registrarMovimentacao("Entrada", quantidade, produto.getPreco());
        } else {
            System.out.println("Produto " + nome + " não encontrado no estoque.");
        }
    }

    public void adicionarEstoqueProduto(String nome, int quantidade, double desconto) {
        Produto produto = buscarProduto(nome);
        if (produto != null) {
            produto.adicionarEstoque(quantidade, desconto);
            produto.registrarMovimentacao("Entrada com desconto", quantidade, produto.getPreco());
        } else {
            System.out.println("Produto " + nome + " não encontrado no estoque.");
        }
    }

    public void venderProduto(String nome, int quantidadeVenda) {
        Produto produto = buscarProduto(nome);
        if (produto != null) {
            double valorVenda = produto.venderProduto(quantidadeVenda);
            if (valorVenda > 0) {
                produto.registrarMovimentacao("Venda", quantidadeVenda, produto.getPreco());
            }
        } else {
            System.out.println("Produto " + nome + " não encontrado no estoque.");
        }
    }
}
