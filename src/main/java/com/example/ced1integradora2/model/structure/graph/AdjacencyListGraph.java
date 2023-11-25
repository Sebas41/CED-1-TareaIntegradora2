package com.example.ced1integradora2.model.structure.graph;

import com.example.ced1integradora2.model.exceptions.GraphIsNotWeightedException;
import com.example.ced1integradora2.model.exceptions.GraphTypeNotAllowed;
import com.example.ced1integradora2.model.structure.tree.NaryTree;
import com.example.ced1integradora2.model.template.IGraph;

import java.util.*;

public class AdjacencyListGraph<T extends Comparable<T>> implements IGraph<T> {

    private ArrayList<AdjacencyListGraphVertex<T>> vertexes;
    private ArrayList<Edge<T>> edges;
    private boolean hasWeight;
    private boolean isDirected;

    public AdjacencyListGraph(boolean hasWeight, boolean isDirected){
        vertexes = new ArrayList<>();
        edges = new ArrayList<>();
        this.hasWeight = hasWeight;
        this.isDirected = isDirected;
    }

    @Override
    public boolean addVertex(T value) {
        boolean status = false;
        AdjacencyListGraphVertex<T> existVertex = castVertex(value);

        if(existVertex==null){
            vertexes.add(new AdjacencyListGraphVertex<T>(value));
            status = true;
        }

        return status;
    }

    @Override
    public boolean addEdge(T source, T destination, Double weight) {
        boolean status = false;

        if(hasWeight){
            AdjacencyListGraphVertex<T> referenceSource = castVertex(source);
            AdjacencyListGraphVertex<T> referenceDestination = castVertex(destination);

            if(referenceSource!=null && referenceDestination!=null){
                Edge<T> edge = new Edge<>(referenceSource,referenceDestination,weight);
                status = referenceSource.addEdge(edge);
                if(status){
                    edges.add(edge);
                }
                if(!isDirected){
                    Edge<T> edge1 = new Edge<>(referenceDestination,referenceSource,weight);
                    status = referenceSource.addEdge(edge1);
                    if(status){
                        edges.add(edge);
                    }
                }
            }
        }

        return status;
    }

    @Override
    public boolean addEdge(T source, T destination) {
        boolean status = false;
        AdjacencyListGraphVertex<T> referenceSource = castVertex(source);
        AdjacencyListGraphVertex<T> referenceDestination = castVertex(destination);

        if(referenceSource!=null && referenceDestination!=null){
            if(hasWeight){
                Edge<T> edge = new Edge<>(referenceSource,referenceDestination,0.0);
                status = referenceSource.addEdge(edge);
                if(status){
                    edges.add(edge);
                }
                if(!isDirected){
                    Edge<T> edge1 = new Edge<>(referenceDestination,referenceSource,0.0);
                    status = referenceSource.addEdge(edge1);
                    if(status){
                        edges.add(edge);
                    }
                }
            }else{
                Edge<T> edge = new Edge<>(referenceSource,referenceDestination);
                status = referenceSource.addEdge(edge);
                if(status){
                    edges.add(edge);
                }
                if(!isDirected){
                    Edge<T> edge1 = new Edge<>(referenceDestination,referenceSource);
                    status = referenceSource.addEdge(edge1);
                    if(status){
                        edges.add(edge);
                    }
                }
            }
        }

        return status;
    }

    @Override
    public boolean deleteVertex(T goal) {
        boolean status = false;

        AdjacencyListGraphVertex<T> vertex = castVertex(goal);

        if(vertexes.contains(vertex)){
            ArrayList<Edge<T>> edgesTemp = vertexes.get(vertexes.indexOf(vertex)).getEdges();
            edges.removeAll(edgesTemp);
            for(Edge<T> edge : edges){
                if(edge.getTo().equals(vertex)){
                    ((AdjacencyListGraphVertex<T>) edge.getFrom()).deleteEdge(edge);
                    edges.remove(edge);
                }
            }
            vertexes.remove(vertex);
            status = true;
        }

        return status;
    }

    @Override
    public boolean deleteEdge(T from, T to, Double weight){
        boolean status = false;

        if(hasWeight){
            AdjacencyListGraphVertex<T> fromVertex = castVertex(from);
            AdjacencyListGraphVertex<T> toVertex = castVertex(to);
            Edge<T> edge = searchEdge(fromVertex,toVertex,weight);
            status = edges.remove(edge);
            if(status){
                status = fromVertex.deleteEdge(edge);
            }
            if(!isDirected){
                Edge<T> edge1 = searchEdge(toVertex,fromVertex,weight);
                status = edges.remove(edge);
                if(status){
                    status = toVertex.deleteEdge(edge1);
                }
            }
        }

        return status;
    }

