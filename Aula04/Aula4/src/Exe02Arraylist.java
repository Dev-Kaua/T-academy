import java.util.ArrayList;
import java.util.Scanner;

public class Exe02Arraylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> produtos = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();

        while(true){
            int contador = 1;
            System.out.println("Insira o produto n°"+ contador+": ");
            String produto = scanner.next();
            System.out.println("Insira o preço desse produto: ");
            Double preco = scanner.nextDouble();

            produtos.add(produto);
            precos.add(preco);
            contador++;

            System.out.println("Gostaria de finalizar a inserção de produtos? (s/n)");
            if(scanner.next().equalsIgnoreCase("s")) break;
        }

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i+1)+"° Produto: " + produtos.get(i) +
                    "\nPreço: R$"+ precos.get(i));

        }
    }
}
