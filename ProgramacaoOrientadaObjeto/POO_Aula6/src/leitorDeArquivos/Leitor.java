package leitorDeArquivos;

public abstract class Leitor implements ArquivoLeitor {
    protected String caminhoArquivo;

    public Leitor(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public abstract void ler();
}