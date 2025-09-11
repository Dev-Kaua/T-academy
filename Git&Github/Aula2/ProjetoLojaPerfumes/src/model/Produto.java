package model;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private ClassificacaoPerfume classificacaoPerfume;
    private double preco;
    private int quantidadeEstoque;

    private static int contador = 0;

    public Produto(String nome, String descricao, ClassificacaoPerfume classificacaoPerfume, double preco) {
        this.id = contador++;
        this.nome = nome;
        this.descricao = descricao;
        this.classificacaoPerfume = classificacaoPerfume;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ClassificacaoPerfume getClassificacaoPerfume() {
        return classificacaoPerfume;
    }

    public void setClassificacaoPerfume(ClassificacaoPerfume classificacaoPerfume) {
        this.classificacaoPerfume = classificacaoPerfume;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d%n" +
                        "Nome: %s%n" +
                        "Descrição: %s%n" +
                        "Classificação: %s%n" +
                        "Preço: R$ %.2f%n" +
                        "Quantidade em estoque: %d%n",
                id,
                nome,
                descricao,
                classificacaoPerfume,
                preco,
                quantidadeEstoque
        );
    }
}
