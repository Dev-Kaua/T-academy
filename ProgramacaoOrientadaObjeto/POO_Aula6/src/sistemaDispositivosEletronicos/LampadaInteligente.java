package sistemaDispositivosEletronicos;

public class LampadaInteligente implements Ligavel,Configuravel{
    private boolean ligada = false;
    private String configuracao = "Branco";

    @Override
    public String configurar(String parametro) {
        if (!ligada) {
            System.out.println("A lâmpada precisa estar ligada para configurar.");
            return null;
        }

        if (parametro.equalsIgnoreCase("azul") ||
                parametro.equalsIgnoreCase("vermelho") ||
                parametro.equalsIgnoreCase("branco")) {

            this.configuracao = parametro;
            System.out.println("Lâmpada configurada para cor: " + parametro);
            return configuracao;
        } else {
            System.out.println("Configuração inválida! Escolha entre: azul, vermelho ou branco.");
            return null;
        }
    }

    @Override
    public void ligar() {
        if (!ligada) {
            ligada = true;
            System.out.println("A lâmpada foi ligada.");
        } else {
            System.out.println("A lâmpada já estava ligada.");
        }
    }

    @Override
    public void desligar() {
        if (ligada) {
            ligada = false;
            System.out.println("A lâmpada foi desligada.");
        } else {
            System.out.println("A lâmpada já estava desligada.");
        }
    }
}
