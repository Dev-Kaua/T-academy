package SistemaStreamingMidia.Midias;

public class Documentario extends Midia {

    public Documentario(String titulo, Genero genero, int duracao) {
        super(titulo, genero, duracao);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Documentário: " + getTitulo() + " | Gênero: " + getGenero() +
                " | Duração: " + getDuracao() + " minutos");
    }
}
