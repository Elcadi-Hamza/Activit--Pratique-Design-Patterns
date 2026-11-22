package ma.enset.service;

import ma.enset.aspects.Log;
import org.springframework.stereotype.Service;

@Service
public class ImetierImpl implements Imetier {
    @Override
    @Log
    public void process() {
        System.out.println("Business process ......");
    }

    @Override
    @Log
    public double compute() {
        double data = 78;
        System.out.println("Business computing and return ......");
        return data;
    }
}
