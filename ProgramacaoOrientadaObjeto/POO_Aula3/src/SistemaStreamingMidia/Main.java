package SistemaStreamingMidia;

import SistemaStreamingMidia.Funcionalidades.Estatistica;
import SistemaStreamingMidia.Funcionalidades.HistoricoVizualizacoes;
import SistemaStreamingMidia.Funcionalidades.Playlist;
import SistemaStreamingMidia.Funcionalidades.Recomendacao;
import SistemaStreamingMidia.Midias.*;
import SistemaStreamingMidia.Usuario.Usuario;
import SistemaStreamingMidia.Usuario.UsuarioGratis;
import SistemaStreamingMidia.Usuario.UsuarioPremium;

public class Main {
    public static void main(String[] args) {

        Usuario usuario1 = new UsuarioPremium("João Java", "Joaojava@Gmail.com", Genero.ROMANCE);
        Usuario usuario2 = new UsuarioGratis("MariaDB", "MariaDB@hotmail.com", Genero.ACAO);

        Midia filme = new Filme("Vingadores Ultimato", Genero.ACAO, 120);
        Midia serie = new Serie("The Last Of Us", Genero.SUSPENSE, 61, 13);
        Midia musica = new Musica("Somewhere Only We Know", Genero.ROMANCE, 9);

        Estatistica estatisticas = new Estatistica();

        HistoricoVizualizacoes historico1 = new HistoricoVizualizacoes();
        HistoricoVizualizacoes historico2 = new HistoricoVizualizacoes();

        // Playlists
        Playlist playlistJoao = new Playlist("Favoritos do João");
        Playlist playlistMaria = new Playlist("Favoritos da Maria");

        // Recomendação
        Recomendacao recomendacao = new Recomendacao();

        // Usuário 1 assistindo filme e série
        usuario1.assistirMidia(filme);
        historico1.adicionarMidia(filme);  // Adicionando ao histórico de João
        usuario1.assistirMidia(serie);
        historico1.adicionarMidia(serie); // Adicionando ao histórico de João

        // Adicionando conteúdos às playlists
        playlistJoao.adicionarMidia(filme);
        playlistJoao.adicionarMidia(serie);

        // Exibindo as estatísticas de João
        estatisticas.mostrarEstatisticas(usuario1);

        // Adicionando avaliações para o filme e série
        filme.adicionarAvaliacao(5, true, "Excelente filme!");
        serie.adicionarAvaliacao(4, true, "Muito boa, mas o ritmo poderia ser melhor.");

        // Mostrando as avaliações
        filme.mostrarAvaliacoes();
        serie.mostrarAvaliacoes();

        // Recomendações para João (baseado em gênero)
        System.out.println("\nRecomendações para " + usuario1.getNome() + ":");
        recomendacao.recomendarConteudo(usuario1, java.util.Arrays.asList(filme, serie, musica));

        // Usuário 2 tenta assistir música (mas sem assinatura)
        try {
            usuario2.assistirMidia(musica); // Deve gerar erro porque MariaDB não tem assinatura
        } catch (Exception e) {
            System.out.println(e.getMessage());  // Mensagem de erro para assinatura não ativa
        }

        // Ativando assinatura para MariaDB
        usuario2.AssinarPlano();

        // Usuário 2 assistindo música agora que tem assinatura
        usuario2.assistirMidia(musica);
        historico2.adicionarMidia(musica);  // Adicionando ao histórico de MariaDB

        // Exibindo as estatísticas de João e MariaDB
        estatisticas.mostrarEstatisticas(usuario1);
        estatisticas.mostrarEstatisticas(usuario2);

        // Exibindo histórico de visualização
        System.out.println("\nHistórico de visualização de " + usuario1.getNome() + ":");
        historico1.mostrarHistorico();

        System.out.println("\nHistórico de visualização de " + usuario2.getNome() + ":");
        historico2.mostrarHistorico();

        // Exibindo as playlists
        System.out.println("\nPlaylists de " + usuario1.getNome() + ":");
        playlistJoao.mostrarPlaylist();

        System.out.println("\nPlaylists de " + usuario2.getNome() + ":");
        playlistMaria.mostrarPlaylist();
    }
}