package decorateurs;

import composants.Boisson;

public class Chantily extends Decorateur{

    public Chantily(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + " au Chantily";
    }

    @Override
    public double cout() {
        return 8.89 + boisson.cout();
    }
}
