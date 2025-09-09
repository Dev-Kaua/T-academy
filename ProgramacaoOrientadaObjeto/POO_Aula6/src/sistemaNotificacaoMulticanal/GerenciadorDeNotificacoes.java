package sistemaNotificacaoMulticanal;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeNotificacoes {
    private final List<Notificador> notificadores = new ArrayList<>();

    public void registrar(Notificador notificador){
        notificadores.add(notificador);
    }

    public void notificarTodosOsDispositivos(String mensagem){
        for (Notificador notificador : notificadores){
            notificador.enviarMensagem(mensagem);
        }
    }
}
