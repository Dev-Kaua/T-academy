package PetVirtual;

public class Raca {
    public String nome;
    public Especie especie;

    public Raca(String nome, Especie especie) {
        this.nome = nome;
        this.especie = especie;
    }

    @Override
    public String toString() {
        return nome + " - " + especie;
    }
}