import composants.Boisson;
import composants.Colombia;
import composants.Espresso;
import composants.Sumatra;
import decorateurs.Caramel;
import decorateurs.Chocolat;
import decorateurs.Lait;
import decorateurs.Moisette;

public class Test {
    public static void main (String[] args) {
        Boisson boisson;
        boisson = new Sumatra();
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        boisson = new Espresso();
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("--------------------------");
        boisson = new Chocolat(boisson);
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("--------------------------");
        boisson = new Caramel(boisson);
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("--------------------------");
        boisson = new Moisette(boisson);
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("--------------------------");
        boisson = new Colombia();
        boisson = new Lait(boisson);
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());

    }
}

