package ex1_Herois;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Heroi> herois = new ArrayList<>();

        herois.add(new SuperMan());
        herois.add(new MulherMaravilha());
        herois.add(new Flash());

        for (Heroi heroi : herois){
            System.out.println(heroi.usarPoder());
        }

    }
}
