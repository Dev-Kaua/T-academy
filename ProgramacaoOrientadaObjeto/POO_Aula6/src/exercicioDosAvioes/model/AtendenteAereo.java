package exercicioDosAvioes.model;

public class AtendenteAereo extends Funcionario{

    public AtendenteAereo(String nome, int idade, String matricula) {
        super(nome, idade, matricula);
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " está atendendo os passageiros.");
    }
}
