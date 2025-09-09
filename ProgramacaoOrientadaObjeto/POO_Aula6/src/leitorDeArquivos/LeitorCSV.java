package leitorDeArquivos;

public class LeitorCSV extends Leitor implements ArquivoLeitor{

    public LeitorCSV(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    public void ler() {
        System.out.println("Lendo arquivo CSV: " + caminhoArquivo);
        System.out.println("Colunas e linhas do CSV processadas com sucesso!");
    }
}
