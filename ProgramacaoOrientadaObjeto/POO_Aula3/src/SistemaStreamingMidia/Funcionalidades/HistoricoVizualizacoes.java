package SistemaStreamingMidia.Funcionalidades;

import SistemaStreamingMidia.Midias.Midia;

import java.util.ArrayList;
import java.util.List;

public class HistoricoVizualizacoes {
    private List<Midia> historico;

    public HistoricoVizualizacoes() {
        this.historico = new ArrayList<>();
    }

    public void adicionarMidia(Midia midia){
        historico.add(midia);
    }

    public void mostrarHistorico(){
        System.out.println("Histórico de vizualizações: ");
        for (Midia midia : historico){
            System.out.println("--> "+ midia.getTitulo());
        }
    }
}
