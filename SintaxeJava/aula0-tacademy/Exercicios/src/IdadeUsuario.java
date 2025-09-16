import java.util.Scanner;

public class IdadeUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anoAtual = 2025;
        System.out.print("Qual o ano de nascimento? ");
        int nascimento = scanner.nextInt();

        int idade = anoAtual - nascimento;
        System.out.println("A idade do usuário é " + idade + " anos");
    }
}
