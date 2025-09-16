import java.util.Scanner;

public class AlunoAprovado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual foi sua nota/média? ");
        int nota = scanner.nextInt();

        System.out.println(nota >= 60 ? "Aprovado!" : "Reprovado :( ");
    }
}
