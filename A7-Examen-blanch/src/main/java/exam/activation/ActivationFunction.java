package exam.activation;

public interface ActivationFunction {
    double apply(double x);

    default double[] applyAll(double[] x) {
        double[] result = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = apply(x[i]);
        }
        return result;
    }
}
