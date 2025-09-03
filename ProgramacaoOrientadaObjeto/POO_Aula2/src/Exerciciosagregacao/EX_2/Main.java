package Exerciciosagregacao.EX_2;

public class Main {
    public static void main(String[] args) {
        Motor motor1_6 = new Motor(1600, 120, 16);
        Carro carro = new Carro("Marea",Marca.FIAT, motor1_6);

        System.out.println(carro);
    }
}
