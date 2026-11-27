package exam;

import exam.layer.Layer;
import exam.observer.Observable;
import exam.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork implements Observable {
    private final List<Layer> layers = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();
    private NetworkState state = NetworkState.CONSTRUCTION;

    public void addLayer(Layer layer) {
        if (state != NetworkState.CONSTRUCTION) {
            throw new IllegalStateException("Impossible d'ajouter une couche hors de l'état CONSTRUCTION");
        }
        if (!layers.isEmpty()) {
            connect(layers.get(layers.size() - 1), layer);
        }
        layers.add(layer);
    }

    private void connect(Layer previous, Layer next) {
        for (Neuron dst : next.getNeurons()) {
            for (Neuron src : previous.getNeurons()) {
                dst.addConnection(new Connection(Math.random(), src, dst));
            }
        }
    }

    public void train(double[][] X, double[][] Y) {
        if (state != NetworkState.CONSTRUCTION) {
            throw new IllegalStateException("train() n'est possible que depuis l'état CONSTRUCTION");
        }
        setState(NetworkState.TRAINING);
        System.out.println("Erreur quadratique moyenne : " + loss(X, Y));
        setState(NetworkState.TRAINED);
    }

    public void fit() {
        if (state != NetworkState.CONSTRUCTION) {
            throw new IllegalStateException("fit() n'est possible que depuis l'état CONSTRUCTION");
        }
        setState(NetworkState.TRAINED);
    }

    public double[] predict(double[] input) {
        if (state != NetworkState.TRAINED) {
            throw new IllegalStateException("Le réseau n'est pas entraîné (état : " + state + ")");
        }
        double[] v = input;
        for (Layer layer : layers) {
            v = layer.forward(v);
        }
        return v;
    }

    private double loss(double[][] X, double[][] Y) {
        double total = 0;
        int count = 0;
        for (int i = 0; i < X.length; i++) {
            double[] v = X[i];
            for (Layer layer : layers) v = layer.forward(v);
            for (int j = 0; j < v.length; j++) {
                total += Math.pow(Y[i][j] - v[j], 2);
                count++;
            }
        }
        return total / count;
    }

    private void setState(NetworkState newState) {
        this.state = newState;
        notifyObservers();
    }

    public NetworkState getState() { return state; }

    @Override
    public void subscribe(Observer o) { observers.add(o); }

    @Override
    public void unsubscribe(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }
}