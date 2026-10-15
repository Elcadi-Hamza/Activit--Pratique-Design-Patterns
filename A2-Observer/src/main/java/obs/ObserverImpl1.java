package obs;

public class ObserverImpl1 implements Observer{

    @Override
    public void update(Observable observable) {
        if (observable instanceof ObservableImpl obs) {
            System.out.println("****** Observable implimentation 2 ******");
            System.out.println("New state : " + obs.getState());
            System.out.println("*****************************************");
        }
    }
}
