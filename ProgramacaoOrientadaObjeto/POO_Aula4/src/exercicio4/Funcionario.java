package exercicio4;

public abstract class Funcionario {
    private String nome;
    private double salarioHora;
    private int cargaHoraria;
    private int diasTrabalhadosMes;

    public Funcionario(String nome, double salarioHora, int cargaHoraria, int diasTrabalhadosMes) {
        this.nome = nome;
        this.salarioHora = salarioHora;
        this.cargaHoraria = cargaHoraria;
        this.diasTrabalhadosMes = diasTrabalhadosMes;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double calcularSalarioMensal() {
        return salarioHora * (cargaHoraria * diasTrabalhadosMes);
    }
}
