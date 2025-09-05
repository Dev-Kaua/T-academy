package exercicio1.veiculos;

import exercicio1.enums.Marca;
import exercicio1.enums.Modelo;

public class Carro extends Veiculo {
    private Modelo modelo;

    public Carro(Marca marca, int ano, Modelo modelo) {
        super(marca, ano);
        this.modelo = modelo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    @Override
    public String detalhes() {
        return super.detalhes() + " | Modelo do carro: " + modelo;
    }
}
