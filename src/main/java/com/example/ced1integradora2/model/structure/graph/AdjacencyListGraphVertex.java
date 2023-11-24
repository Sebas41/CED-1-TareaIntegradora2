package com.example.ced1integradora2.model.structure.graph;

import java.util.ArrayList;

public class AdjacencyListGraphVertex<T extends Comparable<T>> extends GraphVertex<T> implements Comparable<AdjacencyListGraphVertex<T>>{

    private ArrayList<Edge<T>> edges;

    public AdjacencyListGraphVertex(T value){
        super(value);
        edges = new ArrayList<>();
    }

    public boolean addEdge(Edge<T> edge){
        boolean status = false;
        if(!edges.contains(edge)){
            edges.add(edge);
            status = true;
        }
        return status;
    }

    public boolean deleteEdge(Edge<T> edge) {
        return edges.remove(edge);
    }

    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge<T>> edges) {
        this.edges = edges;
    }

    @Override
    public int compareTo(AdjacencyListGraphVertex<T> o) {
        return getValue().compareTo(o.getValue());
    }
}
