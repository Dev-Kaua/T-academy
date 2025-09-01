package DiarioSecreto;

public class Main {
    public static void main(String[] args) {
        DiarioSecreto diario = new DiarioSecreto("Kauã", "1234");

        diario.escrever("0000", "Hoje vi umas fofocas do professor rannyer!");
        diario.escrever("1234", "Hoje estudei Java e springBoot!");
        diario.escrever("1234", "hoje tava com uma preguiça de sair da cama," +
                " fui dormir tarde ontem");

        diario.ler("0000");
        // to colocando a senha errada só pra mostrar o que vai imprimir
        diario.ler("1234");
    }
}
