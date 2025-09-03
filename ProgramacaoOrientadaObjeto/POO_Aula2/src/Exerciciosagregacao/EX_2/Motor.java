package Exerciciosagregacao.EX_2;

public class Motor {

    public int cilindrada;
    public int potencia;
    public int quantValvulas;

    public Motor(int cilindrada, int potencia, int quantValvulas) {
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.quantValvulas = quantValvulas;
    }

    @Override
    public String toString() {
        return cilindrada + "cc, " + potencia + "cv, " + quantValvulas + "v";
    }
}
