package exercice1.partie4;

public class Couloir implements Observer{

    @Override
    public void update(int score) {
        System.out.println("from couloir new score : " + score);
    }
}