    public Edge<T> searchEdge(AdjacencyListGraphVertex<T> fromVertex, AdjacencyListGraphVertex<T> toVertex, Double weight){
        for(Edge<T> edge : edges){
            if(edge.getFrom().equals(fromVertex) && edge.getTo().equals(toVertex) && edge.getWeight().equals(weight)){
                return edge;
            }
        }
        return null;
    }

    public Edge<T> searchEdge(AdjacencyListGraphVertex<T> fromVertex, AdjacencyListGraphVertex<T> toVertex){
        for(Edge<T> edge : edges){
            if(edge.getFrom().equals(fromVertex) && edge.getTo().equals(toVertex)){
                return edge;
            }
        }
        return null;
    }

    @Override
    public boolean deleteEdge(T from, T to){
        boolean status = false;
        AdjacencyListGraphVertex<T> fromVertex = castVertex(from);
        AdjacencyListGraphVertex<T> toVertex = castVertex(to);
        Edge<T> edge;

        if(hasWeight){
            edge = searchEdge(fromVertex,toVertex,0.0);
            status = edges.remove(edge);
            if(status){
                status = fromVertex.deleteEdge(edge);
            }
            if(!isDirected){
                Edge<T> edge1 = searchEdge(toVertex,fromVertex,0.0);
                status = edges.remove(edge);
                if(status){
                    status = toVertex.deleteEdge(edge1);
                }
            }
        }else{
            edge = searchEdge(fromVertex,toVertex);
            status = edges.remove(edge);
            if(status){
                status = fromVertex.deleteEdge(edge);
            }
            if(!isDirected){
                Edge<T> edge1 = searchEdge(toVertex,fromVertex);
                status = edges.remove(edge);
                if(status){
                    status = toVertex.deleteEdge(edge1);
                }
            }
        }

        return status;
    }

    @Override
    public NaryTree<T> bfs(T source) {
        AdjacencyListGraphVertex<T> referenceSource = castVertex(source);
        NaryTree<T> naryTree = new NaryTree<>();

        if(referenceSource!=null){
            for(AdjacencyListGraphVertex<T> vertex : vertexes){
                if(vertex!=referenceSource){
                    vertex.setColorType(ColorType.WHITE);
                    vertex.setDistance(Double.MAX_VALUE);
                    vertex.setPredecesor(null);
                }
                referenceSource.setColorType(ColorType.GRAY);
                referenceSource.setDistance(0.0);
                referenceSource.setPredecesor(null);
                Queue<AdjacencyListGraphVertex<T>> queue = new LinkedList<>();
                queue.offer(referenceSource);
                naryTree.add(referenceSource.getValue(), null);
                while (!queue.isEmpty()){
                    AdjacencyListGraphVertex<T> temp = queue.poll();
                    for(int i = 0; i<temp.getEdges().size(); i++){
                        if(temp.getEdges().get(i).getTo().getColorType().equals(ColorType.WHITE)){
                            temp.getEdges().get(i).getTo().setColorType(ColorType.GRAY);
                            temp.getEdges().get(i).getTo().setDistance(temp.getEdges().get(i).getTo().getDistance()+1);
                            temp.getEdges().get(i).getTo().setPredecesor(temp);
                            naryTree.add(temp.getValue(),vertex.getPredecesor().getValue() );
                            queue.offer((AdjacencyListGraphVertex<T>) temp.getEdges().get(i).getTo());
                        }
                    }
                    temp.setColorType(ColorType.BLACK);
                }
            }
        }
        //se puede soltar una excepción


        return naryTree;
    }

    @Override
    public ArrayList<NaryTree<T>> dfs() {
        for (AdjacencyListGraphVertex<T> vertex: vertexes){
            vertex.setColorType(ColorType.WHITE);
            vertex.setPredecesor(null);
        }

        ArrayList<NaryTree<T>> forest = new ArrayList<>();

        for (AdjacencyListGraphVertex<T> vertex: vertexes){
            if (vertex.getColorType().equals(ColorType.WHITE)){
                NaryTree<T> tree = new NaryTree<>();
                dfsVisit(vertex, tree);
                forest.add(tree);
            }
        }

        return forest;
    }

