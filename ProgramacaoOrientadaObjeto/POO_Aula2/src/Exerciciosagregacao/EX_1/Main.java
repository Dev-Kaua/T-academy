package Exerciciosagregacao.EX_1;

public class Main {
    public static void main(String[] args) {
        Endereco end1 = new Endereco();
        end1.rua = "rua XV";
        end1.cidade = "Blumenau";
        end1.estado = Estado.SC;

        Pessoa pessoa1 = new Pessoa();
        pessoa1.nome = "Luis cobol";
        pessoa1.endereco = end1;

        System.out.println("Pessoa: " + pessoa1.nome);
        System.out.println("Endereço:");
        System.out.println("Rua: " + pessoa1.endereco.rua);
        System.out.println("Cidade: " + pessoa1.endereco.cidade);
        System.out.println("Estado: " + pessoa1.endereco.estado.nome + " (" + pessoa1.endereco.estado + ")");
    }
}
