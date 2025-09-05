package exercicio1.veiculos;

import exercicio1.enums.Marca;

public abstract class Veiculo {
    private Marca marca;
    private int ano;

    public Veiculo(Marca marca, int ano) {
        this.marca = marca;
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public String detalhes(){
        return "Marca: " + marca + " | Ano: " + ano;
    }
}
