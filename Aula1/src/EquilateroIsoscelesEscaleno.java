import java.util.Scanner;

public class EquilateroIsoscelesEscaleno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira as 3 medidas dos lados do triângulo: ");
        int lado1 = scanner.nextInt();
        int lado2 = scanner.nextInt();
        int lado3 = scanner.nextInt();

        if(lado1 == lado2 && lado2 == lado3){
            System.out.println("Seu triângulo é equilátero");
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            System.out.println("Seu triângulo é isósceles");
        }else{
            System.out.println("Seu triângulo é escaleno");
        }

    }
}
