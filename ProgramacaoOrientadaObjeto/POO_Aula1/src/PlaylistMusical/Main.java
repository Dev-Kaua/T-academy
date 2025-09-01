package PlaylistMusical;

public class Main {
    public static void main(String[] args) {
        PlaylistMusical playlist = new PlaylistMusical("As musicas que eu escuto" +
                " na segunda feira chuvosa do dia 01/09/2025");

        playlist.adicionarMusica("Bohemian Rhapsody - Queen");
        playlist.adicionarMusica("Smells Like Teen Spirit - Nirvana");
        playlist.adicionarMusica("I'd rather pretend - Bryant Barnes");
        playlist.adicionarMusica("Suicidal (feat. Juice WRLD) - Juice WRLD, YNW Melly");
        playlist.adicionarMusica("Don't go away - Oasis");

        System.out.println("\n--- Tocando playlist ---");
        for (int i = 0; i < 6; i++) { // tentei 6 pra mostrar o fim da playlist
            playlist.tocarProxima();
            playlist.mostrarMusicaAtual();
        }
    }
}
