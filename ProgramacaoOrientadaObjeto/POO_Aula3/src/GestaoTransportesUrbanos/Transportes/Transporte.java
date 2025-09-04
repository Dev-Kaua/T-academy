package GestaoTransportesUrbanos.Transportes;

public abstract class Transporte {
    protected int id;
    protected String nome;
    protected int capacidade;
    protected int numeroAtualPassageiros;

    public Transporte(int id, String nome, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.numeroAtualPassageiros = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getNumeroAtualPassageiros() {
        return numeroAtualPassageiros;
    }

    public void embarcar (int passageiros){
        if(numeroAtualPassageiros + passageiros <= capacidade){
            numeroAtualPassageiros += passageiros;
            System.out.println(passageiros + " passageiro(s) embarcaram no "+ nome);
        }else {
            System.out.println("Não é possivel embarcar "+ passageiros + " passageiros. se essa quantidade de" +
                    " passageiros entrarem irá ultrapassar a capacidade máxima do transporte de "+ getCapacidade());
        }
    }
    public void desembarcar ( int passageiros){
        if(numeroAtualPassageiros >= passageiros){
            numeroAtualPassageiros -= passageiros;
            System.out.println(passageiros + " passageiro(s) derembarcaram do "+ nome);
        }else{
            System.out.println("Não há passageiros suficientes para desembarcar do "+ nome);
        }
    }

    public boolean estaLotado(){
        return numeroAtualPassageiros >= capacidade;
    }

    public void atualizarLotacao(int passageiros){
        this.numeroAtualPassageiros += passageiros;
        if(this.numeroAtualPassageiros > capacidade){
            this.numeroAtualPassageiros = capacidade;
        }
    }

}
