import java.util.Scanner;

public class TresNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o primeiro número: ");
        int numero1 = scanner.nextInt();
        System.out.println("Insira o segundo número: ");
        int numero2 = scanner.nextInt();
        System.out.println("Insira o terceiro número: ");
        int numero3 = scanner.nextInt();

        if(numero1 >= numero2){
            if( numero1 >= numero3) {
                if (numero2 >= numero3) {
                    System.out.println(numero1 + " > " + numero2 + " > " + numero3);
                } else {
                    System.out.println(numero1 + " > " + numero3 + " > " + numero2);
                }
            }else {
                System.out.println(numero3 + " > " + numero1 + " > " + numero2);
            }
        }else{
            if(numero2 > numero3){
                if(numero1 >= numero3){
                    System.out.println(numero2 + " > " + numero1 + " > " + numero3);
                }else{
                    System.out.println(numero2 + " > " + numero3 + " > " + numero1);
                }
            }else {
                System.out.println(numero3 + " > " + numero2 + " > " + numero1);
            }

        }
    }
}
