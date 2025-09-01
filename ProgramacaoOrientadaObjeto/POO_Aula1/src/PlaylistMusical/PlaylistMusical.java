package PlaylistMusical;

import java.util.ArrayList;
import java.util.List;

public class PlaylistMusical {

    public String nome;
    public List<String> musicas;
    public int musicaAtual;

    public PlaylistMusical(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
        this.musicaAtual = -1;
    }

    public void adicionarMusica(String musica) {
        musicas.add(musica);
        System.out.println("uma música foi adicionada: " + musica);
    }

    public void tocarProxima() {
        if (musicas.isEmpty()) {
            System.out.println("A playlist está vazia!");
            return;
        }

        musicaAtual++;
        if (musicaAtual >= musicas.size()) {
            System.out.println("Fim da playlist!");
            musicaAtual = -1;
            return;
        }

        System.out.println("a musica que está tocando agora é: " + musicas.get(musicaAtual));
    }

    public void mostrarMusicaAtual() {
        if (musicaAtual == -1 || musicas.isEmpty()) {
            System.out.println("Nenhuma música está tocando.");
        } else {
            System.out.println("a música que está tocando agora é: " + musicas.get(musicaAtual));
        }
    }
}
