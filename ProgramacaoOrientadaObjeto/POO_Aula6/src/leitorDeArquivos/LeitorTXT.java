package leitorDeArquivos;

public class LeitorTXT extends Leitor implements ArquivoLeitor{

    public LeitorTXT(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    public void ler() {
        System.out.println("Lendo arquivo TXT: " + caminhoArquivo);
        System.out.println("Conteúdo do TXT processado com sucesso!");
    }
}
