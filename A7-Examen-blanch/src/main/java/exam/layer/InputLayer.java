package exam.layer;

import exam.activation.Identity;

public class InputLayer extends AbstractLayer {
    public InputLayer(int size) {
        super(size, new Identity());
    }

    @Override
    public double[] forward(double[] in) {
        return in.clone();
    }
}
