package GestaoTransportesUrbanos.Transportes;

public class Metro extends Transporte{
    public Metro(int id, String nome, int capacidade) {
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

    public void monitorarEstacao(String estacao) {
        System.out.println("Monitorando estação " + estacao + " do metrô " + nome);
    }

    public void exibirStatus() {
        System.out.println("Metrô " + nome + " - Capacidade: " + capacidade +
                " - Passageiros atuais: " + numeroAtualPassageiros);
    }
}
