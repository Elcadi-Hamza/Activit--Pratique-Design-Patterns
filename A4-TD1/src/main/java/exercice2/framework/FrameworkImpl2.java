package exercice2.framework;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FrameworkImpl2 implements Framework{
    //Filter tous le 1
    @Override
    public int[] filter(int[] data) {
        return Arrays.stream(data).filter(v -> v != 1).toArray();
    }

    @Override
    public int[] compresser(int[] data) {
        Map<Integer, Integer> dict = new LinkedHashMap<>();
        for (int v : data) dict.merge(v, 1, Integer::sum);

        int[] out = new int[dict.size() * 2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : dict.entrySet()) {
            out[i++] = e.getKey();
            out[i++] = e.getValue();
        }
        return out;
    }
}
