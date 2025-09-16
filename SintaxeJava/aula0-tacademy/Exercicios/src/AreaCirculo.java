import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("diâmetro ou o raio? (0 para diâmetro, 1 para raio)");
        int escolha = scanner.nextInt();
        double raio = 0;

        if(escolha == 0){
            System.out.println("Insira o diâmetro do circulo: ");
            double diametro = scanner.nextDouble();
            raio = diametro / 2;
        }else{
            System.out.println("Insira o raio do circulo: ");
            raio = scanner.nextDouble();
        }

        double area = (raio * raio) * Math.PI;

        System.out.println("A área do circulo é de " + area + "m²");
    }
}
