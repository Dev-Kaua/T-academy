public class SpaceBody {
    private String nome;
    private String temperatura;
    private String atmosfera;
    private String tipo;
    private String tamanho;
    private String massa;

    public SpaceBody(String nome, String temperatura, String atmosfera, String tipo, String tamanho, String massa) {
        this.nome = nome;
        this.temperatura = temperatura;
        this.atmosfera = atmosfera;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.massa = massa;
    }

    public void exibirDetalhes(){
        System.out.printf("| %-15s | %-15s | %-20s | %-10s | %-10s | %-10s |%n",
                nome, temperatura, atmosfera, tipo, tamanho, massa);
    }

    public String getNome() {
        return nome;
    }
}
