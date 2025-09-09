package sistemaNotificacaoMulticanal;

public class Sms implements Notificador{

    private String numero;

    public Sms(String numero, GerenciadorDeNotificacoes gerenciador) {
        this.numero = numero;
        gerenciador.registrar(this);
    }


    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando SMS para " + numero + ": " + mensagem);
        System.out.println("SMS enviado com sucesso!");
    }
}
