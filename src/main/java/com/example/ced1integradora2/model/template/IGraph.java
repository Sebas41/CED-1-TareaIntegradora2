package model.template;

import model.structure.graph.Edge;
import model.structure.graph.Vertex;
import model.structure.tree.NaryTree;

import java.util.ArrayList;
import java.util.Map;

public interface IGraph<T extends Comparable<T>> {
    /*Verificar si son los métodos necesarios (obviamente faltan más)*/
    public boolean addVertex(T t);
    public boolean addEdge(T source, T destination, Double weight);
    public boolean addEdge(T source, T destination);
    public boolean deleteVertex(T t);
    public boolean deleteEdge(T from, T to, Double weight);
    public boolean deleteEdge(T from, T to);
    public NaryTree<T> bfs(T source);
    public ArrayList<NaryTree<T>> dfs();
    public void dfsVisit(Vertex<T> source, NaryTree<T> tree);
    public Vertex<T> searchVertex(T t);
    public Map<Vertex<T>,Double> dijkstraDistances(T source);
    public Map<Vertex<T>,Vertex<T>> dijkstraPredecesors(T source);
    public Double[][] floydWarshall();//El tamaño del grafo lo tengo dentro de la implementación
    public NaryTree<Vertex<T>> prim(T source);
    public ArrayList<Edge<T>> kruskal();
}
