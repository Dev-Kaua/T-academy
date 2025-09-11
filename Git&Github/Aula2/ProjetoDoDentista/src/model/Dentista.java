package model;

public class Dentista {
    private int id;
    private String nome;
    private String especialidade;
    private String email;
    private String telefone;

    private static int contador = 1;

    public Dentista(String nome, String especialidade, String email, String telefone) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
        this.telefone = telefone;
        this.id = contador++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Dentista: \n" +
                "Id=" + id + '\n' +
                "Nome='" + nome + '\n' +
                "Especialidade='" + especialidade + '\n' +
                "Email='" + email + '\n' +
                "Telefone='" + telefone + '\n';
    }
}
