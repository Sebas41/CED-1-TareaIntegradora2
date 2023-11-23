package model.structure.graph;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {
    private Vertex<T> from;
    private Vertex<T> to;
    private Double weight;

    public Edge(Vertex<T> from, Vertex<T> to){
        this.from = from;
        this.to = to;
    }

    public Edge(Vertex<T> from, Vertex<T> to, Double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public void setFrom(Vertex<T> from) {
        this.from = from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public void setTo(Vertex<T> to) {
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
