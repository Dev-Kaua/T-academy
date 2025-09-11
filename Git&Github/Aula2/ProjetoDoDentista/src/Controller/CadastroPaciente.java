package Controller;

import model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class CadastroPaciente {
    private List<Paciente> pacientes = new ArrayList<>();

    public void cadastrarPaciente(String nome, String email, String telefone) {
        Paciente paciente = new Paciente(nome, email, telefone);
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso: " + paciente.getNome());
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    public Paciente buscarPorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public boolean removerPaciente(int id) {
        Paciente paciente = buscarPorId(id);
        if (paciente != null) {
            pacientes.remove(paciente);
            return true;
        }
        return false;
    }
}
