package model.structure.graph;

import java.util.ArrayList;

public class Vertex <T extends Comparable<T>> implements Comparable<Vertex<T>>{

    private T value;
    private ArrayList<Edge<T>> edges;
    private Double distance;
    private Vertex<T> predecesor;
    private ColorType colorType;

    public Vertex(T value){
        this.value = value;
        edges = new ArrayList<>();
        colorType = ColorType.WHITE;
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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge<T>> edges) {
        this.edges = edges;
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

    public Vertex<T> getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(Vertex<T> predecesor) {
        this.predecesor = predecesor;
    }

    @Override
    public String toString(){
        return "Value: " + value;
    }

    @Override
    public int compareTo(Vertex<T> o) {
        return value.compareTo(o.getValue());
    }
}
