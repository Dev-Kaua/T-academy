package ex4_Hotel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Cliente 1 - Sem desconto
            Date dataEntrada1 = sdf.parse("15/09/2025");
            Date dataSaida1 = sdf.parse("20/09/2025");
            ReservaHotel reserva1 = new ReservaHotel("Carlos Silva", dataEntrada1, dataSaida1, 200.00);

            reserva1.exibirResumoReserva();
            reserva1.exibirResumoReservaComDesconto(10);

            // Cliente 2 - Com desconto
            Date dataEntrada2 = sdf.parse("18/09/2025");
            Date dataSaida2 = sdf.parse("22/09/2025");
            ReservaHotel reserva2 = new ReservaHotel("Ana Oliveira", dataEntrada2, dataSaida2, 150.00);

            reserva2.exibirResumoReserva();
            reserva2.exibirResumoReservaComDesconto(20);

            // Cliente 3 - Com taxa de serviço adicional
            Date dataEntrada3 = sdf.parse("01/10/2025");
            Date dataSaida3 = sdf.parse("05/10/2025");
            ReservaHotel reserva3 = new ReservaHotel("João Souza", dataEntrada3, dataSaida3, 180.00);

            reserva3.exibirResumoReserva();
            reserva3.calcularTotalComTaxa(5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
