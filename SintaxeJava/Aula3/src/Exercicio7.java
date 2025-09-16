import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maior;
        System.out.println("Informe o 1° número: ");
        maior = scanner.nextInt();

        for(int i=0; i<4; i++){
            System.out.println("Informe o "+ (i+2) + "° número: ");
            int numero = scanner.nextInt();

            if(numero > maior){
                maior = numero;
            }
        }

        System.out.println("O maior número foi o "+ maior);

    }
}
