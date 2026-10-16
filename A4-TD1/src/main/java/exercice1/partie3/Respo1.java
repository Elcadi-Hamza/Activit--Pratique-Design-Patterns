package exercice1.partie3;

public class Respo1 extends Decorator {
    public Respo1 (Interface anInterface){
        super(anInterface);
    }

    @Override
    public void traitement() {
        System.out.println("traitingAvecResp1");

    }
}
