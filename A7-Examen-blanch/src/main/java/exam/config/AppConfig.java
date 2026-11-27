package exam.config;

import exam.NeuralNetwork;
import exam.aspects.LoggingAspect;
import exam.aspects.SecurityAspect;
import exam.observer.ObserverImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

    @Bean
    @Scope("prototype")
    public NeuralNetwork neuralNetwork() {
        return new NeuralNetwork();
    }

    @Bean
    public ObserverImpl observer() {
        return new ObserverImpl();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public SecurityAspect securityAspect() {
        return new SecurityAspect();
    }
}