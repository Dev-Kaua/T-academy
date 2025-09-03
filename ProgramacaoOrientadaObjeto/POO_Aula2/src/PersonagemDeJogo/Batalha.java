package PersonagemDeJogo;

public class Batalha {


    public void atacar(PersonagemDeJogo atacante, PersonagemDeJogo defensor){
        switch (atacante.tipo) {
            case GUERREIRO -> {
                System.out.println(atacante.nome + " Atacou com a espada!");
                break;
            }
            case MAGO -> {
                System.out.println(atacante.nome + " lançou uma bola de fogo :O ");
                break;
            }
            case ARQUEIRO -> {
                System.out.println(atacante.nome + " disparou uma flecha");
                break;
            }
        }

        int dano = atacante.força;

        receberDano(defensor, dano);
    }

    public void receberDano(PersonagemDeJogo defensor, int dano) {
        defensor.vida -= dano;

        if (defensor.vida <= 0) {
            defensor.vida = 0;
            System.out.println(defensor.nome + " recebeu " + dano + " de dano e você morreu!!!");
        } else {
            System.out.println(defensor.nome + " recebeu " + dano + " de dano. Vida restante: " + defensor.vida);
        }
    }
}
