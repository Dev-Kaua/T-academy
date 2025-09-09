package ex6_SistemaPagamentos;

public abstract class Funcionario {
    protected String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularSalario();

    public abstract double calcularSalario(double bonus);
}
