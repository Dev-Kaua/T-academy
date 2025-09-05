package GestaoTransportesUrbanos.monitoramento;

import java.time.LocalTime;

public class Horario {
    private LocalTime previsto;
    private int atrasoMinutos;

    public Horario(LocalTime previsto) {
        this.previsto = previsto;
        this.atrasoMinutos = 0;
    }

    public LocalTime getPrevisto() {
        return previsto;
    }

    public int getAtrasoMinutos() {
        return atrasoMinutos;
    }

    public void setPrevisto(LocalTime previsto) {
        this.previsto = previsto;
    }

    public void registrarAtraso(int minutos){
        atrasoMinutos += minutos;
        System.out.println("Atraso registrado: " + minutos + " minutos. Total de atraso: "
                + atrasoMinutos + " min.");
    }

    public void registrarAntecipacao(int minutos){
        atrasoMinutos -= minutos;
        System.out.println("Adiantamento registrado: " + minutos + " minutos. Total de atraso: "
                + atrasoMinutos + " min.");
    }

    public LocalTime getHorarioAtualizado(){
        return previsto.plusMinutes(atrasoMinutos);
    }

    public void exibirStatus() {
        System.out.println("Horário previsto: " + previsto +
                " | Atualizado: " + getHorarioAtualizado() +
                " | Atraso: " + atrasoMinutos + " min");
    }
}
