import java.util.Scanner;

public class Exe02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira quantos produtos você quer inserir no sistema: ");
        int qtdProdutos = scanner.nextInt();

        String[] produtos = new String[qtdProdutos];
        Double[] precos = new Double[qtdProdutos];

        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Nome do produto N°"+(i+1)+" : ");
            produtos[i] = scanner.next();
            System.out.println("Preço do produto N°"+(i+1)+" : ");
            precos[i] = scanner.nextDouble();
        }

        for (int i = 0; i < produtos.length; i++) {
            System.out.println((i+1)+"° Produto: " + produtos[i] + "\nPreço: R$"+precos[i]);
        }
    }
}
