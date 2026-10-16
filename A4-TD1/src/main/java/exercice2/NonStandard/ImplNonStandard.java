package exercice2.NonStandard;

import java.util.Arrays;

public class ImplNonStandard implements NonStandard {
    @Override
    public int[] appliquerFiltre(String filterName, int[] data) {
        switch (filterName) {
            case "negatives":
                return Arrays.stream(data).filter(v -> v >= 0).toArray();
            case "double":
                return Arrays.stream(data).map(v -> v * 2).toArray();
            default:
                return data.clone();
        }
    }
}
