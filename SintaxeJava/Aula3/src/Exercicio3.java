import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome: ");
        String nome = scanner.nextLine();
        if (nome.length() > 3) {
            System.out.println("O nome é maior que 3 caractéres!!!");
        } else {
            System.out.println("O nome é menor que 3 caractéres.");
        }

        System.out.println("Insira a idade: ");
        int idade = scanner.nextInt();
        if (idade >= 0 && idade <= 150) {
            System.out.println("Sua idade é entre 0 e 150 anos!");
        } else if (idade > 150) {
            System.out.println("Idade maior que 150 anos.");
        } else {
            System.out.println("insira um valor que corresponda a uma idade!");
        }

        System.out.println("Insira seu salário: ");
        double salario = scanner.nextDouble();
        if (salario > 0) {
            System.out.println("Seu salário é maior que zero");
        } else {
            System.out.println("Salário igual a zero ou dívida");
        }

        System.out.println("Insira o sexo (m/f): ");
        String sexo = scanner.nextLine().toLowerCase();
        if(sexo.equals("m")){
            System.out.println("O sexo é masculino");
        } else if (sexo.equals("f")) {
            System.out.println("O sexo é feminino");
        }else {
            System.out.println("Sexo inválido");
        }

        System.out.println("Insira seu estado civil (s/c/v/d): ");
        String estadoCivil = scanner.nextLine().toLowerCase();
        if(estadoCivil.equals("s")){
            System.out.println("Estado civil solteiro");
        }else if(estadoCivil.equals("c")){
            System.out.println("Estado civil casado");
        } else if(estadoCivil.equals("v")){
            System.out.println("Estado civil viúvo");
        } else if(estadoCivil.equals("d")){
            System.out.println("Estado civil divorciado");
        } else {
            System.out.println("Insira um estado civil válido.");
        }
    }
}
