package ex6_SistemaPagamentos;

public class FuncionarioHorista extends Funcionario{

    private double valorHora;
    private int horasTrabalhadas;

    public FuncionarioHorista(String nome, double valorHora, int horasTrabalhadas) {
        super(nome);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }


    @Override
    public double calcularSalario() {
        double salario = valorHora * horasTrabalhadas;
        System.out.println(nome + " (Horista) - Salário calculado: R$" + salario);
        return salario;
    }

    @Override
    public double calcularSalario(double bonus) {
        double salario = (valorHora * horasTrabalhadas) + bonus;
        System.out.println(nome + " (Horista) - Salário com bônus: R$" + salario);
        return salario;
    }
}
