package ma.enset;

import ma.enset.service.Imetier;
import ma.enset.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@ComponentScan(value = {"ma.enset.service","ma.enset.aspects"})
public class Application {
    public static void main(String[] args) {
        try{
            //        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ma.enset");
            SecurityContext.authenticate("root","1234", new String[]{"USER"});
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
            Imetier metier = applicationContext.getBean(Imetier.class);
            System.out.println("************************************");
            System.out.println(metier.getClass().getName());
            System.out.println("************************************");
            metier.process();
            System.out.println(metier.compute());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
@Configuration
@ComponentScan(value = {"ma.enset"})
class MyConfig {

}
