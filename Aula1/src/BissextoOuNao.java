import java.util.Scanner;

public class BissextoOuNao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual ano você está? ");
        int ano = scanner.nextInt();

        if(ano % 100 == 0){
            System.out.println("O ano não é bissexto");
        } else if (ano % 4 == 0) {
            System.out.println("O ano é bissexto!");
        }else {
            System.out.println("O ano não é bissexto...");
        }
    }
}
