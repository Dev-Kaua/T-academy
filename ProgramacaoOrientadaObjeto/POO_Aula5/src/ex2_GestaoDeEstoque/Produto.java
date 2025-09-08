package ex2_GestaoDeEstoque;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Produto {
    private String nome;
    private int quantidade;
    private double preco;
    private ArrayList<String> historicoMovimentacoes = new ArrayList<>();

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void adicionarEstoque(int quantidade){
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida! Deve ser maior que zero.");
            return;
        }
        this.quantidade += quantidade;
        System.out.println("Produto - "+ nome +"\nQuantidade adicionada: " +
                this.quantidade+ "\nQuantidade total atual: "+ quantidade);
    }

    public void adicionarEstoque(int quantidade, double valorDesconto){
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida! Deve ser maior que zero.");
            return;
        }
        if (valorDesconto < 0 || valorDesconto >= preco) {
            System.out.println("Desconto inválido! Deve ser maior que zero e menor que o preço do produto.");
            return;
        }
        this.quantidade += quantidade;
        this.preco -= valorDesconto;

        System.out.println("Produto - "+ nome +"\nQuantidade adicionada: " +
                this.quantidade+ "\nQuantidade total atual: "+ quantidade);
        System.out.println("Desconto unitário adicionado: R$"+ valorDesconto+
                "\nNovo preço unitário após o desconto: R$ " + preco);
    }

    public double venderProduto(int quantidadeVenda) {
        if (quantidadeVenda <= 0) {
            System.out.println("Quantidade inválida para venda");
            return 0;
        }
        if (quantidadeVenda > quantidade) {
            System.out.println("Estoque da lojinha insuficiente para a venda :(");
            return 0;
        }
        quantidade -= quantidadeVenda;
        double valorTotal = quantidadeVenda * preco;
        System.out.println("Venda realizada: " + quantidadeVenda + " unidades de " + nome + " por R$ " + valorTotal);
        return valorTotal;
    }

    public void registrarMovimentacao(String nomeProdutoMovimentacao, int quantidadeDaAcao, double precoUnitario){
        String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String registro = data + " - " + nomeProdutoMovimentacao + ": " + quantidadeDaAcao +
                " unidades a R$ " + precoUnitario;
        historicoMovimentacoes.add(registro);
    }

    public void mostrarHistorico(){
        System.out.println("Histórico de movimentações do produto "+ nome + ": ");
        for (String registro: historicoMovimentacoes){
            System.out.println(registro);
        }
    }
}
