package sistemaDispositivosEletronicos;

public class Main {
    public static void main(String[] args) {
        Televisao tv1 = new Televisao();
        Smartphone s23 = new Smartphone();
        LampadaInteligente lamadaAlexa = new LampadaInteligente();

        System.out.println("=== Testando Lâmpada ===");
        lamadaAlexa.configurar("Azul"); //tem que falhar
        lamadaAlexa.ligar();
        lamadaAlexa.configurar("Azul");
        lamadaAlexa.configurar("Verde");
        lamadaAlexa.desligar();

        System.out.println("\n=== Testando Televisão ===");
        tv1.conectar(); //tv desligada, entao tem que falhar
        tv1.ligar();
        tv1.conectar();
        tv1.desligar();

        System.out.println("\n=== Testando Smartphone ===");
        s23.conectar(); //vai falhar
        s23.ligar();
        s23.conectar();
        s23.configurar("Modo avião");
        s23.desligar();

        System.out.println("\n=== Testando Polimorfismo (Ligavel) ===");
        Ligavel[] dispositivos = {s23, tv1, lamadaAlexa};

        for (Ligavel ligavel : dispositivos){
            ligavel.ligar();
            ligavel.desligar();
        }
    }
}
