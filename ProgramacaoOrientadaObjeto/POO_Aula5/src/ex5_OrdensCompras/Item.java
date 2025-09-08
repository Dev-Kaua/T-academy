package ex5_OrdensCompras;

public abstract class Item implements Calculavel{
    protected static int proximoId = 1;
    protected int id;
    protected String nome;
    protected double preco;
    protected Categoria categoria;

    public Item( String nome, double preco) {
        this.id = proximoId++;
        this.nome = nome;
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public abstract double calcularPreco();

}
