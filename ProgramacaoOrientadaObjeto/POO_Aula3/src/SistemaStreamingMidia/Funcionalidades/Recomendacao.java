package SistemaStreamingMidia.Funcionalidades;

import SistemaStreamingMidia.Midias.Midia;
import SistemaStreamingMidia.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Recomendacao {
    public List<Midia> recomendarConteudo (Usuario usuario, List<Midia> catalogo){
        List<Midia> recomendados = new ArrayList<>();
        for (Midia midia : catalogo){
            if(usuario.getGeneroFavorito() == midia.getGenero()){
                recomendados.add(midia);
            }
        }
        return recomendados;
    }
}
