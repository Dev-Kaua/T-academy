import java.util.Scanner;

public class NumeroPNZ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira um número: ");
        int numero = scanner.nextInt();

        System.out.println(numero > 0 ? "positivo" : numero == 0 ? "É igual a zero" : "Negativo");
    }
}
