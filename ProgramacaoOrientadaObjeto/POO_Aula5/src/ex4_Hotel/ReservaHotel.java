package ex4_Hotel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ReservaHotel {
    private String nomeCliente;
    private Date dataEntrada;
    private Date dataSaida;
    private Double valorDiaria;

    public ReservaHotel(String nomeCliente, Date dataEntrada, Date dataSaida, Double valorDiaria) {
        this.nomeCliente = nomeCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorDiaria = valorDiaria;

        if (dataSaida.before(dataEntrada)) {
            throw new IllegalArgumentException("A data de saída não pode ser anterior à data de entrada.");
        }
    }

    public int calcularNumeroDiarias() {
        LocalDate entrada = new java.sql.Date(dataEntrada.getTime()).toLocalDate();
        LocalDate saida = new java.sql.Date(dataSaida.getTime()).toLocalDate();
        return (int) ChronoUnit.DAYS.between(entrada, saida);
    }


    public void calcularTotal() {
        int numeroDiarias = calcularNumeroDiarias();
        if (numeroDiarias <= 0) {
            System.out.println("A data de saída deve ser posterior à data de entrada.");
            return;
        }
        double valorTotal = numeroDiarias * valorDiaria;
        System.out.println("Valor Total (sem desconto): R$" + valorTotal);
    }

    public void calcularTotal(double desconto){
        int numeroDiarias = calcularNumeroDiarias();

        if (numeroDiarias <= 0) {
            System.out.println("A data de saída deve ser posterior à data de entrada.");
            return;
        }

        if (desconto < 0 || desconto > 100) {
            System.out.println("O desconto tem que ser entre 0% e 100%.");
            return;
        }

        double valorTotal = numeroDiarias * valorDiaria;
        double valorComDesconto = valorTotal - (valorTotal * (desconto / 100));
        System.out.println("Valor Total (com desconto de " + desconto + "%): R$"
                + valorComDesconto);
    }

    public void exibirResumoReserva() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\nResumo da Reserva: ");
        System.out.println("Nome do Cliente: " + nomeCliente);
        System.out.println("Data de Entrada: " + sdf.format(dataEntrada));
        System.out.println("Data de Saída: " + sdf.format(dataSaida));
        System.out.println("Valor da Diária: R$" + valorDiaria);
        int numeroDiarias = calcularNumeroDiarias();
        System.out.println("Número de Diárias: " + numeroDiarias);
        calcularTotal();
    }

    public void exibirResumoReservaComDesconto(double desconto) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\nResumo da Reserva com Desconto: ");
        System.out.println("Nome do Cliente: " + nomeCliente);
        System.out.println("Data de Entrada: " + sdf.format(dataEntrada));
        System.out.println("Data de Saída: " + sdf.format(dataSaida));
        System.out.println("Valor da Diária: R$" + valorDiaria);
        int numeroDiarias = calcularNumeroDiarias();
        System.out.println("Número de Diárias: " + numeroDiarias);
        calcularTotal(desconto);
    }

    public void calcularTotalComTaxa(double taxaServico) {
        int numeroDiarias = calcularNumeroDiarias();
        if (numeroDiarias <= 0) {
            System.out.println("Erro! A data de saída deve ser posterior à data de entrada.");
            return;
        }
        double valorTotal = numeroDiarias * valorDiaria;
        double valorComTaxa = valorTotal + (valorTotal * (taxaServico / 100));
        System.out.println("Valor Total (com taxa de serviço de " + taxaServico + "%): R$"
                + valorComTaxa);
    }
}
