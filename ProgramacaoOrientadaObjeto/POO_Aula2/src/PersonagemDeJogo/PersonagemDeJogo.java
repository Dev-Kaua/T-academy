package PersonagemDeJogo;

public class PersonagemDeJogo {
    public int id;
    public String nome;
    public int vida;
    public int força;
    public TipoPersonagem tipo;


    public PersonagemDeJogo(int id, String nome, int vida, int força, TipoPersonagem tipo) {
        this.id = id;
        this.nome = nome;
        this.vida = vida;
        this.força = força;
        this.tipo = tipo;
    }

    public void exibirStatus() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Tipo: " + tipo + " | Vida: " + vida);
    }

}