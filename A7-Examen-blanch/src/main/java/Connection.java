public class Connection {
    private double weight;
    private Neuron source;
    private Neuron destination;

    public Connection(double weight, Neuron source, Neuron destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public Neuron getSource() {
        return source;
    }

    public Neuron getDestination() {
        return destination;
    }

    public void setWeight(double weight) {
        if(weight<0 || weight>1){
            throw new RuntimeException("weight must be between 0 and 1");
        }
        this.weight = weight;
    }

    public void setSource(Neuron source) {
        this.source = source;
    }

    public void setDestination(Neuron destination) {
        this.destination = destination;
    }
}
