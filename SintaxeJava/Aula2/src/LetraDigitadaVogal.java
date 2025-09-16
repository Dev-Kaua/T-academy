import java.util.Scanner;

public class LetraDigitadaVogal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira uma letra: ");
        String letra = scanner.next().toLowerCase();

        System.out.println(letra.equals("a") || letra.equals("e") || letra.equals("i") ||
                letra.equals("o") || letra.equals("u") ? "é uma vogal!" : "não é vogal");
    }
}
