import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dig = new Scanner(System.in);
        System.out.println("Olá, seja bem vindo ao consultório do DR.Barroso! \n" +
                "Antes de iniciarmos de fato sua consulta, é necessário um cadastro com informações \n" +
                "básicas do paciente. Por favor preencha os dados --->");
        System.out.println("Informe o nome do paciente");
        String namePacient = dig.next();
        System.out.println("Informe a idade");
        int age = dig.nextInt();
        String idadeStatus;
        if (age < 18) idadeStatus = "Pediatra";
        else if (age<60){
            idadeStatus = "Adulto";
        }else idadeStatus = "Idoso";
        System.out.println("Paciente possuí convênio?");
        String conv = dig.next().toLowerCase();
        if (conv.equals("sim")) conv="Sim";
        else conv="Não";

        int menu;
        double imc = 0;
        String statusConsulta = "Não agendada";
        do {
            System.out.println("Qual opção você deseja acessar? Calculo IMC:1, Consulta:2," +
                    " Dados do paciente:3, Nutricionista:4, Sair do programa:5");
            menu = dig.nextInt();
            if (menu == 1) {
                System.out.println("Informe a altura do paciente: (em CM)");
                double height = dig.nextDouble();

                System.out.println("Informe o peso do paciente (em KG's:");
                double weight = dig.nextDouble();

                double height1 = height / 100;

                imc = weight / (Math.pow(height1, 2));

                String indicadorIMC;

                if (imc < 18.5) {
                    indicadorIMC = "com o peso muito baixo.";
                } else if (imc < 25) {
                    indicadorIMC = "com o peso dentro do ideal (ou seja, normal).";
                } else if (imc < 30) {
                    indicadorIMC = "com sobrepeso";
                } else if (imc < 40) {
                    indicadorIMC = "com obesidade, devemos analisar e ver um tratamento adequado";
                } else {
                    indicadorIMC = "com obesidade severa! deve-se agendar uma bariátrica.";
                }

                System.out.println("Perfeito, seu cadastro foi concluído com sucesso! \n" +
                        "Com base nas informações inseridas, conseguimos calcular seu IMC\n" +
                        "IMC do " + namePacient + ": " + imc + "\nEsse IMC indica que você está " +
                        indicadorIMC);

            } else if (menu == 2) {
                int i = 0;

                System.out.println("O paciente está com febre?");
                String fever = dig.next().toLowerCase();

                if (fever.equals("sim")) i++;

                System.out.println("O paciente está com dor?");
                String pain = dig.next().toLowerCase();

                if (pain.equals("sim")) i++;

                System.out.println("O paciente está com problemas para dormir?");
                String sleep = dig.next().toLowerCase();

                if (sleep.equals("sim")) i++;

                System.out.println("O paciente está com alguma alteração na pele?");
                String pele = dig.next().toLowerCase();

                if (pele.equals("sim")) i++;

                System.out.println("O paciente está com enjoo?");
                String symptons = dig.next().toLowerCase();

                if (symptons.equals("sim")) i++;

                if (i == 0) System.out.println("O paciente está ok");
                else if (i <= 2) System.out.println("O paciente está levemente doente");
                else if (i <= 4) System.out.println("O paciente precisará ser internado");
                else System.out.println("O paciente está em estado terminal");
            } else if (menu == 3) {
                System.out.println("Dados do paciente:");
                System.out.println("Nome: "+namePacient);
                System.out.println("Idade: "+age+", O paciente é: "+idadeStatus);
                System.out.println("Convênio: "+conv);
                if (statusConsulta.equals("Agendado")){
                    System.out.println("Consulta com nutricionista: "+statusConsulta);
                }


            } else if (menu == 4) {
                if (imc == 0){
                    System.out.println("O paciente deve realizar o teste de IMC para poder realizar uma consulta com o nutricionista");
                }else{
                    System.out.println("Paciente: "+namePacient);
                    System.out.println("IMC: "+imc);
                    if (imc>25){
                        System.out.println("O paciente deve consultar o nutricionista pessoalmente para uma análise, mas o paciente está com sobrepeso.");
                    }else if (imc<15){
                        System.out.println("O paciente deve consultar o nutricionista pessoalmente para uma análise, mas o paciente está com magreza extrema");
                    }else {
                        System.out.println("Paciente saudavel");
                    }
                    System.out.println("Deseja agendar uma consulta?");
                    String consulta = dig.next().toLowerCase();
                    if (consulta.equals("sim")){
                        statusConsulta = "Agendado";
                        System.out.println("Consulta agendada com sucesso!");
                    }else{
                        System.out.println("Não agendado");
                    }
                }
            } else if (menu == 5) {
                System.exit(0);
            } else {
                System.out.println("Informe uma opção válida!");
            }


        }while (menu != 5);
    }
}