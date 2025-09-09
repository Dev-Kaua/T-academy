package sistemaDePagamento;

public class PayPal implements MetodoPagamento{

    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PayPal para " + email + "...");
        System.out.println("Pagamento via PayPal concluído com sucesso!");
    }
}
