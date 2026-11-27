package exam.activation;

public class LegacyActivationAdapter implements ActivationFunction {
    private final LegacyActivation legacy;

    public LegacyActivationAdapter(LegacyActivation legacy) {
        this.legacy = legacy;
    }

    @Override
    public double apply(double x) {
        return legacy.calculate(x);
    }
}
