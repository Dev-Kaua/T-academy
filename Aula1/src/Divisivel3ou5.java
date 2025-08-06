import java.util.Scanner;

public class Divisivel3ou5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o seu número: ");
        int numero = scanner.nextInt();

        System.out.println((numero % 3) == 0 ? "É divisível por 3! "
                : (numero % 5) == 0 ? "É divisível por 5! "
                : "Não é divisível nem por 5 e nem por 3");
    }
}
