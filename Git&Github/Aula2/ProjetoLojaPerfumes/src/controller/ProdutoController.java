package controller;

import model.ClassificacaoPerfume;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtoList = new ArrayList<>();

    public Produto criarProduto(String nome, String descricao, ClassificacaoPerfume classificacaoPerfume,
                                double preco){
        Produto produto = new Produto(nome, descricao, classificacaoPerfume, preco);

        System.out.println("Novo produto "+ produto.getNome() +" criado com sucesso! ");
        produtoList.add(produto);
        return produto;
    }

    public List<Produto> listarProdutos() {
        return produtoList;
    }

    public Produto buscarPorId(int id) {
        return produtoList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean removerProduto(int id) {
        return produtoList.removeIf(p -> p.getId() == id);
    }
}
