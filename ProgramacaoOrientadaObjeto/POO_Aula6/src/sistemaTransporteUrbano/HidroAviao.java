package sistemaTransporteUrbano;

public class HidroAviao extends Veiculo implements Aereo,Aquatico,Terrestre{

    private boolean naAgua = true;
    private boolean emVoo = false;

    @Override
    public void dirigir() {
        if (!ligado) {
            System.out.println("O hidroavião precisa estar ligado para se mover em terra!");
            return;
        }
        if (emVoo) {
            System.out.println("O hidroavião não pode dirigir enquanto está voando!");
            return;
        }
        velocidade += 15;
        naAgua = false;
        System.out.println("O hidroavião está taxiando em terra a " + velocidade + " km/h.");
    }

    @Override
    public void navegar() {
        if (!ligado) {
            System.out.println("O hidroavião precisa estar ligado para navegar!");
            return;
        }
        if (emVoo) {
            System.out.println("O hidroavião não pode navegar enquanto está no ar!");
            return;
        }
        velocidade += 20;
        naAgua = true;
        System.out.println("O hidroavião está navegando a " + velocidade + " km/h na água.");
    }

    @Override
    public void voar() {
        if (!ligado) {
            System.out.println("O hidroavião precisa estar ligado para voar!");
            return;
        }
        if (naAgua && velocidade >= 40) {
            emVoo = true;
            naAgua = false;
            System.out.println("O hidroavião decolou da água e está voando!");
        } else if (!naAgua && velocidade >= 60) {
            emVoo = true;
            System.out.println("O hidroavião decolou da pista e está voando!");
        } else {
            System.out.println("Velocidade insuficiente para decolar.");
        }
    }

    @Override
    public void pousar() {
        if (emVoo) {
            emVoo = false;
            naAgua = true;
            velocidade = 0;
            System.out.println("O hidroavião pousou com sucesso na água.");
        } else {
            System.out.println("O hidroavião não está voando para pousar.");
        }
    }
}
