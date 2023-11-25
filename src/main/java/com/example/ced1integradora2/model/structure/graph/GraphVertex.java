package com.example.ced1integradora2.model.structure.graph;

import java.util.ArrayList;

public class GraphVertex<T extends Comparable<T>>{
    private T value;
    private Double distance;
    private GraphVertex<T> predecesor;
    private ColorType colorType;

    public GraphVertex(T value){
        this.value = value;
        colorType = ColorType.WHITE;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public GraphVertex<T> getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(GraphVertex<T> predecesor) {
        this.predecesor = predecesor;
    }

    @Override
    public String toString(){
        return "Value: " + value;
    }
}
