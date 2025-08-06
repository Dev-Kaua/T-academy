import java.util.Scanner;

public class Equacao2Grau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira os valores de: \na: ");
        int a = scanner.nextInt();
        if(a == 0 ){
            System.out.println("A equação não é de segundo grau!");
            System.exit(0);
        }
        System.out.print("\nb: ");
        int b = scanner.nextInt();
        System.out.print("\nc: ");
        int c = scanner.nextInt();

        double delta = (b * b) - (4 * a * c);

        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);

        if(delta < 0){
            System.out.println("O valor de delta é negativo. " +
                    "\nPortanto, não possui raizes reais..");
        } else if (delta == 0) {
            System.out.println("O valor de delta é zero. " +
                    "\nExiste apenas uma raiz real, que é: x = " + x1);
        }else {
            System.out.println("O valor de delta é positivo " +
                    "\nExistem duas raizes: \nX1 = " + x1 + "\nX2 = " + x2);
        }


    }
}
