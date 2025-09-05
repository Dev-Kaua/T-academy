package exercicio4;

public class Gerente extends Funcionario{
    private double bonus;

    public Gerente(String nome, double salarioHora, int cargaHoraria, int diasTrabalhadosMes, double bonus) {
        super(nome, salarioHora, cargaHoraria, diasTrabalhadosMes);
        this.bonus = bonus;
    }

    public String mostrarSalarioMensal(){
        double salarioBase = calcularSalarioMensal();
        double salarioFinal = salarioBase + bonus;

        return "Salário base: R$"+ salarioBase
                + " | Bonus: R$"+ bonus
                + " | Salário final: R$"+ salarioFinal;
    }
}
