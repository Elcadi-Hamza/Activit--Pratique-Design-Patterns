package obs;

@FunctionalInterface // interface fonctionelle
// une interface avec une seule methode s'appele une intrface fonctionelle.
public interface Observer {
//    void update(int state); //au cas de push
    void update(Observable o); // au cas de pull
}
