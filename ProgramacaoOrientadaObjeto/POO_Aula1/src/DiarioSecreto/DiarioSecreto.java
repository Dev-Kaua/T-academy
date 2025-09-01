package DiarioSecreto;

public class DiarioSecreto {
    public String dono;
    public String senha;
    public String texto;

    public DiarioSecreto(String dono, String senha) {
        this.dono = dono;
        this.senha = senha;
        this.texto = "";
    }

    public void escrever(String senha, String novoTexto) {
        if (this.senha.equals(senha)) {
            texto = texto + novoTexto + "\n";
            System.out.println("Novo texto foi adicionado ao diário super secreto...");
        } else {
            System.out.println("Acesso negado! não colocou a senha certa");
        }
    }

    public void ler(String senha) {
        if (this.senha.equals(senha)) {
            System.out.println("Diário do " + dono + " protegido por esse software 100% seguro");
            System.out.println(texto);
        } else {
            System.out.println("Acesso negado! Tô de olho ");
        }
    }
}
