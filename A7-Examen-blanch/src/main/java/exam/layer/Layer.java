package exam.layer;

import exam.Neuron;

import java.util.List;


public interface Layer {
    List<Neuron> getNeurons();
    double[] forward(double[] in);
}
