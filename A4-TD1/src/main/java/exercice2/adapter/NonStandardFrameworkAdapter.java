package exercice2.adapter;

import exercice2.NonStandard.NonStandard;
import exercice2.framework.Framework;

public class NonStandardFrameworkAdapter implements Framework {
    private NonStandard nonStandard;
    private String filterName;
    private Framework framework;

    public NonStandardFrameworkAdapter(NonStandard nonStandard, String filterName, Framework compressionDelegate) {
        this.nonStandard = nonStandard;
        this.filterName = filterName;
        this.framework = compressionDelegate;
    }

    @Override
    public int[] filter(int[] data) {
        return nonStandard.appliquerFiltre(filterName, data);
    }

    @Override
    public int[] compresser(int[] data) {
        return framework.compresser(data);
    }
    public void setNonStandard(NonStandard nonStandard) {
        this.nonStandard = nonStandard;
    }
}