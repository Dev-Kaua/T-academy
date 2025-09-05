package exercicio3;

public class Main {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(5.3, 8);
        Triangulo triangulo = new Triangulo(10, 6.5);

        System.out.println(triangulo.calcularArea());
        System.out.println(retangulo.calcularArea());
    }
}
