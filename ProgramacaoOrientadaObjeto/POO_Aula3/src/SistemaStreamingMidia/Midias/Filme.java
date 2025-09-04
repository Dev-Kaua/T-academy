package SistemaStreamingMidia.Midias;

public class Filme extends Midia {

    public Filme(String titulo, Genero genero, int duracao) {
        super(titulo, genero, duracao);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Filme atual: " + getTitulo() + " | Gênero: " + getGenero() +
                " | Duração: " + getDuracao() + " minutos");
    }
}