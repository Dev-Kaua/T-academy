package exercicioDosAvioes;

import exercicioDosAvioes.controller.AviaoController;
import exercicioDosAvioes.model.*;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AviaoController controller = new AviaoController();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistema de Gestão de Aviões ===");
            System.out.println("1 - Adicionar Avião");
            System.out.println("2 - Adicionar Passageiro");
            System.out.println("3 - Remover Passageiro");
            System.out.println("4 - Adicionar Funcionário");
            System.out.println("5 - Remover Funcionário");
            System.out.println("6 - Iniciar Voo");
            System.out.println("7 - Listar Aviões");
            System.out.println("8 - Atualizar Status de Voos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1: // Adicionar avião
                    System.out.print("Modelo do avião: ");
                    String modelo = scanner.nextLine();
                    System.out.print("ID do avião: ");
                    String id = scanner.nextLine();
                    System.out.print("Capacidade de passageiros: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();
                    Aviao aviao = new Aviao(modelo, id, capacidade);
                    controller.adicionarAviao(aviao);
                    break;

                case 2: // Adicionar passageiro
                    System.out.print("ID do avião: ");
                    String idPassageiro = scanner.nextLine();
                    System.out.print("Nome do passageiro: ");
                    String nomePassageiro = scanner.nextLine();
                    System.out.print("CPF do passageiro: ");
                    String cpfPassageiro = scanner.nextLine();
                    Passageiro passageiro = new Passageiro(nomePassageiro, cpfPassageiro);
                    controller.adicionarPassageiro(idPassageiro, passageiro);
                    break;

                case 3: // Remover passageiro
                    System.out.print("ID do avião: ");
                    String idRemoverPassageiro = scanner.nextLine();
                    System.out.print("Nome do passageiro: ");
                    String nomeRemoverPassageiro = scanner.nextLine();
                    Passageiro passageiroRemover = new Passageiro(nomeRemoverPassageiro, "");
                    controller.removerPassageiro(idRemoverPassageiro, passageiroRemover);
                    break;

                case 4: // Adicionar funcionário
                    System.out.print("ID do avião: ");
                    String idFuncionario = scanner.nextLine();
                    System.out.print("Nome do funcionário: ");
                    String nomeFuncionario = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeFuncionario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Tipo (1-Piloto / 2-Atendente): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    Funcionario funcionario;
                    if (tipo == 1) {
                        System.out.print("CNH Aviação: ");
                        String cnh = scanner.nextLine();
                        funcionario = new Piloto(nomeFuncionario, idadeFuncionario, matricula, cnh);
                    } else {
                        funcionario = new AtendenteAereo(nomeFuncionario, idadeFuncionario, matricula);
                    }
                    controller.adicionarFuncionario(idFuncionario, funcionario);
                    break;

                case 5: // Remover funcionário
                    System.out.print("ID do avião: ");
                    String idRemoverFuncionario = scanner.nextLine();
                    System.out.print("Nome do funcionário: ");
                    String nomeRemoverFuncionario = scanner.nextLine();
                    Funcionario fRemover = new AtendenteAereo(nomeRemoverFuncionario, 0, ""); // só precisa do nome para identificar
                    controller.removerFuncionario(idRemoverFuncionario, fRemover);
                    break;

                case 6: // Iniciar voo
                    System.out.print("ID do avião: ");
                    String idVoo = scanner.nextLine();
                    System.out.print("Hora de partida (HH:mm): ");
                    String horaPartidaStr = scanner.nextLine();
                    System.out.print("Hora de chegada (HH:mm): ");
                    String horaChegadaStr = scanner.nextLine();
                    LocalTime horaPartida = LocalTime.parse(horaPartidaStr);
                    LocalTime horaChegada = LocalTime.parse(horaChegadaStr);
                    controller.iniciarVoo(idVoo, horaPartida, horaChegada);
                    break;

                case 7: // Listar aviões
                    controller.listarAvioes();
                    break;

                case 8: // Atualizar status
                    LocalTime agora = LocalTime.now();
                    controller.atualizarStatus(agora);
                    System.out.println("Status atualizado para horário: " + agora);
                    break;

                case 0: // Sair
                    running = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}