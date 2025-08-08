import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner dig = new Scanner(System.in);
    static ArrayList<Paciente> pacientes = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do{
            System.out.println("Consultório DR.Alberto");
            System.out.println("\n======MENU======");
            System.out.println("1. Cadastrar novo paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Selecionar paciente para ações");
            System.out.println("4. Sair");
            opcao = dig.nextInt();
            dig.nextLine();

            switch (opcao){
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    selecionarPaciente();
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
            }
        } while (opcao != 4);

    }
    public static void cadastrarPaciente(){
        System.out.print("Nome do paciente: ");
        String nome = dig.nextLine();

        System.out.print("Idade do paciente: ");
        int idade = dig.nextInt();

        System.out.println("Paciente possuí convênio médico? (sim/não) ");
        String convenio = Boolean.parseBoolean(dig.nextLine().toLowerCase()) ? "sim" : "não";

        Paciente novo = new Paciente(nome, idade, convenio);
        pacientes.add(novo);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public static void listarPacientes(){
        if(pacientes.isEmpty()){
            System.out.println("Nenhum paciente cadastrado!");
            return;
        }

        System.out.println("Pacientes cadastrados: ");
        for(int i =0; i < pacientes.size(); i++){
            System.out.println((i + 1) + "- " + pacientes.get(i));
        }
    }
    public static void selecionarPaciente(){
        listarPacientes();
        if (pacientes.isEmpty()) return;
        System.out.println("Escolha um paciente pelo número: ");
        int index = dig.nextInt() - 1;
        dig.nextLine();
        if (index < 0 || index >= pacientes.size()){
            System.out.println("Paciente inválido!");
            return;
        }

        Paciente paciente = pacientes.get(index);
        menuPaciente(paciente);
    }
    public static void menuPaciente(Paciente paciente){
        int opcao = 0;
         do{
             System.out.println("\n-- Ações para o paciente " + paciente.nome + " --");
             System.out.println("1. Calcular IMC");
             System.out.println("2. Fazer diagnóstico (sintomas)");
             System.out.println("3. Dados do paciente");
             System.out.println("4. Consulta com nutricionista");
             System.out.println("5. Voltar");
             opcao = dig.nextInt();
             dig.nextLine();

             switch (opcao){
                 case 1:
                     System.out.println("Altura (em CM): ");
                     double altura = dig.nextDouble();
                     System.out.println("Peso (em KG): ");
                     double peso = dig.nextDouble();
                     dig.nextLine();
                     paciente.calcularIMC(altura, peso);
                     System.out.printf("IMC de %s: %.2f - %s\n"
                             , paciente.nome, paciente.imc, paciente.diagnosticoIMC());
                     break;
                 case 2:
                     diagnosticoSintomas(paciente);
                     break;
                 case 3:
                     System.out.println("Nome: " + paciente.nome);
                     System.out.println("Idade: " + paciente.idade + " (" + paciente.idadeStatus + ")");
                     System.out.println("Convênio: " + paciente.convenio);
                     System.out.println("IMC: " +
                             (paciente.imc == 0 ? "Não calculado" : String.format("%.2f", paciente.imc)));
                     System.out.println("Consulta com nutricionista: " + paciente.statusConsulta);
                     break;
                 case 4:
                     if(paciente.imc == 0){
                         System.out.println("Calcule o IMC do paciente primeiro!");
                     } else {
                         if (paciente.imc < 15 || paciente.imc > 25) {
                             System.out.println("O paciente deve consultar o nutricionista pessoalmente.");
                         } else {
                             System.out.println("O paciente está saudável. Não precisa de uma consulta com " +
                                     "o nutricionista.");
                         }
                         System.out.println("Deseja agendar uma consulta com o nutricionista? (sim/não) ");
                         String agendar = dig.nextLine().toLowerCase();

                         if (agendar.equals("sim")) {
                             paciente.statusConsulta = "Agendado";
                             System.out.println("Consulta agendada com sucesso!");
                         } else {
                             System.out.println("Consulta não agendada.");
                         }
                     }
                     break;
                 case 5:
                     break;
                 default:
                     System.out.println("Opção inválida!!!");
             }
         }while (opcao != 5);
    }

    private static void diagnosticoSintomas(Paciente paciente) {
        int sintomas = 0;
        String [] perguntas = {
                "Está com febre?",
                "Está com dor?",
                "Está com problemas para dormir?",
                "Tem alterações na pele?",
                "Está com enjoo?"
        };

        for (String pergunta : perguntas) {
            System.out.println(pergunta);
            String resp = dig.nextLine().toLowerCase();
            if (resp.equals("sim")) sintomas++;
        }

        if (sintomas == 0) System.out.println("O paciente está saudável.");
        else if (sintomas <= 2) System.out.println("O paciente está levemente doente.");
        else if (sintomas <= 4) System.out.println("O paciente precisará ser internado.");
        else System.out.println("O paciente está em estado terminal.");
    }
}