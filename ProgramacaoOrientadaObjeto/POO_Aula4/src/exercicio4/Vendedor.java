package exercicio4;

public class Vendedor extends Funcionario{
    private double valorTotalVendas;
    private double percentualComissao;

    public Vendedor(String nome, double salarioHora, int cargaHoraria, int diasTrabalhadosMes,
                    double valorTotalVendas, double percentualComissao) {
        super(nome, salarioHora, cargaHoraria, diasTrabalhadosMes);
        this.valorTotalVendas = valorTotalVendas;
        this.percentualComissao = percentualComissao;
    }

    public String mostrarSalarioMensal() {
        double salarioBase = calcularSalarioMensal();
        double comissaoFinal = valorTotalVendas * percentualComissao;
        double salarioFinal = salarioBase + comissaoFinal;

        return "Salário base: R$" + salarioBase +
                " | Comissão: R$" + comissaoFinal +
                " | Salário final: R$" + salarioFinal;
    }
}
