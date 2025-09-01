package Lampada;

public class Main {
    public static void main(String[] args) {
        Lampada lampada = new Lampada();

        lampada.mostrarStatus();

        lampada.trocarCor("Amarelo"); // não vai funcionar
        lampada.ligar();
        lampada.trocarCor("Amarelo"); // agora vai
        lampada.mostrarStatus();

        lampada.desligar();
        lampada.mostrarStatus();
    }
}
