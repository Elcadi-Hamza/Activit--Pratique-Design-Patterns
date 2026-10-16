package exercice1.partie4;

import java.util.ArrayList;
import java.util.List;

public class Joueur implements Observable {
    private int score;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifier() {
        for (Observer observer : observers) {
            observer.update(score);
        }
    }

    public void setScore(int score) {
        this.score = score;
        notifier();
    }
    public int getScore(){ return score;}
}
