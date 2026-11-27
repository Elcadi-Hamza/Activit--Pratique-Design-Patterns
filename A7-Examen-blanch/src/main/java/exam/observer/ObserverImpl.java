package exam.observer;

import exam.NetworkState;

import java.util.ArrayList;
import java.util.List;

public class ObserverImpl implements Observer{
    private final List<NetworkState> history = new ArrayList<>();

    @Override
    public void update(NetworkState newState) {
        history.add(newState);
        System.out.println("[Observer] Nouvel état du réseau : " + newState);
    }

    public void displayStats() {
        System.out.println("[Observer] " + history.size() + " changements d'état : " + history);
    }
}
