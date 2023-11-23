package model.structure.graph;

import model.structure.tree.NaryTree;
import model.template.IGraph;

import java.util.ArrayList;
import java.util.Map;

public class AdjacencyMatrixGraph<T extends Comparable<T>> implements IGraph<T> {

    
    @Override
    public boolean addVertex(T t) {
        return false;
    }

    @Override
    public boolean addEdge(T source, T destination, Double weight) {
        return false;
    }

    @Override
    public boolean addEdge(T source, T destination) {
        return false;
    }

    @Override
    public boolean deleteVertex(T t) {
        return false;
    }

    @Override
    public boolean deleteEdge(T from, T to, Double weight) {
        return false;
    }

    @Override
    public boolean deleteEdge(T from, T to) {
        return false;
    }


    @Override
    public NaryTree<T> bfs(T source) {
        return null;
    }

    @Override
    public ArrayList<NaryTree<T>> dfs() {
        return null;
    }

    @Override
    public void dfsVisit(Vertex<T> source, NaryTree<T> tree) {

    }

    @Override
    public Vertex<T> searchVertex(T t) {
        return null;
    }

    @Override
    public Map<Vertex<T>, Double> dijkstraDistances(T source) {
        return null;
    }

    @Override
    public Map<Vertex<T>, Vertex<T>> dijkstraPredecesors(T source) {
        return null;
    }

    @Override
    public Double[][] floydWarshall() {
        return new Double[0][];
    }

    @Override
    public NaryTree<Vertex<T>> prim(T source) {
        return null;//No hacer nada
    }

    @Override
    public ArrayList<Edge<T>> kruskal() {
        return null;
    }
}
