package exercicioDosAvioes.model;

public abstract class Funcionario {
    protected String nome;
    protected int idade;
    protected String matricula;

    public Funcionario(String nome, int idade, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public abstract void trabalhar();
}
