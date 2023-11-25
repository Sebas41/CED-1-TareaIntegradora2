package com.example.ced1integradora2.model.structure.graph;

public class AdjacencyMatrixGraphVertex<T extends Comparable<T>> extends GraphVertex<T> implements Comparable<AdjacencyMatrixGraphVertex<T>>{

    public AdjacencyMatrixGraphVertex(T value){
        super(value);
    }

    @Override
    public int compareTo(AdjacencyMatrixGraphVertex<T> o) {
        return getValue().compareTo(o.getValue());
    }

    
}
