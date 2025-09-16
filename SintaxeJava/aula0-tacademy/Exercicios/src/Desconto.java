import java.util.Scanner;

public class Desconto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o nome do produto? ");
        String nome = scanner.nextLine();

        System.out.print("Qual o preço do produto? \nR$");
        double preco = scanner.nextDouble();

        double porcentagem = 30;

        double desconto = preco * (porcentagem / 100);

        double precoFinal = preco - desconto;

        System.out.println("Nome: "+ nome);
        System.out.print("Preço: R$"+ preco);
        System.out.println("Desconto: " + porcentagem + "%");
        System.out.println("O preço com o desconto de 30% aplicado é de: R$" + precoFinal);

    }
}
