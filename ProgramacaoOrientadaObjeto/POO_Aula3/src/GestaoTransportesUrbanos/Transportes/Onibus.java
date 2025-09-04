package GestaoTransportesUrbanos.Transportes;

public class Onibus extends Transporte {

    public Onibus(int id, String nome, int capacidade) {
        super(id, nome, capacidade);
    }

    @Override
    public void embarcar(int passageiros) {
        super.embarcar(passageiros);
    }

    @Override
    public void desembarcar(int passageiros) {
        super.desembarcar(passageiros);
    }

    public void informarAtraso(int minutos) {
        System.out.println("Atraso do ônibus " + nome + ": " + minutos + " minutos.");
    }

    public void exibirStatus() {
        System.out.println("Ônibus " + nome + " - Capacidade: " + capacidade +
                " - Passageiros atuais: " + numeroAtualPassageiros);
    }
}