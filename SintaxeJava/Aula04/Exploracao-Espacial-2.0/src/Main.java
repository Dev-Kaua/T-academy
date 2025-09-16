import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<SpaceBody> spaceBodies = new ArrayList<>();
    static ArrayList<String> Astronaut = new ArrayList<>();
    static HashMap<String, SpaceBody> spaceBodyMap = new HashMap<>();



    public static void main(String[] args) {


        while (true) {
            System.out.println("""
                    \n----------------------------------------------
                    Type what you want to do:
                    (1)-Register a new space body on the catalogue
                    (2)-Alter/View astronauts on SpaceStation
                    (3)-View all space bodies
                    (4)-View specific space body
                    (5)-Search space body by name
                    (0)-Leave""");
            int option = scanner.nextInt();

            if (option == 0) break;

            switch (option) {
                case 1 -> registerSpaceBodies();
                case 2 -> alterAstronaut();
                case 3 -> ListBodies();
                case 4 -> viewSpecificSpaceBody();
                case 5 -> searchSpaceBodyByName();
                default -> System.out.println("Invalid entrance");
            }
        }
    }

    private static void ListBodies() {
        for (int i = 0; i < spaceBodies.size(); i++) {
            System.out.println(i + " - " + spaceBodies.get(i).getNome());
        }
    }

    public static void registerSpaceBodies() {

        System.out.println("Insira o nome do corpo espacial: ");
        String nome = scanner.nextLine();
        if (spaceBodyMap.containsKey(nome)){
            System.out.println("Esse corpo espacial já foi encontrado! (Ou esse nome já existe)");
            return;
        }
        System.out.println("Insira a temperatura do corpo espacial: ");
        String temperatura = scanner.nextLine();
        System.out.println("Insira as caracteristicas atmosfericas do corpo espacial: ");
        String atmosfera = scanner.nextLine();
        System.out.println("Insira o tipo do corpo espacial: ");
        String tipo = scanner.nextLine();
        System.out.println("Insira o tamanho do corpo espacial: ");
        String tamanho = scanner.nextLine();
        System.out.println("Insira a massa do corpo espacial: ");
        String massa = scanner.nextLine();

        SpaceBody spaceBody = new SpaceBody(nome, temperatura, atmosfera, tipo, tamanho, massa);
        spaceBodies.add(spaceBody);
        spaceBodyMap.put(nome, spaceBody);

        System.out.println("Corpo espacial cadastrado com sucesso!");
    }

    public static void alterAstronaut() {
        System.out.println("""
                \n---------------------------------------
                Do you wish to add or remove an astronault from spacestation?
                (1)Add ---
                (2)Remove ---
                (3)List ---
                """);
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Insert astronault's name: ");
                String name = scanner.nextLine();
//                System.out.println("Insert astronault's specific function: ");
//                String astronaultFunction = scanner.nextLine();
//                Astronaut.add(astronaultFunction);
                Astronaut.add(name);
            }
            case 2 -> {
                System.out.println("Insert the astronault's name you wish to remove: ");
                String name = scanner.nextLine();
                if (Astronaut.remove(name)){
                    System.out.println("Astronauta removido com sucesso!");
                }else{
                    System.out.println("Nome não encontrado");
                }
            }

            case 3 -> {
                Collections.sort(Astronaut);
                System.out.println("Lista de astronautas na base espacial: ");
                System.out.println(Astronaut);
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    public static void viewSpecificSpaceBody() {
        if (spaceBodies.isEmpty()){
            System.out.println("Não há corpos espaciais cadastrados.");
            return;
        }

        System.out.println("Escolha um corpo celeste pela sua posição: ");
        for (int i = 0; i < spaceBodies.size(); i++) {
            System.out.println(i + " - " + spaceBodies.get(i).getNome());
        }

        int posicao = -1;

        while (true){
            System.out.println("Digite a posição: ");
            if(scanner.hasNextInt()){
                posicao = scanner.nextInt();
                if (posicao >= 0 && posicao < spaceBodies.size()){
                    break;   //o indice é valido ;)
                }else {
                    System.out.println("Posição inválida! tente um número entre 0 e " + (spaceBodies.size() - 1));
                }
            }else {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next();
            }
        }

        System.out.printf("| %-15s | %-15s | %-20s | %-10s | %-10s | %-10s |%n",
                "Name", "Temperature", "Atmosphere", "Type", "Size", "Mass");

        spaceBodies.get(posicao).exibirDetalhes();

    }

    public static void searchSpaceBodyByName(){
        System.out.println("Digite o nome do corpo espacial que você deseja buscar: ");
        String nome = scanner.nextLine();

        SpaceBody spaceBody = spaceBodyMap.get(nome);
        if(spaceBody != null){
            System.out.printf("| %-15s | %-15s | %-20s | %-10s | %-10s | %-10s |%n",
                    "Name", "Temperature", "Atmosphere", "Type", "Size", "Mass");
            spaceBody.exibirDetalhes();
        }else {
            System.out.println("Corpo espacial não encontrado.");
        }
    }

}