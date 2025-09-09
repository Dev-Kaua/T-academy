package leitorDeArquivos;

public class LeitorJSON extends Leitor implements ArquivoLeitor{
    public LeitorJSON(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    public void ler() {
        System.out.println("Lendo arquivo JSON: " + caminhoArquivo);
        System.out.println("Objetos JSON carregados com sucesso!");
    }


}
