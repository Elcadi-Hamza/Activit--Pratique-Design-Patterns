package org.example;

public class DefaultStrategyImpl implements Strategy{
    @Override
    public void operationStrategy(){
        System.out.println(".........................................................");
        System.out.println("++++++++++++++++++ Strategy   (default) +++++++++++++++++");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
}
