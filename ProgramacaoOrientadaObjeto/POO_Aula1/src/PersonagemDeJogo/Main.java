package PersonagemDeJogo;

public class Main {
    public static void main(String[] args) {
        PersonagemDeJogo p1 = new PersonagemDeJogo("Luis o grande",
                100, 20, TipoPersonagem.GUERREIRO);
        PersonagemDeJogo p2 = new PersonagemDeJogo("Pedro Pascal o Feiticeiro",
                80, 25, TipoPersonagem.MAGO);

        p1.exibirStatus();
        p2.exibirStatus();

        System.out.println("\n--- Batalha ---");
        p1.atacar();
        p2.receberDano(p1.força);

        p2.atacar();
        p1.receberDano(p2.força);

        System.out.println("\n--- Status Final ---");
        p1.exibirStatus();
        p2.exibirStatus();
    }
}
