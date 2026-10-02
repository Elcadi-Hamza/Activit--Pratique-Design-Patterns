package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws Exception{
        Context context = new Context();
        Scanner sc = new Scanner(System.in);
        Map<String,Strategy> StrategyMap = new HashMap<>();
        Strategy strategy;
        while(true) {
            System.out.println("Quelle strategy ?");
            String str = sc.next();
            strategy=StrategyMap.get(str);
            if (strategy==null){
                strategy = (Strategy) Class.forName("org.example.StrategyImpl"+str).getConstructor().newInstance(); //avec constructeur avec parametre
                StrategyMap.put(str,strategy);
                System.out.println("New objet");
            }
//            Strategy strategy = (Strategy) Class.forName("org.example.StrategyImpl"+str).newInstance();
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
