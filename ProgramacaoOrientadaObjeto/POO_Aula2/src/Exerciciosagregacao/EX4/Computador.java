package Exerciciosagregacao.EX4;

public class Computador {
    public String nome;
    public Processador processador;

    public Computador(String nome, Processador processador) {
        this.nome = nome;
        this.processador = processador;
    }

    @Override
    public String toString() {
        return "Computador: " + nome + " | Processador: "+ processador;
    }
}
