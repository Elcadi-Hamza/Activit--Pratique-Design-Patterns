package exercice1.partie2;

public class Plugin {
    private Operation partie1;
    private Operation partie2;

    public Plugin(Operation partie1, Operation partie2) {
        this.partie1 = partie1;
        this.partie2 = partie2;
    }

    public void execute() {
        partie1.execute();
        partie2.execute();
    }
}
