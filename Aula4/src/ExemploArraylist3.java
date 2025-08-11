import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ExemploArraylist3 {
    static ArrayList<String> produtos = new ArrayList<>();
    static ArrayList<Double> precos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("(1) - Novo produto");
            System.out.println("(2) - Ver produtos");
            System.out.println("(3) - Remover produto");
            System.out.println("(0) - sair");
            System.out.print("Opção: ");
            int menu = scanner.nextInt();

            if (menu == 0) break;

            switch (menu){
                case 1 -> cadastrarNovoProduto();
                case 2 -> mostrarProdutos();
                case 3 -> removerProduto();
                default -> System.out.println("Entrada inválida");
            }
        }
    }

    public static void cadastrarNovoProduto (){
        System.out.println("Nome do produto: ");
        produtos.add(scanner.next());

    }
    public static void mostrarProdutos(){

    }

    public static void removerProduto(){
        
    }

}
