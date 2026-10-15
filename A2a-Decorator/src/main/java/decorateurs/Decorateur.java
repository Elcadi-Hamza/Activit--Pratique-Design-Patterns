package decorateurs;

import composants.Boisson;

public abstract class Decorateur extends Boisson {
    Boisson boisson;

    public Decorateur(Boisson boisson) {
        this.boisson = boisson;
    }
}
