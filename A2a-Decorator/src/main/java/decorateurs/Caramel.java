package decorateurs;

import composants.Boisson;

public class Caramel extends Decorateur{

    public Caramel(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + " au Caramel";
    }

    @Override
    public double cout() {
        return 8.89 + boisson.cout();
    }
}
