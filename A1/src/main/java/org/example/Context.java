package org.example;

public class Context {
    private Strategy strategy = new DefaultlStrategyImpl();
    public void effectuerOperation (){
//        System.out.println("*************** START **************");
        strategy.operationStrategy();
//        System.out.println("*************** END **************");

    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
