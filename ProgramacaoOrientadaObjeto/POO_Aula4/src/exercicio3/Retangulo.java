package exercicio3;

public class Retangulo extends FiguraGeometrica{
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public String calcularArea() {
        double novaArea = base * altura;
        setAreaFigura(novaArea);
        return super.calcularArea();
    }
}
