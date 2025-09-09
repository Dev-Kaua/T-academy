package sistemaTransporteUrbano;

public class Carro extends Veiculo implements Terrestre{
    @Override
    public void dirigir() {
        if (!ligado) {
            System.out.println("Não é possível dirigir um carro desligado!");
            return;
        }
        velocidade += 20;
        System.out.println("O carro está dirigindo a " + velocidade + " km/h.");
    }
}
