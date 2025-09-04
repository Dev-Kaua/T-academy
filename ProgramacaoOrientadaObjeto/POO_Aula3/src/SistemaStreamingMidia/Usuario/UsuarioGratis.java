package SistemaStreamingMidia.Usuario;

import SistemaStreamingMidia.Midias.Genero;
import SistemaStreamingMidia.Midias.Midia;

public class UsuarioGratis extends Usuario {

    public UsuarioGratis(String nome, String email, Genero generoFavorito) {
        super(nome, email, generoFavorito);
    }

    @Override
    public void assistirMidia(Midia midia) {
        if (assinaturaAtiva) {
            System.out.println("O usuário -> " + nome + " <- está assistindo: " + midia.getTitulo());
            tempoAssistido += midia.getDuracao();
        } else {
            System.out.println(nome + " precisa de uma assinatura ativa para assistir.");
        }
    }
}