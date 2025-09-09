package ex6_SistemaPagamentos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionariosList = new ArrayList<>();

        funcionariosList.add(new FuncionarioHorista("Ana", 50, 160));       // 160h x 50
        funcionariosList.add(new FuncionarioHorista("Carlos", 60, 120));    // 120h x 60
        funcionariosList.add(new Funcionariomensalista("Beatriz", 5000));
        funcionariosList.add(new Funcionariomensalista("Daniel", 7000));

        System.out.println("=== Cálculo de salários sem bônus ===");
        for (Funcionario funcionario : funcionariosList) {
            funcionario.calcularSalario();
            System.out.println("------------------------");
        }

        System.out.println("=== Cálculo de salários com bônus ===");
        for (Funcionario funcionario : funcionariosList) {
            funcionario.calcularSalario(500);
            System.out.println("------------------------");
        }
    }
}
