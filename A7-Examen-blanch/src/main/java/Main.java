import exam.Connection;
import exam.Neuron;
import exam.activation.Sigmoid;
import exam.layer.InputLayer;
import exam.layer.HiddenLayer;
import exam.layer.OutputLayer;

public class Main {
    public static void main(String[] args) {

        InputLayer input = new InputLayer(2);
        HiddenLayer hidden = new HiddenLayer(3, new Sigmoid());
        OutputLayer output = new OutputLayer(1, new Sigmoid());

        for (Neuron h : hidden.getNeurons()) {
            for (Neuron i : input.getNeurons()) {
                h.addConnection(new Connection(0.5, i, h));
            }
        }

        for (Neuron o : output.getNeurons()) {
            for (Neuron h : hidden.getNeurons()) {
                o.addConnection(new Connection(0.4, h, o));
            }
        }

        double[] inputs = {1.0, 0.5};
        double[] inputResult = input.forward(inputs);
        double[] hiddenResult = hidden.forward(inputResult);
        double[] outputResult = output.forward(hiddenResult);

        System.out.println("Input layer:");
        for (double v : inputResult) {
            System.out.println(v);
        }

        System.out.println("\nHidden layer:");
        for (double v : hiddenResult) {
            System.out.println(v);
        }

        System.out.println("\nOutput layer:");
        for (double v : outputResult) {
            System.out.println(v);
        }
    }
}
