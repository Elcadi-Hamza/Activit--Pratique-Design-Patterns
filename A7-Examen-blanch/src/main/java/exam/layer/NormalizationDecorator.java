package exam.layer;

public class NormalizationDecorator extends LayerDecorator {
    public NormalizationDecorator(Layer layer) {
        super(layer);
    }
    @Override
    public double[] forward(double[] in) {
        double[] out = super.forward(in);
        double max = 0;
        for (double v : out) max = Math.max(max, Math.abs(v));
        if (max > 0) {
            for (int i = 0; i < out.length; i++) out[i] /= max;
        }
        return out;
    }
}
