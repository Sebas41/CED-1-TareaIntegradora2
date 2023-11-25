package com.example.ced1integradora2.model.template;

import com.example.ced1integradora2.model.Position;
import com.example.ced1integradora2.model.structure.graph.AdjacencyMatrixGraphVertex;
import com.example.ced1integradora2.model.structure.graph.Edge;
import com.example.ced1integradora2.model.structure.graph.AdjacencyListGraphVertex;
import com.example.ced1integradora2.model.structure.graph.GraphVertex;
import com.example.ced1integradora2.model.structure.tree.NaryTree;

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
    public GraphVertex<T> searchVertex(T goal);
    public NaryTree<T> bfs(T source);
    public ArrayList<NaryTree<T>> dfs();
    public void dfsVisit(GraphVertex<T> source, NaryTree<T> tree);
    public Map<GraphVertex<T>,Double> dijkstraDistances(T source);
    public Map<GraphVertex<T>, GraphVertex<T>> dijkstraPredecesors(T source);
    public Double[][] floydWarshall();//El tamaño del grafo lo tengo dentro de la implementación
    //public NaryTree<GraphVertex<T>> prim(T source);
    public ArrayList<Edge<T>> kruskal();//fijarse en matriz de adyacencia
}
