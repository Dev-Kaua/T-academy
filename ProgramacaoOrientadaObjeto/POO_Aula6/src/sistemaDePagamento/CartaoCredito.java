package sistemaDePagamento;

public class CartaoCredito implements MetodoPagamento{
    private String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " no cartão de crédito " + numeroCartao + "...");
        System.out.println("Pagamento via cartão aprovado com sucesso!");
    }
}
