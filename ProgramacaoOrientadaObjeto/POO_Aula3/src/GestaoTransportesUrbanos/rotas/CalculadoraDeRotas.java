package GestaoTransportesUrbanos.rotas;

import GestaoTransportesUrbanos.transportes.Bicicleta;
import GestaoTransportesUrbanos.transportes.Metro;
import GestaoTransportesUrbanos.transportes.Onibus;

public class CalculadoraDeRotas {
    public Rota calcularRotaSimples(String origem, String destino){
        Rota rota = new Rota(origem, destino);

        Onibus onibus = new Onibus(1, "Onibus centro", 40);
        Metro metro = new Metro(2, "Metro do max verstapen", 200);
        Bicicleta bike = new Bicicleta(3, "Bike Compartilhada dos Javeiros", 1);

        rota.adicionarTransporte(onibus);
        rota.adicionarTransporte(metro);
        rota.adicionarTransporte(bike);

        return rota;
    }
}

