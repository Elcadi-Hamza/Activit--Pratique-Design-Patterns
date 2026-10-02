package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws Exception{
        Context context = new Context();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Quelle strategy ?");
            String str = sc.next();
            Strategy strategy = (Strategy) Class.forName("org.example.StrategyImpl"+str).newInstance();
            context.setStrategy(strategy);
            context.effectuerOperation();
        }
//        context.effectuerOperation();
//
//        context.setStrategy(new StrategyImpl1());
//        context.effectuerOperation();
//
//        context.setStrategy(new StrategyImpl2());
//        context.effectuerOperation();
//
//        context.setStrategy(new StrategyImpl3());
//        context.effectuerOperation();
    }
}
