package sistemaDispositivosEletronicos;

public class Televisao implements Ligavel,Conectavel{
    private boolean ligada = false;
    private boolean conectada = false;

    @Override
    public void conectar() {
        if (ligada) {
            if (!conectada) {
                conectada = true;
                System.out.println("Conectando a TV... Conectado com sucesso!");
            } else {
                System.out.println("A TV já está conectada.");
            }
        } else {
            System.out.println("Não é possível conectar uma TV desligada!");
        }
    }

    @Override
    public void ligar() {
        if (!ligada) {
            ligada = true;
            System.out.println("A televisão está ligada.");
        } else {
            System.out.println("A televisão já estava ligada.");
        }
    }

    @Override
    public void desligar() {
        if (ligada) {
            ligada = false;
            conectada = false;
            System.out.println("A televisão foi desligada.");
        } else {
            System.out.println("A televisão já estava desligada.");
        }
    }
}
