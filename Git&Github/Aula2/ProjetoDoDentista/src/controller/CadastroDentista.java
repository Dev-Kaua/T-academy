package controller;

import model.Dentista;

import java.util.ArrayList;
import java.util.List;

public class CadastroDentista {
    private List<Dentista> dentistaList = new ArrayList<>();

    public void cadastrarDentistas (String nome, String especialidade, String email, String telefone){
        Dentista dentista = new Dentista( nome, especialidade, email, telefone);
        dentistaList.add(dentista);
        System.out.println("Dentista cadastrado com sucesso: "+ dentista.getNome());
    }

    public List<Dentista> listarDentistas() {
        return dentistaList;
    }

    public Dentista buscarPorId(int id){
        for(Dentista dentista: dentistaList){
            if (dentista.getId() == id){
                return dentista;
            }else {
                System.out.println("Dentista com esse id não encontrado!");
            }
        }
        return null;
    }

    public void removerDentistaPorId(int id){
       Dentista dentista = buscarPorId(id);
       if (dentista != null){
           dentistaList.remove(dentista);
       }
    } 
}
