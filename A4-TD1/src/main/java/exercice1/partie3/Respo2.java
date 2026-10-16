package exercice1.partie3;

public class Respo2 extends Decorator {
    public Respo2(Interface anInterface){
        super(anInterface);
    }

    @Override
    public void traitement() {
        System.out.println("traitingAvecResp2");

    }
}
