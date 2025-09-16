import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira até qual série n de Fibonacci você quer que o " +
                "programa execute: ");
        int n = scanner.nextInt();
        int termoAnteriorDoAnterior = 0;
        int termoAnterior = 1;
        int saveTermoAnterior = 0;

        System.out.println("1,");

        for(int i=0; i<n; i++){
            saveTermoAnterior = termoAnterior;
            System.out.println((termoAnteriorDoAnterior+termoAnterior) + ",");
            termoAnterior = termoAnteriorDoAnterior + termoAnterior;
            termoAnteriorDoAnterior = saveTermoAnterior;

        }

        System.out.println(n + " impressões da sequência de Fibonacci finalizada! ");
    }
}
