import java.util.Scanner;

public class DadosAnimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o reino do animal: ");
        String reino = scanner.nextLine();
        System.out.println("Informe o filo do animal: ");
        String filo = scanner.nextLine();
        System.out.println("Informe a classe do animal: ");
        String classe = scanner.nextLine();
        System.out.println("Informe a ordem do animal: ");
        String ordem = scanner.nextLine();
        System.out.println("Informe o gênero do animal: ");
        String genero = scanner.nextLine();
        System.out.println("Informe a espécie do animal: ");
        String especie = scanner.nextLine();

        System.out.println("reino: " + reino + "\nfilo: " + filo + "\nclasse: " + classe
        + "\nOrdem: " + ordem + "\nGênero: " + genero + "\nEspécie: " + especie);
    }
}
