package activation;

public class Identity implements ActivationFunction{
    @Override
    public double apply(double x) {
        return x;
    }
}
