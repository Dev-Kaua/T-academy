package SistemaStreamingMidia.Midias;

import SistemaStreamingMidia.Funcionalidades.Avaliacao;

import java.util.ArrayList;
import java.util.List;

public abstract class Midia {
    public String titulo;
    public Genero genero;
    public int duracao;
    public List<Avaliacao> avaliacoes;

    public Midia(String titulo, Genero genero, int duracao) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.avaliacoes = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public abstract void mostrarDetalhes();

    public void adicionarAvaliacao (int estrelas, boolean like, String comentario) {
        Avaliacao avaliacao = new Avaliacao(estrelas, like, comentario);
        avaliacoes.add(avaliacao);
    }

    public void mostrarAvaliacoes(){
        for(Avaliacao avaliacao : avaliacoes){
            System.out.println("Estrelas: "+ avaliacao.getEstrelas()+ " | Like: "+
                    (avaliacao.isLike() ? "Sim" : "Não" + " | Comentário: " + avaliacao.getComentario()));
        }
    }
}