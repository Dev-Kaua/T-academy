package SistemaStreamingMidia.Midias;

public class Musica extends Midia {
    public Musica(String titulo, Genero genero, int duracao) {
        super(titulo, genero, duracao);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Música: " + getTitulo() + " | Gênero: " + getGenero() +
                " | Tempo de música: " + getDuracao()+ " minutos");
    }
}