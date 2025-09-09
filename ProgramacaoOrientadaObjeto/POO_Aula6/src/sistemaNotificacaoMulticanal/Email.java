package sistemaNotificacaoMulticanal;

public class Email implements Notificador{
    private String emailDeDestino;

    public Email(String emailDeDestino, GerenciadorDeNotificacoes gerenciador) {
        this.emailDeDestino = emailDeDestino;
        gerenciador.registrar(this);
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando e-mail para " + emailDeDestino + ": " + mensagem);
        System.out.println("E-mail enviado com sucesso!");
    }
}