    @Override
    public void dfsVisit(GraphVertex<T> source, NaryTree<T> tree) {
        source.setColorType(ColorType.GRAY);
        T temp = null;
        if(source.getPredecesor() != null) {
            temp = source.getPredecesor().getValue();
        }
        tree.add(source.getValue(), temp);
        for(Edge<T> edge : ((AdjacencyListGraphVertex<T>)source).getEdges()){
            if(edge.getTo().getColorType().equals(ColorType.WHITE)){
                edge.getTo().setPredecesor(source);
                dfsVisit(edge.getTo(),tree);
            }
        }
        source.setColorType(ColorType.BLACK);
    }

    @Override
    public GraphVertex<T> searchVertex(T goal) {
        AdjacencyListGraphVertex<T> toReturn = null;
        for(AdjacencyListGraphVertex<T> vertex : vertexes){
            if(vertex.getValue().compareTo(goal)==0){
                toReturn = vertex;
            }
        }
        return toReturn;
    }

    public AdjacencyListGraphVertex<T> castVertex(T goal){
        return (AdjacencyListGraphVertex<T>) searchVertex(goal);
    }

    @Override
    public  Map<GraphVertex<T>,Double> dijkstraDistances(T source) throws GraphIsNotWeightedException {
        if(hasWeight){
            AdjacencyListGraphVertex<T> referenceSource = castVertex(source);

            Map<GraphVertex<T>, Double> distances = new HashMap<>();
            Set<AdjacencyListGraphVertex<T>> visited = new HashSet<>();
            PriorityQueue<AdjacencyListGraphVertex<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

            distances.put(referenceSource,0.0);
            for(AdjacencyListGraphVertex<T> vertex : vertexes){
                if(vertex!=referenceSource){
                    distances.put(vertex,Double.MAX_VALUE);
                }
                priorityQueue.add(vertex);
            }

            while(!priorityQueue.isEmpty()){
                AdjacencyListGraphVertex<T> temp = priorityQueue.poll();
                visited.add(temp);
                for(Edge<T> edge : temp.getEdges()){
                    AdjacencyListGraphVertex<T> adjacency = (AdjacencyListGraphVertex<T>) edge.getTo();
                    if(!visited.contains(adjacency)){
                        Double alt = distances.get(temp) + edge.getWeight();
                        if(alt<distances.get(adjacency)){
                            distances.replace(adjacency,alt);

                            priorityQueue.remove(adjacency);
                            priorityQueue.offer(adjacency);
                        }
                    }
                }
            }

            return distances;
        }else{
            throw new GraphIsNotWeightedException("The graph is not weight");
        }
    }

    @Override
    public  Map<GraphVertex<T>, GraphVertex<T>> dijkstraPredecesors(T source) throws GraphIsNotWeightedException {
        if(hasWeight){
            AdjacencyListGraphVertex<T> referenceSource = castVertex(source);

            Map<AdjacencyListGraphVertex<T>, Double> distances = new HashMap<>();
            Map<GraphVertex<T>, GraphVertex<T>> previous = new HashMap<>();
            Set<AdjacencyListGraphVertex<T>> visited = new HashSet<>();
            PriorityQueue<AdjacencyListGraphVertex<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

            distances.put(referenceSource,0.0);
            for(AdjacencyListGraphVertex<T> vertex : vertexes){
                if(vertex!=referenceSource){
                    distances.put(vertex,Double.MAX_VALUE);
                }
                previous.put(vertex,null);
                priorityQueue.add(vertex);
            }

            while(!priorityQueue.isEmpty()){
                AdjacencyListGraphVertex<T> temp = priorityQueue.poll();
                visited.add(temp);
                for(Edge<T> edge : temp.getEdges()){
                    AdjacencyListGraphVertex<T> adjacency = (AdjacencyListGraphVertex<T>) edge.getTo();
                    if(!visited.contains(adjacency)){
                        Double alt = distances.get(temp) + edge.getWeight();
                        if(alt<distances.get(adjacency)){
                            distances.replace(adjacency,alt);
                            previous.replace(adjacency,temp);

                            priorityQueue.remove(adjacency);
                            priorityQueue.offer(adjacency);
                        }
                    }
                }
            }

            return previous;
        }else{
            throw new GraphIsNotWeightedException("The graph is not weight");
        }
    }

