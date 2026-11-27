
import exam.NeuralNetwork;
import exam.activation.Sigmoid;
import exam.layer.InputLayer;
import exam.layer.HiddenLayer;
import exam.layer.OutputLayer;
import exam.observer.ObserverImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        NeuralNetwork network = new NeuralNetwork();

        ObserverImpl observer = new ObserverImpl();

        network.subscribe(observer);

        InputLayer input = new InputLayer(2);
        HiddenLayer hidden = new HiddenLayer(3, new Sigmoid());
        OutputLayer output = new OutputLayer(1, new Sigmoid());

        network.addLayer(input);
        network.addLayer(hidden);
        network.addLayer(output);

        System.out.println("Initial state: " + network.getState());

        try {
            network.predict(new double[]{1.0, 0.5});
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        double[][] X = {
                {0.0, 0.0},
                {0.0, 1.0},
                {1.0, 0.0},
                {1.0, 1.0}
        };

        double[][] Y = {
                {0.0},
                {1.0},
                {1.0},
                {0.0}
        };

        System.out.println("\n--- TRAINING ---");
        network.train(X, Y);

        System.out.println("Current state: " + network.getState());

        System.out.println("\n--- PREDICTION ---");

        double[] result = network.predict(new double[]{1.0, 0.0});

        System.out.println("Input: [1.0, 0.0]");
        System.out.println("Output: " + Arrays.toString(result));

        System.out.println("\n--- OBSERVER STATISTICS ---");
        observer.displayStats();

        network.unsubscribe(observer);

        System.out.println("\nObserver unsubscribed.");

        try {
            network.fit();
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}