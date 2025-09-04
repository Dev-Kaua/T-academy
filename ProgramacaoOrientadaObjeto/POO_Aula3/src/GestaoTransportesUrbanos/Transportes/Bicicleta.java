package GestaoTransportesUrbanos.Transportes;

public class Bicicleta extends Transporte{
    public Bicicleta(int id, String nome, int capacidade) {
        super(id, nome, capacidade);
    }

    @Override
    public void embarcar(int passageiros) {
        if(passageiros == 1){
            super.embarcar(passageiros);
        }else {
            System.out.println("A bicicleta só consegue comportar 1 passageiro," +
                    " é proibido levar passageiro no cano.");
        }
    }

    @Override
    public void desembarcar(int passageiros) {
        if (passageiros == 1){
        super.desembarcar(passageiros);
        }else {
            System.out.println("Só pode ter um ou nenhum passageiro na bicicleta," +
                    " então insira no máximo 1 passageiro para desembarcar.");
        }
    }

    public void exibirStatus() {
        System.out.println("Bicicleta " + nome + " - Passageiro atual: " + numeroAtualPassageiros);
    }

    public void disponibilizarBicicleta() {
        if (numeroAtualPassageiros == 0) {
            System.out.println("A bicicleta " + nome + " está disponível para locação.");
        } else {
            System.out.println("A bicicleta " + nome + " já está em uso.");
        }
    }
}
