package exercicio4;

public class Main {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("Pedro pascal", 25.5, 8, 22,
                22500.75, 0.05);
        Gerente gerente = new Gerente("Rodolfo goes", 50.4, 9, 23,
                2500);

        System.out.println("Vendedor: \n" + vendedor.mostrarSalarioMensal());
        System.out.println("Gerente: \n" + gerente.mostrarSalarioMensal());
    }
}
