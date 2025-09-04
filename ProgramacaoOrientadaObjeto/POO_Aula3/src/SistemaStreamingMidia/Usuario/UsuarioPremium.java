package SistemaStreamingMidia.Usuario;


import SistemaStreamingMidia.Midias.Genero;
import SistemaStreamingMidia.Midias.Midia;

public class UsuarioPremium extends Usuario {

    public UsuarioPremium(String nome, String email, Genero generoFavorito) {
        super(nome, email, generoFavorito);
    }

    @Override
    public void assistirMidia(Midia midia) {
        System.out.println(nome + " está assistindo: " + midia.getTitulo());
        tempoAssistido += midia.getDuracao();
    }
}