package sistemaNotificacaoMulticanal;

public class Main {
    public static void main(String[] args) {

        GerenciadorDeNotificacoes gerenciadorDeNotificacoes = new GerenciadorDeNotificacoes();

        new Email("JoaoJava@Gmail.com", gerenciadorDeNotificacoes);
        new Sms("4799938-2939", gerenciadorDeNotificacoes);
        new NotificacaoPush("Celular do Joao Java", gerenciadorDeNotificacoes);

        System.out.println("=== Enviando notificações ===");
        gerenciadorDeNotificacoes.notificarTodosOsDispositivos("Sistema atualizado " +
                "para a versao 21 do Java com sucesso!");
    }
}
