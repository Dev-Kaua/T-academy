package sistemaTransporteUrbano;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HidroAviao hidroaviao = new HidroAviao();
        Terrestre bmw = new Carro();
        Aquatico barco = new Barco();

        List<Veiculo> veiculosList = new ArrayList<>();
        veiculosList.add(hidroaviao);
        veiculosList.add((Veiculo) bmw);
        veiculosList.add((Veiculo) barco);

        for (Veiculo v : veiculosList) {
            v.ligar();


            if (v instanceof Terrestre t) {
                t.dirigir();
                v.reduzirVelocidade(10);
            }


            if (v instanceof Aquatico a) {
                a.navegar();
                v.reduzirVelocidade(5);
            }


            if (v instanceof Aereo ae) {
                ae.voar();
                v.reduzirVelocidade(50);
            }

            v.frearBruscamente();

            v.desligar();
            System.out.println("--------------------------------------------------");
        }

        System.out.println(">>> Demonstração detalhada do Hidroavião <<<");
        hidroaviao.ligar();
        hidroaviao.navegar();
        hidroaviao.voar();
        hidroaviao.reduzirVelocidade(30);
        hidroaviao.frearBruscamente();
        hidroaviao.desligar();

    }
}
