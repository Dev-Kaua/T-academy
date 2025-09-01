package PetVirtual;

public class Main {
    public static void main(String[] args) {
        PetVirtual pet = new PetVirtual("Megzinha");

        pet.status();
        //tentando deixar ele com a fome muito alta
        for (int i = 0; i < 5; i++) {
            pet.brincar();
        }
        pet.alimentar();
        pet.status();
        pet.brincar();
        pet.status();
    }
}
