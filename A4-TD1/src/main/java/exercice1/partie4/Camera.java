package exercice1.partie4;


public class Camera implements Observer {
    @Override
    public void update(int score) {
        System.out.println("from camera new score : " + score);
    }
}