package activation;

public class SoftMax implements ActivationFunction{

    @Override
    public double apply(double x) {
        throw new UnsupportedOperationException("SoftMax s'applique sur un vecteur : utiliser applyAll");
    }

    @Override
    public double[] applyAll(double[] z) {
        double max = Double.NEGATIVE_INFINITY;
        for (double v : z) max = Math.max(max, v);   // stabilité numérique

        double sum = 0;
        double[] result = new double[z.length];
        for (int i = 0; i < z.length; i++) {
            result[i] = Math.exp(z[i] - max);
            sum += result[i];
        }
        for (int i = 0; i < z.length; i++) {
            result[i] /= sum;
        }
        return result;
    }
}
