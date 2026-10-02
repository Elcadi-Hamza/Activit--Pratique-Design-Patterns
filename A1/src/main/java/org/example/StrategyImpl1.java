package org.example;

public class StrategyImpl1 implements Strategy{
    @Override
    public void operationStrategy(){
        System.out.println(".........................................................");
        System.out.println("++++++++++++++++++ Strategy 1 (default) +++++++++++++++++");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
}
