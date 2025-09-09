package sistemaDispositivosEletronicos;

public class Smartphone implements Ligavel,Conectavel,Configuravel{

    private boolean ligado = false;
    private boolean conectado = false;
    private String configuracao;


    @Override
    public void conectar() {
        if (ligado) {
            if (!conectado) {
                conectado = true;
                System.out.println("Conectando ao smartphone... Conectado com sucesso!");
            } else {
                System.out.println("O smartphone já está conectado");
            }
        } else {
            System.out.println("Não é possível conectar a um smartphone que está desligado!");
        }
    }

    @Override
    public String configurar(String parametro) {
        if (ligado) {
            this.configuracao = parametro;
            System.out.println("Smartphone com configuração aplicada: " + parametro);
            return configuracao;
        } else {
            System.out.println("Não é possível configurar enquanto o dispositivo está desligado!");
            return null;
        }
    }

    @Override
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Smartphone ligado!");
        } else {
            System.out.println("O smartphone já está ligado.");
        }
    }

    @Override
    public void desligar() {
        if (ligado) {
            ligado = false;
            conectado = false;
            System.out.println("O smartphone foi desligado");
        } else {
            System.out.println("O smarphone já estava desligado.");
        }
    }
}
