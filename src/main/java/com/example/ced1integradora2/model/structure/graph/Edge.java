package com.example.ced1integradora2.model.structure.graph;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {
    private AdjacencyListGraphVertex<T> from;
    private AdjacencyListGraphVertex<T> to;
    private Double weight;

    public Edge(AdjacencyListGraphVertex<T> from, AdjacencyListGraphVertex<T> to){
        this.from = from;
        this.to = to;
    }

    public Edge(AdjacencyListGraphVertex<T> from, AdjacencyListGraphVertex<T> to, Double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public AdjacencyListGraphVertex<T> getFrom() {
        return from;
    }

    public void setFrom(AdjacencyListGraphVertex<T> from) {
        this.from = from;
    }

    public AdjacencyListGraphVertex<T> getTo() {
        return to;
    }

    public void setTo(AdjacencyListGraphVertex<T> to) {
        this.to = to;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge<T> o) {
        return this.weight.compareTo(o.getWeight());
    }

    @Override
    public String toString(){
        return "" + weight;
    }
}
