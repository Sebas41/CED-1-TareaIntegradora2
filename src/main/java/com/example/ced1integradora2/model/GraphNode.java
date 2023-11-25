package com.example.ced1integradora2.model;

import java.util.List;

public class GraphNode <T extends Comparable<T>> {
    private T value;
    private List<GraphNode<T>> adjacentNodes;

    public GraphNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<GraphNode<T>> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<GraphNode<T>> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void removeAdjacentNode(GraphNode<T> node) {
        adjacentNodes.remove(node);
    }

    public boolean isAdjacent(Graph<T> node) {
        return adjacentNodes.contains(node);
    }
}
