package model;

public class Paciente {
    private int id;
    private String nome;
    private String email;
    private String telefone;

    private static int contador = 1;
    public Paciente(String nome, String email, String telefone) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Paciente: \n" + "telefone: " + telefone + '\n' +
                "Email='" + email + '\n' +
                "Nome='" + nome + '\n' +
                "Id=" + id;
    }
}
