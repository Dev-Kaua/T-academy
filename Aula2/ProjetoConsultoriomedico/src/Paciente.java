public class Paciente {
    String nome;
    int idade;
    String convenio;
    String idadeStatus;
    double imc;
    String statusConsulta = "não agendada";

    public Paciente(String nome, int idade, String convenio) {
        this.nome = nome;
        this.idade = idade;
        this.convenio = convenio;

        if(idade < 18) this.idadeStatus = "Pediatra";
        else if (idade < 60) this.idadeStatus = "Adulto";
        else this.idadeStatus = "Idoso";
    }

    public void calcularIMC (double alturaCm, double pesoKg){
        double alturaM = alturaCm/100;
        this.imc = pesoKg / (alturaM * alturaM);
    }

    public String diagnosticoIMC() {
        if (imc == 0) return "O IMC não foi calculado ainda";
        else if (imc < 18.5) return "O IMC indica que a pessoa está abaixo do peso ideal";
        else if (imc < 25) return "O IMC indica que a pessoa está dentro do peso ideal!";
        else if (imc < 30) return "O IMC indica que a pessoa está com sobrepeso";
        else if (imc < 40) return "O IMC indica que a pessoa está com obesidade";
        else return "O paciente está com obesidade severa!";

    }
}
