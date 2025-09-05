package exercicio1;

import exercicio1.veiculos.Aviao;
import exercicio1.veiculos.Carro;

import static exercicio1.enums.CompanhiaAerea.AMERICAN_AIRLINES;
import static exercicio1.enums.Marca.AIRBUS;
import static exercicio1.enums.Marca.BMW;
import static exercicio1.enums.Modelo.SERIE_3;

public class Main {
    public static void main(String[] args) {
        Aviao airbus = new Aviao(AIRBUS, 2020, AMERICAN_AIRLINES);
        Carro bmw320i = new Carro(BMW, 2023, SERIE_3);

        System.out.println(airbus.detalhes());
        System.out.println(bmw320i.detalhes());
    }
}
