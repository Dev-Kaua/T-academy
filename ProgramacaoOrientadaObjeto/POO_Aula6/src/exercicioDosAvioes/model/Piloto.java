package exercicioDosAvioes.model;

public class Piloto extends Funcionario{

    private String cnhAviao;

    public Piloto(String nome, int idade, String matricula, String cnhAviao) {
        super(nome, idade, matricula);
        this.cnhAviao = cnhAviao;
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " está pilotando o avião.");
    }
}
