import java.util.Scanner;

public class ScannerProfessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome?");
        String nome = scanner.nextLine();

        System.out.println("onde mora?");
        String cidade = scanner.nextLine();

        System.out.println("qual sua idade?");
        int idade = scanner.nextInt();

        System.out.println("Seu nome é " + nome);
    }
}