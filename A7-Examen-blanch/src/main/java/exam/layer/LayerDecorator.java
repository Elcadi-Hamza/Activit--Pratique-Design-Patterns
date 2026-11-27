package exam.layer;

import exam.Neuron;

import java.util.List;

public class LayerDecorator implements Layer{
    protected Layer layer;
    protected LayerDecorator(Layer layer) {
        this.layer = layer;
    }

    @Override
    public List<Neuron> getNeurons() {
        return layer.getNeurons();
    }

    @Override
    public double[] forward(double[] in) {
        return layer.forward(in);
    }
}
