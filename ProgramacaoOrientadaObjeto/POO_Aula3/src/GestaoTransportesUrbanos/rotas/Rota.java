package GestaoTransportesUrbanos.rotas;

import GestaoTransportesUrbanos.transportes.Transporte;

import java.util.ArrayList;
import java.util.List;

public class Rota {
    private String origem;
    private String destino;
    private List<Transporte> transportes;

    public Rota(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        this.transportes = new ArrayList<>();
    }

    public void adicionarTransporte(Transporte tram){
        transportes.add(tram);
    }

    public double calcularCustoTotal(){
        return transportes.stream().mapToDouble(Transporte::getCustoMedio).sum();
    }

    public double calcularTempoTotal(){
        return transportes.stream().mapToDouble(Transporte::getTempoMedio).sum();
    }

    public void exibirRota(){
        System.out.println("Rota de "+ origem + " até "+ destino);
        transportes.forEach(t -> System.out.println(" -> " + t.getNome() +
                " (R$" + t.getCustoMedio() + ", " + t.getTempoMedio() + " min)"));
        System.out.println("Custo total: R$ " + calcularCustoTotal());
        System.out.println("Tempo total: " + calcularTempoTotal() + " min");
    }
}
