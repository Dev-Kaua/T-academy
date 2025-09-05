package estudandoHeranca;

import java.util.ArrayList;

public class Aluno extends Pessoa{

    private ArrayList<Double> notas;

    public Aluno(int id, String nome, String cpf, ArrayList<Double> notas) {
        super(id, nome, cpf);
        this.notas = notas;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }
}
