package sistemaDePagamento;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MetodoPagamento cartao = new CartaoCredito("1111-2222-3333-4444");
        MetodoPagamento paypal = new PayPal("PedroPascal@outlook.com");
        MetodoPagamento pix = new PIX("18392012394");

        List<MetodoPagamento> pagamentos = new ArrayList<>();
        pagamentos.add(cartao);
        pagamentos.add(paypal);
        pagamentos.add(pix);

        System.out.println("=== Processando pagamentos ===");
        for (MetodoPagamento metodo : pagamentos) {
            metodo.processarPagamento(258.75);
            System.out.println("------------------------");
        }
    }
}
