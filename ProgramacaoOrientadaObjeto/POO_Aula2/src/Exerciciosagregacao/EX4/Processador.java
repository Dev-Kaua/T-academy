package Exerciciosagregacao.EX4;

public class Processador {
    public String modelo;
    public double velocidadeGHZ;
    public Marca marca;

    public Processador(String modelo, double velocidadeGHZ, Marca marca) {
        this.modelo = modelo;
        this.velocidadeGHZ = velocidadeGHZ;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Velocidade GHZ: " + velocidadeGHZ + ", Marca: "+ marca;
    }
}
