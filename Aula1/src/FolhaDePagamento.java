import java.util.Scanner;

public class FolhaDePagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o valor da sua hora de trabalho: R$");
        double valorHora = scanner.nextDouble();
        System.out.println("Agora, quantas horas você trabalha por mês? ");
        double horasTrabalhadas = scanner.nextDouble();

        double salarioBruto = valorHora * horasTrabalhadas;
        double desconto;

        if(salarioBruto <= 900){
            desconto = 0;
        } else if (salarioBruto <= 1500) {
            desconto = 0.05;
        }else if (salarioBruto <= 2500){
            desconto = 0.1;
        }else {
            desconto = 0.2;
        }

        double impostoRenda = salarioBruto * desconto;
        double inss = salarioBruto * 0.1;
        double fgts = salarioBruto * 0.11;
        double totalDescontos = impostoRenda + inss;
        double percentualDesconto = desconto * 100;
        double salarioLiquido = salarioBruto - totalDescontos;

        System.out.println("Salário bruto: (" + valorHora + " * " + horasTrabalhadas +
                ")   : R$" + salarioBruto +
                "\n(-)IR (" + percentualDesconto + "%)   : R$" + impostoRenda +
                "\n(-)INSS (10%)   : R$" + inss + "\nFGTS (11%)   :R$" + fgts +
                "\nTotal de descontos   : R$" + totalDescontos + "\nSalário Líquido   : R$"
                + salarioLiquido);
    }
}
