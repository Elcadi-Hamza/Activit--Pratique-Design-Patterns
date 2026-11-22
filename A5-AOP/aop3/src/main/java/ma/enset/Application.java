package ma.enset;

import ma.enset.service.Imetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@ComponentScan(value = {"ma.enset.service","ma.enset.aspects"})
public class Application {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ma.enset");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        Imetier metier = applicationContext.getBean(Imetier.class);
        System.out.println("************************************");
        System.out.println(metier.getClass().getName());
        System.out.println("************************************");
        metier.process();
        System.out.println(metier.compute());
    }
}
