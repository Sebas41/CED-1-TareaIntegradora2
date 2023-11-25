package com.example.ced1integradora2.model;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class Graph<T extends Comparable<T>> {

    private List<GraphNode<T>> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(GraphNode<T> node) {
        nodes.add(node);
    }

    public void removeNode(GraphNode<T> node) {
        nodes.remove(node);
    }

    public boolean contains(GraphNode<T> node) {
        return nodes.contains(node);
    }

    public List<GraphNode<T>> getNodes() {
        return nodes;
    }

    public void setNodes(List<GraphNode<T>> nodes) {
        this.nodes = nodes;
    }
}