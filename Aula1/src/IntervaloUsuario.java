import java.util.Scanner;

public class IntervaloUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira um intervalo," +
                " falando primeiro o numero menor e depois o número maior: ");
        int menor = scanner.nextInt();
        int maior = scanner.nextInt();

        System.out.println("Agora, insira um número: ");
        int numero = scanner.nextInt();

        System.out.println((menor <= numero) && (maior >= numero) ?
                "O número está dentro do escopo! " : "o número não está no escopo...");
    }
}
