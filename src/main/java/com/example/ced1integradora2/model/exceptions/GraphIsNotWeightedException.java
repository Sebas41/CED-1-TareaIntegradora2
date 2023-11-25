package com.example.ced1integradora2.model.exceptions;

public class GraphIsNotWeightedException extends RuntimeException{

    public GraphIsNotWeightedException(String message){
        super(message);
    }

    @Override
    public String toString(){
        return getMessage();
    }
}
