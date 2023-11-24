package com.example.ced1integradora2.model.structure.graph;

import com.example.ced1integradora2.model.structure.tree.NaryTree;
import com.example.ced1integradora2.model.template.IGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdjacencyMatrixGraph<T extends Comparable<T>> implements IGraph<T> {

    private Map<T, Integer> vertexesPositions;
    private ArrayList<Edge<T>> edges;
    private ArrayList<AdjacencyMatrixGraphVertex<T>> vertexes;
    private ArrayList<Double>[][] matrix;
    private int vertexNumber;
    private int currentVertexNumber;
    private boolean hasWeight;
    private boolean isDirected;

    public AdjacencyMatrixGraph(int vertexNumber, boolean hasWeight, boolean isDirected){
        this.vertexNumber = vertexNumber;
        this.vertexesPositions = new HashMap<>();
        this.edges = new ArrayList<>();
        this.vertexes = new ArrayList<>();
        this.hasWeight = hasWeight;
        this.isDirected = isDirected;
        this.currentVertexNumber = 0;

        matrix = new ArrayList[this.vertexNumber][this.vertexNumber];
        for(int i = 0; i<this.vertexNumber; i++){
            for(int j = 0; j<this.vertexNumber; j++){
                matrix[i][j] = new ArrayList<>();
            }
        }
    }
    
    @Override
    public boolean addVertex(T value) {
        boolean status = false;
        AdjacencyMatrixGraphVertex<T> existVertex = castVertex(value);

        if(existVertex==null){
            vertexes.add(new AdjacencyMatrixGraphVertex<>(value));
            vertexesPositions.put(value,currentVertexNumber++);
            status = true;
        }
        return status;
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
    public void dfsVisit(AdjacencyListGraphVertex<T> source, NaryTree<T> tree) {

    }

    @Override
    public GraphVertex<T> searchVertex(T goal) {
        AdjacencyMatrixGraphVertex<T> toReturn = null;
        for(AdjacencyMatrixGraphVertex<T> vertex : vertexes){
            if(vertex.getValue().compareTo(goal)==0){
                toReturn = vertex;
            }
        }
        return toReturn;
    }

    public AdjacencyMatrixGraphVertex<T> castVertex(T goal){
        return (AdjacencyMatrixGraphVertex<T>) searchVertex(goal);
    }

    @Override
    public Map<AdjacencyListGraphVertex<T>, Double> dijkstraDistances(T source) {
        return null;
    }

    @Override
    public Map<AdjacencyListGraphVertex<T>, AdjacencyListGraphVertex<T>> dijkstraPredecesors(T source) {
        return null;
    }

    @Override
    public Double[][] floydWarshall() {
        return new Double[0][];
    }

    @Override
    public NaryTree<AdjacencyListGraphVertex<T>> prim(T source) {
        return null;//No hacer nada
    }

    @Override
    public ArrayList<Edge<T>> kruskal() {
        return null;
    }
}
