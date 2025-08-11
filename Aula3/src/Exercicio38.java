import java.util.Scanner;

public class Exercicio38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anoInicial = 1995;
        int anoAtual = 2025;
        double salarioAnterior = 1000;
        double salarioFinal = 0;
        double percentualAumento = 0.015;

        while(anoAtual > anoInicial){
            salarioFinal = salarioAnterior + (salarioAnterior * percentualAumento);
            salarioAnterior = salarioFinal;
            percentualAumento *= 2;
            anoInicial++;
        }

        System.out.println(salarioFinal);

    }
}
