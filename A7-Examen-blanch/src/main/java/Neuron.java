import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private double bias;
    private final List<Connection> connections = new ArrayList<>();

    public Neuron(double bias) {
        this.bias = bias;
    }

    public void addConnection(Connection c) {
        connections.add(c);
    }
    public List<Connection> getConnections(){
        return connections;
    }
}
