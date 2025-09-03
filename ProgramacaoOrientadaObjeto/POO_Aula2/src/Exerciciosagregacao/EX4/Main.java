package Exerciciosagregacao.EX4;

import static Exerciciosagregacao.EX4.Marca.AMD;

public class Main {
    public static void main(String[] args) {
        Processador Ryzen9_7900 = new Processador("Ryzen 9 7900", 13600, AMD);
        Computador Pc_Kaua = new Computador("PC Do Kauã", Ryzen9_7900);

        System.out.println(Pc_Kaua);
    }
}
