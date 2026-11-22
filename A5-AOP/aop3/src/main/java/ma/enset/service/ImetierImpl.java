package ma.enset.service;

import org.springframework.stereotype.Service;

@Service
public class ImetierImpl implements Imetier {
    @Override
    public void process() {
        System.out.println("Business process ......");
    }

    @Override
    public double compute() {
        double data = 78;
        System.out.println("Business computing and return ......");
        return data;
    }
}
