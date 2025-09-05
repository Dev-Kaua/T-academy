package exercicio3;

public abstract class FiguraGeometrica {
    private double areaFigura;

    public FiguraGeometrica() {
        this.areaFigura = 0.0;
    }

    public double getAreaFigura() {
        return areaFigura;
    }

    public void setAreaFigura(double areaFigura) {
        this.areaFigura = areaFigura;
    }

    public String calcularArea(){
        return "Área da figura: "+ areaFigura+ "cm³";
    }
}
