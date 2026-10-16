package exercice1.partie4;

public class Gardien implements Observer{

    @Override
    public void update(int score) {
        System.out.println("from gardien new score : " + score);
    }
}
