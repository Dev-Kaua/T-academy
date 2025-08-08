public class Exercicio4 {
    public static void main(String[] args) {
        int populacaoA = 80000;
        int populacaoB = 200000;
        int contagemAnos =0;

        while(populacaoA <= populacaoB){
            populacaoA *= 1.03;

            populacaoB *= 1.015;

            contagemAnos++;
        }

        System.out.println("Os anos necessários para a população A ultrapassar a B é de: " +
                contagemAnos);
    }
}
