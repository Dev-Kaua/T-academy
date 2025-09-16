import java.util.Scanner;

public class FormulaBhaskara {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o valor de X²: ");
        double a = scanner.nextDouble();

        System.out.print("Insira o valor de X: ");
        double b = scanner.nextDouble();

        System.out.print("Insira o valor de c (que não é variável): ");
        double c = scanner.nextDouble();

        double delta = (b * b) - (4 * a * c);
        double primeiroX = ((-b) + Math.sqrt(delta)) / (2 * a);
        double segundoX = ((-b) - Math.sqrt(delta)) / (2 * a);

        System.out.println("Seus resultados são: \nX1 = " + primeiroX + "\nX2 = " + segundoX);
    }
}
