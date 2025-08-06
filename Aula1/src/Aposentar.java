import java.util.Scanner;

public class Aposentar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual a sua idade? ");
        int idade = scanner.nextInt();

        System.out.println(idade >= 65 ? "Pode se aposentar!" : "Não pode se aposentar...");
    }
}
