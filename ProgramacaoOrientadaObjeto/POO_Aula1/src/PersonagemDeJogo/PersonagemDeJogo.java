package PersonagemDeJogo;

public class PersonagemDeJogo {
    public String nome;
    public int vida;
    public int força;
    public TipoPersonagem tipo;

    public PersonagemDeJogo(String nome, int vida, int força, TipoPersonagem tipo) {
        this.nome = nome;
        this.vida = vida;
        this.força = força;
        this.tipo = tipo;
    }

    public void atacar(){
        switch (tipo) {
            case GUERREIRO -> {
                System.out.println(nome + " Atacou com a espada!");
                break;
            }
            case MAGO -> {
                System.out.println(nome + " lançou uma bola de fogo :O ");
                break;
            }
            case ARQUEIRO -> {
                System.out.println(nome + " disparou uma flecha");
                break;
            }
        }
    }

    public void receberDano(int dano){
        vida -= dano;

        if (vida < 0){
            vida = 0;
            System.out.println(nome + " recebeu " + dano + " de dano e voçe morreu!!!");
        }else{
        System.out.println(nome + " recebeu " + dano + " de dano. Vida restante: " + vida);
        }
    }

    public void exibirStatus() {
        System.out.println("Nome: " + nome + " | Tipo: " + tipo + " | Vida: " + vida);
    }


}