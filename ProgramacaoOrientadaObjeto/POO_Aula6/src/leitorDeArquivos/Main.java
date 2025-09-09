package leitorDeArquivos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Leitor txt = new LeitorTXT("dados.txt");
        Leitor csv = new LeitorCSV("planilha.csv");
        Leitor json = new LeitorJSON("configuracao.json");

        List<Leitor> leitores = new ArrayList<>();
        leitores.add(txt);
        leitores.add(csv);
        leitores.add(json);

        System.out.println("=== Iniciando leitura de arquivos ===");
        for (Leitor leitor : leitores) {
            leitor.ler();
            System.out.println("------------------------");
        }
    }
}
