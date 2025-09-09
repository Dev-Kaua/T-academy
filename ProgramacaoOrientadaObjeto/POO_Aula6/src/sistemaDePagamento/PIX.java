package sistemaDePagamento;

public class PIX implements MetodoPagamento{

    private String chavePix;

    public PIX(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PIX com chave " + chavePix + "...");
        System.out.println("Pagamento via PIX realizado com sucesso!");
    }
}
