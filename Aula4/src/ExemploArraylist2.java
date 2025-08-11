import java.util.ArrayList;
import java.util.Scanner;

public class ExemploArraylist2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> frutas = new ArrayList<>();

        while(true){
            System.out.println("Nome da fruta: (0 para sair)");
            String fruta = scanner.next();

            if(fruta.equals("0")) break;

            frutas.add(fruta);
        }

        System.out.println("\nFRUTAS\n");
//        (opção secundária):
//        for (String fruta: frutas){
//            System.out.println(fruta);
//        }

        for (int i = 0; i < frutas.size(); i++) {
            System.out.println(frutas.get(i));
        }
    }
}
