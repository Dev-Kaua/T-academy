package PetVirtual;

public class PetVirtual {
    public String nome;
    public int fome;
    public int felicidade;

    public PetVirtual(String nome) {
        this.nome = nome;
        this.fome = 100;
        this.felicidade = 50;
    }

    public void alimentar(){
        fome -= 30;
        System.out.println(nome + " foi alimentado! Fome agora: " + fome);
        if (fome < 0){
            fome = 0;
            System.out.println("Ele está morrendo de fome, dê mais comida a ele!");
        }
    }

    public void brincar(){
        felicidade += 20;
        fome += 20;
        if (felicidade > 100){
            felicidade = 100;
            System.out.println(nome + " está muito feliz! parabens por cuidar bem dele");
        }
        if (fome > 100) fome = 100;

        System.out.println(nome + " brincou e está mais feliz! Felicidade: " + felicidade);
    }

    public void status() {

        if (fome > 80) {
            felicidade -= 10;
            if (felicidade < 0) felicidade = 0;
            System.out.println(nome + " está com muita fome e ficou triste," +
                    " passar fome não é muito divertido... 😢");
        }

        System.out.println("Pet: " + nome + " | Fome: " + fome + " | Felicidade: " + felicidade);
    }
}
