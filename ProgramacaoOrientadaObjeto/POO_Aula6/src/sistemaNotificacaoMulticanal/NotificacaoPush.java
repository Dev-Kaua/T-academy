package sistemaNotificacaoMulticanal;

public class NotificacaoPush implements Notificador{

    private String dispositivoDeDestino;

    public NotificacaoPush(String dispositivoDeDestino, GerenciadorDeNotificacoes gerenciador) {
        this.dispositivoDeDestino = dispositivoDeDestino;
        gerenciador.registrar(this);
    }


    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando notificação push para " + dispositivoDeDestino + ": " + mensagem);
        System.out.println("Push enviado com sucesso!");
    }
}
