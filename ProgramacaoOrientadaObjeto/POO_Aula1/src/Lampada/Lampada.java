package Lampada;

public class Lampada {
    public boolean ligada;
    public String cor;

    public Lampada() {
        this.ligada = false;
        this.cor = "branco";
    }

    public void ligar() {
        ligada = true;
        System.out.println("A lâmpada foi ligada e agora a selesc ta de olho");
    }

    public void desligar() {
        ligada = false;
        System.out.println("A lâmpada foi desligada. selesc parou de olhar");
    }

    public void trocarCor(String novaCor) {
        if (ligada) {
            cor = novaCor;
            System.out.println("A cor da lâmpada agora é: " + cor);
        } else {
            System.out.println("Não tem como trocar a cor da lampada com ela desligada. ");
        }
    }

    public void mostrarStatus() {
        String statusLampada = ligada ? "Ligada" : "Desligada";
        System.out.println("Status da lampada: " + statusLampada +
                " | Cor do momento: " + cor);
    }
}
