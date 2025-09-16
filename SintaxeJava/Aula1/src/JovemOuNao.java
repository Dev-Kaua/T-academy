import java.util.Scanner;

public class JovemOuNao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual a sua idade? ");
        int idade = scanner.nextInt();

        System.out.println(idade < 30 ? "Jovem" : idade >= 65 ? "Não jovem" : "Adulto");
    }
}
