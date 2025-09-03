package PersonagemDeJogo;

public class Main {
    public static void main(String[] args) {
        PersonagemDeJogo p1 = new PersonagemDeJogo(1, "Luis o grande",
                100, 20, TipoPersonagem.GUERREIRO);
        PersonagemDeJogo p2 = new PersonagemDeJogo(1, "Pedro Pascal o Feiticeiro",
                80, 25, TipoPersonagem.MAGO);

        p1.exibirStatus();
        p2.exibirStatus();

        Batalha batalha = new Batalha();

        batalha.atacar(p1, p2);
        p2.exibirStatus();

        batalha.atacar(p2, p1);
        p1.exibirStatus();

        System.out.println("\n--- Status Final ---");
        p1.exibirStatus();
        p2.exibirStatus();
    }
}
