package com.example.ced1integradora2.model.structure.graph;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {
    private GraphVertex<T> from;
    private GraphVertex<T> to;
    private Double weight;

    public Edge(GraphVertex<T> from, GraphVertex<T> to){
        this.from = from;
        this.to = to;
    }

    public Edge(GraphVertex<T> from, GraphVertex<T> to, Double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public GraphVertex<T> getFrom() {
        return from;
    }

    public void setFrom(GraphVertex<T> from) {
        this.from = from;
    }

    public GraphVertex<T> getTo() {
        return to;
    }

    public void setTo(GraphVertex<T> to) {
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
