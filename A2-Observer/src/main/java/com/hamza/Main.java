package com.hamza;

import obs.*;

public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl2();
        observable.subscribe(o1);
        observable.subscribe(o2);

        // observer anonyme
        observable.subscribe(new Observer() {
            @Override
            public void update(Observable o) {
                if (o instanceof ObservableImpl obs) {
                    System.out.println("****** Observable implimentation anonyme ******");
                    System.out.println("Res : " + obs.getState() + Math.cos(obs.getState()));
                    System.out.println("*****************************************");

                }
            }
        });

        observable.subscribe((o) -> {
            if (o instanceof ObservableImpl obs) {
                System.out.println("****** Observable implimentation anonyme ******");
                System.out.println("Res : " + obs.getState() + Math.cos(obs.getState()));
                System.out.println("*****************************************");
            }
        });
        observable.setState(60);
        observable.setState(80);
        observable.unsubscribe(o2);
        observable.setState(100);

    }
}
