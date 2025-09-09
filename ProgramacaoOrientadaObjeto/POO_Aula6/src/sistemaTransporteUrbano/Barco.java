package sistemaTransporteUrbano;

public class Barco extends Veiculo implements Aquatico{

    @Override
    public void navegar() {
        if (!ligado) {
            System.out.println("O barco precisa estar ligado para navegar!");
            return;
        }
        System.out.println("O barco está navegando pelo rio.");
    }
}
