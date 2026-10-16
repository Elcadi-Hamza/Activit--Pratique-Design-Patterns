package exercice1.partie1;

import java.util.ArrayList;
import java.util.List;

public class Shape implements Composant{

    List<Composant> composants = new ArrayList<>();
    public void add(Composant composant){
        composants.add(composant);
    }

    @Override
    public void print() {
        for(Composant composant : composants) {
            composant.print();
        }
    }
}
