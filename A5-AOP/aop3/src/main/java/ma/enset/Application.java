package ma.enset;

import ma.enset.service.Imetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"ma.enset.service"})
public class Application {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ma.enset");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        Imetier metier = applicationContext.getBean(Imetier.class);
        metier.process();
        System.out.println(metier.compute());
    }
}
