import java.util.ArrayList;
import java.util.Scanner;

public class ExploracaoEspacial {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String[]> spaceBodies = new ArrayList<>();
    static ArrayList<String> Astronaut = new ArrayList<>();



    public static void main(String[] args) {


        while (true) {
            System.out.println("""
                    \n----------------------------------------------
                    Type what you want to do:
                    (1)-Register a new space body on the catalogue
                    (2)-Alter/View astronauts on SpaceStation
                    (3)-View all space bodies
                    (4)-View specific space body
                    (0)-Leave""");
            int option = scanner.nextInt();

            if (option == 0) break;

            switch (option) {
                case 1 -> registerSpaceBodies();
                case 2 -> alterAstronaut();
                case 3 -> ListBodies();
                case 4 -> viewSpecificSpaceBody();
                default -> System.out.println("Invalid entrance");
            }
        }
    }

    private static void ListBodies() {
        for (int i = 0; i < spaceBodies.size(); i++) {
            System.out.println(i + " - " + spaceBodies.get(i)[0]);
        }
    }

    public static void registerSpaceBodies() {

        System.out.println("Insira o nome do corpo espacial: ");
        String nomeCorpoEspacial = scanner.next();
        System.out.println("Insira a temperatura do corpo espacial: ");
        String temperaturaCorpoEspacial = scanner.next();
        System.out.println("Insira as caracteristicas atmosfericas do corpo espacial: ");
        String atmosferaCorpoEspacial = scanner.next();
        System.out.println("Insira o tipo do corpo espacial: ");
        String tipoCorpoEspacial = scanner.next();
        System.out.println("Insira o tamanho do corpo espacial: ");
        String tamanhoCorpoEspacial = scanner.next();
        System.out.println("Insira a massa do corpo espacial: ");
        String massaCorpoEspacial = scanner.next();

        spaceBodies.add(new String[]{nomeCorpoEspacial, temperaturaCorpoEspacial,
                atmosferaCorpoEspacial, tipoCorpoEspacial, tamanhoCorpoEspacial,
                massaCorpoEspacial});
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
                String name = scanner.next();
//                System.out.println("Insert astronault's specific function: ");
//                String astronaultFunction = scanner.next();
//                Astronaut.add(astronaultFunction);
                Astronaut.add(name);
            }
            case 2 -> {
                System.out.println("Insert the astronault's name you wish to remove: ");
                String name = scanner.next();
                Astronaut.remove(name);
            }

            case 3 -> System.out.println(Astronaut);
        }
    }

    public static void viewSpecificSpaceBody() {
        System.out.println("Escolha um corpo celeste pela sua posição: ");
        for (int i = 0; i < spaceBodies.size(); i++) {
            System.out.println(i + " - " + spaceBodies.get(i)[0]);
        }

        int posicao = scanner.nextInt();

        System.out.printf("| %-15s | %-15s | %-20s | %-10s | %-10s | %-10s |%n",
                "Name", "Temperature", "Atmosphere", "Type", "Size", "Mass");


        System.out.printf("| %-15s | %-15s | %-20s | %-10s | %-10s | %-10s |%n",
                spaceBodies.get(posicao)[0],
                spaceBodies.get(posicao)[1],
                spaceBodies.get(posicao)[2],
                spaceBodies.get(posicao)[3],
                spaceBodies.get(posicao)[4],
                spaceBodies.get(posicao)[5]);


    }
}