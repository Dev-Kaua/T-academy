import java.util.Scanner;

public class ImparOuPar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira um número: ");
        int numero = scanner.nextInt();

        System.out.println((numero % 2) > 0 ? "Impar" : "Par" );
    }
}
