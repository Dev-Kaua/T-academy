package exercicio3;

public class Triangulo extends FiguraGeometrica{
    private double base1;
    private double base2;

    public Triangulo(double base1, double base2) {
        this.base1 = base1;
        this.base2 = base2;
    }

    @Override
    public String calcularArea() {
        double novaArea = (base1 * base2) / 2;
        setAreaFigura(novaArea);
        return super.calcularArea();
    }
}
