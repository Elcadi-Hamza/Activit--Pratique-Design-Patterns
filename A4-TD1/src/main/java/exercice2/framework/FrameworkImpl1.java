package exercice2.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrameworkImpl1 implements Framework{

    // fitler tous les 0
    @Override
    public int[] filter(int[] data) {
        return Arrays.stream(data).filter(v -> v != 0).toArray();
    }

    // compress {5,5,5,2,2} -> {5,3,2,2}
    @Override
    public int[] compresser(int[] data) {
        List<Integer> out = new ArrayList<>();
        int i = 0;
        while (i < data.length) {
            int value = data[i], count = 1;
            while (i + count < data.length && data[i + count] == value) count++;
            out.add(value);
            out.add(count);
            i += count;
        }
        return out.stream().mapToInt(Integer::intValue).toArray();
    }
}
