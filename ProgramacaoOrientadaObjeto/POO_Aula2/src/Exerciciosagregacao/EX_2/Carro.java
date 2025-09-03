package Exerciciosagregacao.EX_2;

public class Carro {
    public String modelo;
    public Marca marca;
    public Motor motor;

    public Carro(String nome, Marca marca, Motor motor) {
        this.modelo = nome;
        this.marca = marca;
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Modelo: "+ modelo + " | Marca: "+ marca + " | Motor: "+ motor;
    }

}
