package SistemaStreamingMidia.Midias;

public class Serie extends Midia {
    public int numeroEpisodios;

    public Serie(String titulo, Genero genero, int duracao, int numeroEpisodios) {
        super(titulo, genero, duracao);
        this.numeroEpisodios = numeroEpisodios;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Série: "+ getTitulo() + " | Gênero: "+ getGenero() +
                " | Duração do episódio: "+ getDuracao() + " minutos "+ " | Número de episódios: "+ numeroEpisodios);
    }
}
