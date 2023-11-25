package com.example.ced1integradora2.model;

public class State implements Comparable<State> {

    private String name;
    private Position position;

    public State(String name, Position position){
        this.name = name;
        this.position = position;
    }

    public String getName(){
        return this.name;
    }

    public Position getPosition(){
        return this.position;
    }

    @Override
    public int compareTo(State o) {
        return 0;
    }
}
