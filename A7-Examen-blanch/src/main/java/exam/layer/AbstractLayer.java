package exam.layer;

import exam.Neuron;
import exam.activation.ActivationFunction;

import java.util.ArrayList;
import java.util.List;

public class AbstractLayer implements Layer{
    protected List<Neuron> neurons = new ArrayList<>();
    protected AbstractLayer(int size, ActivationFunction activation) {
        for (int i = 0; i < size; i++) {
            neurons.add(new Neuron(activation, Math.random()));
        }
    }
    @Override
    public List<Neuron> getNeurons() { return neurons; }

    @Override
    public double[] forward(double[] in) {
        double[] z = new double[neurons.size()];
        for (int i = 0; i < neurons.size(); i++) {
            z[i] = neurons.get(i).weightedSum(in);
        }
        return neurons.get(0).getActivation().applyAll(z);
    }
}
