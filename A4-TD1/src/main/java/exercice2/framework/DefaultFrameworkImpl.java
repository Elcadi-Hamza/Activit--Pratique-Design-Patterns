package exercice2.framework;

public class DefaultFrameworkImpl implements Framework {
    @Override
    public int[] filter(int[] data) {
        return data.clone();
    }

    @Override
    public int[] compresser(int[] data) {
        return data.clone();
    }
}
