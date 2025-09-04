package SistemaStreamingMidia.Funcionalidades;

import SistemaStreamingMidia.Midias.Midia;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String nome;
    private List<Midia> midias;

    public Playlist(String nome) {
        this.nome = nome;
        this.midias = new ArrayList<>();
    }

    public void adicionarMidia(Midia midia){
        midias.add(midia);
    }

    public void mostrarPlaylist(){
        System.out.println("Playlist: "+ nome);
        for (Midia midia : midias){
            System.out.println("--> "+ midia.getTitulo());
        }
    }
}
