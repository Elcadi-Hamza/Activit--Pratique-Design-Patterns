package exercice1.partie3;

public abstract class Decorator implements Interface {
    Interface anInterface;
    public Decorator(Interface anInterface) {
        this.anInterface = anInterface;
    }
}
