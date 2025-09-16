import java.util.Scanner;

public class OrganizacaoTabajara {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira seu salário: ");
        double salario = scanner.nextDouble();
        double aumento;

        if(salario <= 280){
            aumento = 0.2;
        } else if (salario <= 700) {
            aumento = 0.15;
        }else if ( salario <= 1500){
            aumento = 0.1;
        }else {
            aumento = 0.05;
        }
        double percentualAumento = aumento * 100;
        double valorAumento = salario * aumento;
        double salarioAjustado = salario + valorAumento;

        System.out.println("Seu salário era: R$" + salario +
                "\nRecebeu um percentual de aumento de: " + percentualAumento +
                "% \nO valor do aumento foi: R$" + valorAumento + "\nSeu novo salário é: R$"
                + salarioAjustado);
    }
}
