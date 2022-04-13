package com.ariel.CreateExercises.Exercise_One.Exceptions;

public class NoEnoughMoneyException extends Exception{

    public NoEnoughMoneyException(){
        super("There is no money to pay it");
    }
}
