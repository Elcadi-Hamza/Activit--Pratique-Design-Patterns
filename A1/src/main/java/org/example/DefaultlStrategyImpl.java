package org.example;

public class DefaultlStrategyImpl implements Strategy{
    @Override
    public void operationStrategy(){
        System.out.println(".........................................................");
        System.out.println("++++++++++++++++++ Strategy   (default) +++++++++++++++++");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
}
