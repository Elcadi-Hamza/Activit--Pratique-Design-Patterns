package exam.layer;

public class DropoutDecorator extends LayerDecorator{
    private double rate;

    public DropoutDecorator(Layer layer, double rate) {
        super(layer);
        this.rate = rate;
    }

    @Override
    public double[] forward(double[] in) {
        double[] out = super.forward(in);
        for (int i = 0; i < out.length; i++) {
            if (Math.random() < rate) out[i] = 0;
        }
        return out;
    }
}
