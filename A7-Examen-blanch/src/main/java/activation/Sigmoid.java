package activation;

public class Sigmoid implements ActivationFunction{

    @Override
    public double apply(double x) {
        return (double) 1/(1+Math.exp(-x));
    }
}
