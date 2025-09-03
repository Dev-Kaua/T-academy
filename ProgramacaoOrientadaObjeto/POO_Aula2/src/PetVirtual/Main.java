package PetVirtual;

import static PetVirtual.Especie.CACHORRO;

public class Main {
    public static void main(String[] args) {
        PetVirtual pet = new PetVirtual("Megzinha", CACHORRO,
                new Raca("American bully", CACHORRO));

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
