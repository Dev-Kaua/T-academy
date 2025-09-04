package SistemaStreamingMidia.Usuario;

import SistemaStreamingMidia.Midias.Genero;
import SistemaStreamingMidia.Midias.Midia;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Usuario {
    public String nome;
    public String email;
    public int tempoAssistido;
    public boolean assinaturaAtiva;
    private boolean pagamentoRecorrenteAtivo;
    private Genero generoFavorito;

    public Usuario(String nome, String email, Genero generoFavorito) {
        this.nome = nome;
        this.email = email;
        this.generoFavorito = generoFavorito;
        this.tempoAssistido = 0;
        this.assinaturaAtiva = false;
        this.pagamentoRecorrenteAtivo = false;
    }

    public abstract void assistirMidia(Midia midia);

    public void setTempoAssistido(int tempoAssistido) {
        this.tempoAssistido = tempoAssistido;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoAssistido() {
        return tempoAssistido;
    }

    public Genero getGeneroFavorito() {
        return generoFavorito;
    }

    public void ativarPagamentoRecorrente() {
        pagamentoRecorrenteAtivo = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                renovarAssinatura();
            }
        }, 30 * 24 * 60 * 60 * 1000L);
    }

    public void AssinarPlano(){
        assinaturaAtiva = true;
        pagamentoRecorrenteAtivo = true;
        System.out.println("\nPlano assinado para: " + getNome());
    }

    public void renovarAssinatura(){
        if(pagamentoRecorrenteAtivo){
            this.assinaturaAtiva = true;
            System.out.println("Assinatura renovada automaticamente para: " + nome);
        }
    }

    public void cancelarAssinatura() {
        this.assinaturaAtiva = false;
        this.pagamentoRecorrenteAtivo = false;
        System.out.println("Assinatura cancelada para: " + nome);
    }
}