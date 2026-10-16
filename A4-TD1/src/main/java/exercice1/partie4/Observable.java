package exercice1.partie4;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifier();
}
