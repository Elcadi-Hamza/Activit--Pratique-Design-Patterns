import exam.NeuralNetwork;
import exam.activation.*;
import exam.aspects.SecurityAspect;
import exam.config.AppConfig;
import exam.layer.*;
import exam.observer.ObserverImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        NeuralNetwork nn = ctx.getBean(NeuralNetwork.class);       // proxy Spring
        ObserverImpl observer = ctx.getBean(ObserverImpl.class);   // proxy Spring

        HiddenLayer hidden = new HiddenLayer(5, new Sigmoid());
        nn.addLayer(new InputLayer(3));
        nn.addLayer(new NormalizationDecorator(hidden));   // Decorator
        nn.addLayer(new OutputLayer(2, new SoftMax()));

        nn.subscribe(observer);

        double[] input = {0.5, 0.2, 0.9};
        double[][] X = {{0.5, 0.2, 0.9}, {0.1, 0.8, 0.3}};
        double[][] Y = {{1, 0}, {0, 1}};

        // Test 1 : sécurité (non authentifié)
        try {
            nn.predict(input);
        } catch (SecurityException e) {
            System.out.println("Test 1 OK : " + e.getMessage());
        }

        SecurityAspect.login("admin", "1234");

        // Test 2 : predict avant entraînement
        try {
            nn.predict(input);
        } catch (IllegalStateException e) {
            System.out.println("Test 2 OK : " + e.getMessage());
        }

        // Test 3 : train (CONSTRUCTION -> TRAINING -> TRAINED) + Observer
        nn.train(X, Y);

        // Test 4 : predict
        double[] out = nn.predict(input);
        System.out.println("Test 4 : sortie = " + Arrays.toString(out)
                + ", somme = " + (out[0] + out[1]));

        // Test 5 : Strategy + Adapter
        hidden.getNeurons().forEach(n -> n.setActivation(new LegacyActivationAdapter(new LegacyActivation())));
        System.out.println("Test 5 : sortie avec ancienne fonction = " + Arrays.toString(nn.predict(input)));

        // Test 6 : fit (CONSTRUCTION -> TRAINED)
        NeuralNetwork nn2 = ctx.getBean(NeuralNetwork.class);      // nouvelle instance (prototype)
        nn2.addLayer(new InputLayer(3));
        nn2.addLayer(new OutputLayer(2, new Identity()));
        nn2.fit();
        System.out.println("Test 6 : état après fit = " + nn2.getState());

        observer.displayStats();

        ctx.close();
    }
}