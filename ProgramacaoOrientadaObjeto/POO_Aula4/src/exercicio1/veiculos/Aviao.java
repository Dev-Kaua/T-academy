package exercicio1.veiculos;

import exercicio1.enums.CompanhiaAerea;
import exercicio1.enums.Marca;

public class Aviao extends Veiculo {
    private CompanhiaAerea companhiaAerea;

    public Aviao(Marca marca, int ano, CompanhiaAerea companhiaAerea) {
        super(marca, ano);
        this.companhiaAerea = companhiaAerea;
    }

    public CompanhiaAerea getCompanhiaAerea() {
        return companhiaAerea;
    }

    @Override
    public String detalhes() {
        return super.detalhes() + " | Companhia Aérea: "+ companhiaAerea;
    }
}
