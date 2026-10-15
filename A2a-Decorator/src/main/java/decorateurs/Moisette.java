package decorateurs;

import composants.Boisson;

public class Moisette extends Decorateur{

    public Moisette(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + " au Moisette";
    }

    @Override
    public double cout() {
        return 9.99 + boisson.cout();
    }
}
