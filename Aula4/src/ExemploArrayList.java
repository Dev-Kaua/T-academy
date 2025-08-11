import java.util.ArrayList;

public class ExemploArrayList {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("João Silva");
        nomes.add("Walfredo");
        nomes.add("Pedro");

        ArrayList<Double> notas = new ArrayList<>();

        notas.add(10.0);
        notas.add(9.5);

        System.out.println(nomes.get(0)+" -> Reprovado?");
        System.out.println(notas.get(1) * 3);
    }
}