    @Override
    public Double[][] floydWarshall() throws GraphIsNotWeightedException {

        if(hasWeight){
            int length = vertexes.size();
            Double[][] distances = new Double[length][length];

            for(int i = 0; i<length; i++){
                for(int j = 0; j<length; j++){
                    if(i==j){
                        distances[i][j] = 0.0;
                    }else{
                        distances[i][j] = Double.MAX_VALUE;
                    }
                }
            }

            for (int i = 0; i < length; i++) {
                AdjacencyListGraphVertex<T> sourceVertex = vertexes.get(i);
                for (Edge<T> edge : sourceVertex.getEdges()) {
                    AdjacencyListGraphVertex<T> destVertex = (AdjacencyListGraphVertex<T>) edge.getTo();
                    int destIndex = vertexes.indexOf(destVertex);
                    distances[i][destIndex] = edge.getWeight();
                }
            }

            for(int k = 0; k<length; k++){
                for(int i = 0; i<length; i++){
                    for(int j = 0; j<length; j++){
                        if(distances[i][j]>distances[i][k]+distances[k][j]){
                            distances[i][j]=distances[i][k]+distances[k][j];
                        }
                    }
                }
            }

            return distances;
        }else{
            throw new GraphIsNotWeightedException("The graph is not weighted");
        }
    }

    public NaryTree<AdjacencyListGraphVertex<T>> prim(T source) throws GraphIsNotWeightedException, GraphTypeNotAllowed{

        if(!isDirected){
            if(hasWeight){
                AdjacencyListGraphVertex<T> referenceSource = castVertex(source);
                NaryTree<AdjacencyListGraphVertex<T>> naryTree = new NaryTree<>();

                if(referenceSource!=null){
                    for(AdjacencyListGraphVertex<T> vertex : vertexes){
                        vertex.setDistance(Double.MAX_VALUE);
                        vertex.setColorType(ColorType.WHITE);
                    }
                    referenceSource.setDistance(0.0);
                    referenceSource.setPredecesor(null);

                    PriorityQueue<AdjacencyListGraphVertex<T>> priorityQueue = new PriorityQueue<>(vertexes);

                    while(!priorityQueue.isEmpty()){
                        AdjacencyListGraphVertex<T> u = priorityQueue.poll();

                        for(Edge<T> edge : u.getEdges()){
                            if(edge.getTo().getColorType().equals(ColorType.WHITE) && edge.getWeight()<edge.getTo().getDistance()){
                                edge.getTo().setDistance(edge.getWeight());
                                edge.getTo().setPredecesor(u);
                                priorityQueue = new PriorityQueue<>(priorityQueue);
                            }
                        }
                        u.setColorType(ColorType.BLACK);
                        naryTree.add((AdjacencyListGraphVertex<T>) u.getPredecesor(),u);
                    }
                }
                return naryTree;
            }else{
                throw new GraphIsNotWeightedException("The graph is not weighted");
            }
        }else{
            throw new GraphTypeNotAllowed("The graph is directed");
        }
    }

    @Override
    public ArrayList<Edge<T>> kruskal() throws GraphIsNotWeightedException, GraphTypeNotAllowed{

        if(!isDirected){
            if(hasWeight){
                ArrayList<Edge<T>> array = new ArrayList<>();
                UnionFind unionFind = new UnionFind();
                for(Edge<T> edge : edges){
                    unionFind.makeSet(edge.getFrom().getValue());
                    unionFind.makeSet(edge.getTo().getValue());
                }

                edges.sort(Edge::compareTo);

                for(Edge<T> edge : edges){
                    AdjacencyListGraphVertex<T> u = (AdjacencyListGraphVertex<T>) edge.getFrom();
                    AdjacencyListGraphVertex<T> v = (AdjacencyListGraphVertex<T>) edge.getTo();
                    if(unionFind.find(u.getValue())!=unionFind.find(v.getValue())){
                        array.add(edge);
                        unionFind.union(u.getValue(),v.getValue());
                    }
                }
                return array;
            }else{
                throw new GraphIsNotWeightedException("The graph is not weighted");
            }
        }else{
            throw new GraphTypeNotAllowed("The graph is directed");
        }
    }

    public ArrayList<AdjacencyListGraphVertex<T>> getVertexes() {
        return vertexes;
    }

    public void setVertexes(ArrayList<AdjacencyListGraphVertex<T>> vertexes) {
        this.vertexes = vertexes;
    }

    public boolean getHasWeight() {
        return hasWeight;
    }

    public void setHasWeight(boolean hasWeight) {
        this.hasWeight = hasWeight;
    }

    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge<T>> edges) {
        this.edges = edges;
    }
}
