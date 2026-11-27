import activation.ActivationFunction;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private double bias;
    private List<Connection> connections = new ArrayList<>();
    private ActivationFunction activation;

    public Neuron(ActivationFunction activation, double bias) {
        this.activation = activation;
        this.bias = bias;
    }

    public void addConnection(Connection c) {
        connections.add(c);
    }
    public List<Connection> getConnections(){
        return connections;
    }

    public ActivationFunction getActivation() {
        return activation;
    }

    public void setActivation(ActivationFunction activation) {
        this.activation = activation;
    }

    public double weightedSum(double[] x) {
        double s = bias;
        for (int i = 0; i < connections.size(); i++) {
            s += x[i] * connections.get(i).getWeight();
        }
        return s;
    }

    public double compute(double[] x) {
        return activation.apply(weightedSum(x));
    }
}
