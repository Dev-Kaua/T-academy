package sistemaTransporteUrbano;

public abstract class Veiculo {
    protected boolean ligado = false;
    protected int velocidade = 0;

    public int getVelocidade() {
        return velocidade;
    }

    public void ligar() {
        ligado = true;
        System.out.println(this.getClass().getSimpleName() + " ligado.");
    }

    public void desligar() {
        ligado = false;
        velocidade = 0;
        System.out.println(this.getClass().getSimpleName() + " desligado.");
    }

    public void reduzirVelocidade(int decremento) {
        if (!ligado) {
            System.out.println(getClass().getSimpleName() + " está desligado, não é possível reduzir a velocidade.");
            return;
        }
        if (velocidade > 0) {
            velocidade = Math.max(0, velocidade - decremento);
            System.out.println(getClass().getSimpleName() + " reduziu a velocidade para " + velocidade + " km/h.");
        } else {
            System.out.println(getClass().getSimpleName() + " já está parado.");
        }
    }

    public void frearBruscamente() {
        if (!ligado) {
            System.out.println(getClass().getSimpleName() +
                    " está desligado, não é possível frear.");
            return;
        }
        if (velocidade > 0) {
            velocidade = 0;
            System.out.println(getClass().getSimpleName() + " freiou e parou completamente.");
        } else {
            System.out.println(getClass().getSimpleName() + " já está parado.");
        }
    }
}
