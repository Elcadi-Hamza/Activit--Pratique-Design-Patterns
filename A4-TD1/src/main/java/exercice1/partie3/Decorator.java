package exercice1.partie3;

public abstract class Decorator extends Interface {
    Interface anInterface;
    public Decorator(Interface anInterface) {
        this.anInterface = anInterface;
    }
}
