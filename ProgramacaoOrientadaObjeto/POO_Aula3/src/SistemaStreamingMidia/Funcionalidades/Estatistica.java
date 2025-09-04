package SistemaStreamingMidia.Funcionalidades;

import SistemaStreamingMidia.Usuario.Usuario;

public class Estatistica {
    public void mostrarEstatisticas(Usuario usuario) {
        System.out.println("Estatísticas de uso para " + usuario.getNome() + ":");
        System.out.println("Tempo assistido: " + usuario.getTempoAssistido() + " minutos");
    }
}
