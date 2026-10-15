package decorateurs;

import composants.Boisson;

public class Lait extends Decorateur{

    public Lait(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + " au Lait";
    }

    @Override
    public double cout() {
        return 4.59 + boisson.cout();
    }
}
