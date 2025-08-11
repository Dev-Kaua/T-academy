import java.util.Scanner;

public class Exe01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira quantos animais você quer cadastrar: ");
        int quantidade = scanner.nextInt();

        String[] animais = new String[quantidade];

        for (int i = 0; i < animais.length; i++) {
            System.out.println("Nome do animal: ");
            animais[i] = scanner.nextLine();
        }

        for (int i = 0; i < animais.length; i++) {
            System.out.println(i + " - "+ animais[i]);
        }
    }
}
