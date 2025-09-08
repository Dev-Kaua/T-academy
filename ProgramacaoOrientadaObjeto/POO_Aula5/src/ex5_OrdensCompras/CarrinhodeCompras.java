package ex5_OrdensCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhodeCompras {
    private List<Calculavel> itens = new ArrayList<>();
    private Desconto desconto; // Campo para armazenar o desconto

    public void adicionarItem(Calculavel item) {
        itens.add(item);
    }

    public void aplicarDesconto(Desconto desconto) {
        this.desconto = desconto;
    }

    public double calcularTotal() {
        double total = 0;
        for (Calculavel item : itens) {
            total += item.calcularPreco();
        }
        if (desconto != null) {
            total = desconto.aplicarDesconto(total);
        }
        return total;
    }

    public void imprimirResumo() {
        for (Calculavel item : itens) {
            if (item instanceof Item) {
                Item i = (Item) item;
                System.out.printf("Item: %s | Preço: R$%.2f%n", i.nome, i.calcularPreco());
            }
        }

        System.out.printf("Total: R$%.2f%n", calcularTotal());
    }
}
