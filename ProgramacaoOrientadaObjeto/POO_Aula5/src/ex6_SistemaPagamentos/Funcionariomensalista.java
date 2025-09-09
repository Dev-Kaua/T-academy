package ex6_SistemaPagamentos;

public class Funcionariomensalista extends Funcionario{
    private double salarioFixo;

    public Funcionariomensalista(String nome, double salarioFixo) {
        super(nome);
        this.salarioFixo = salarioFixo;
    }


    @Override
    public double calcularSalario() {
        System.out.println(nome + " (Mensalista) - Salário fixo: R$" + salarioFixo);
        return salarioFixo;
    }

    @Override
    public double calcularSalario(double bonus) {
        double salario = salarioFixo + bonus;
        System.out.println(nome + " (Mensalista) - Salário com bônus: R$" + salario);
        return salario;
    }
}
