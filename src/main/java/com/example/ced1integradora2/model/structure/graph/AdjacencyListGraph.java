package model.structure.graph;

import model.exceptions.GraphIsNotWeightedException;
import model.exceptions.GraphTypeNotAllowed;
import model.structure.tree.NaryTree;
import model.template.IGraph;

import java.util.*;

public class AdjacencyListGraph<T extends Comparable<T>> implements IGraph<T> {

    private ArrayList<Vertex<T>> vertexes;
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
        Vertex<T> existVertex = searchVertex(value);

        if(existVertex==null){
            vertexes.add(new Vertex<T>(value));
            status = true;
        }
        return status;
    }

    @Override
    public boolean addEdge(T source, T destination, Double weight) {
        boolean status = false;

        if(hasWeight){
            Vertex<T> referenceSource = searchVertex(source);
            Vertex<T> referenceDestination = searchVertex(destination);

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
        Vertex<T> referenceSource = searchVertex(source);
        Vertex<T> referenceDestination = searchVertex(destination);

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

        Vertex<T> vertex = searchVertex(goal);

        if(vertexes.contains(vertex)){
            ArrayList<Edge<T>> edgesTemp = vertexes.get(vertexes.indexOf(vertex)).getEdges();
            edges.removeAll(edgesTemp);
            for(Edge<T> edge : edges){
                if(edge.getTo().equals(vertex)){
                    edge.getFrom().deleteEdge(edge);
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
            Vertex<T> fromVertex = searchVertex(from);
            Vertex<T> toVertex = searchVertex(to);
            Edge<T> edge = new Edge<>(fromVertex,toVertex,weight);
            status = edges.remove(edge);
            if(status){
                status = fromVertex.deleteEdge(edge);
            }
            if(!isDirected){
                Edge<T> edge1 = new Edge<>(toVertex,fromVertex,weight);
                status = edges.remove(edge);
                if(status){
                    status = toVertex.deleteEdge(edge);
                }
            }
        }

        return status;
    }

    @Override
    public boolean deleteEdge(T from, T to){
        boolean status = false;
        Vertex<T> fromVertex = searchVertex(from);
        Vertex<T> toVertex = searchVertex(to);
        Edge<T> edge;

        if(hasWeight){
            edge = new Edge<>(fromVertex,toVertex,0.0);
            status = edges.remove(edge);
            if(status){
                status = fromVertex.deleteEdge(edge);
            }
            if(!isDirected){
                Edge<T> edge1 = new Edge<>(toVertex,fromVertex,0.0);
                status = edges.remove(edge);
                if(status){
                    status = toVertex.deleteEdge(edge);
                }
            }
        }else{
            edge = new Edge<>(fromVertex,toVertex);
            status = edges.remove(edge);
            if(status){
                status = fromVertex.deleteEdge(edge);
            }
            if(!isDirected){
                Edge<T> edge1 = new Edge<>(toVertex,fromVertex);
                status = edges.remove(edge);
                if(status){
                    status = toVertex.deleteEdge(edge);
                }
            }
        }

        return status;
    }

    @Override
    public NaryTree<T> bfs(T source) {
        Vertex<T> referenceSource = searchVertex(source);
        NaryTree<T> naryTree = new NaryTree<>();

        if(referenceSource!=null){
            for(Vertex<T> vertex : vertexes){
                if(vertex!=referenceSource){
                    vertex.setColorType(ColorType.WHITE);
                    vertex.setDistance(Double.MAX_VALUE);
                    vertex.setPredecesor(null);
                }
                referenceSource.setColorType(ColorType.GRAY);
                referenceSource.setDistance(0.0);
                referenceSource.setPredecesor(null);
                Queue<Vertex<T>> queue = new LinkedList<>();
                queue.offer(referenceSource);
                naryTree.add(referenceSource.getValue(), null);
                while (!queue.isEmpty()){
                    Vertex<T> temp = queue.poll();
                    for(int i = 0; i<temp.getEdges().size(); i++){
                        if(temp.getEdges().get(i).getTo().getColorType().equals(ColorType.WHITE)){
                            temp.getEdges().get(i).getTo().setColorType(ColorType.GRAY);
                            temp.getEdges().get(i).getTo().setDistance(temp.getEdges().get(i).getTo().getDistance()+1);
                            temp.getEdges().get(i).getTo().setPredecesor(temp);
                            naryTree.add(temp.getValue(),vertex.getPredecesor().getValue() );
                            queue.offer(temp.getEdges().get(i).getTo());
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
        for (Vertex<T> vertex: vertexes){
            vertex.setColorType(ColorType.WHITE);
            vertex.setPredecesor(null);
        }

        ArrayList<NaryTree<T>> forest = new ArrayList<>();

        for (Vertex<T> vertex: vertexes){
            if (vertex.getColorType().equals(ColorType.WHITE)){
                NaryTree<T> tree = new NaryTree<>();
                dfsVisit(vertex, tree);
                forest.add(tree);
            }
        }

        return forest;
    }

    @Override
    public void dfsVisit(Vertex<T> source, NaryTree<T> tree) {
        source.setColorType(ColorType.GRAY);
        T temp = null;
        if(source.getPredecesor() != null) {
            temp = source.getPredecesor().getValue();
        }
        tree.add(source.getValue(), temp);
        for(Edge<T> edge : source.getEdges()){
            if(edge.getTo().getColorType().equals(ColorType.WHITE)){
                edge.getTo().setPredecesor(source);
                dfsVisit(edge.getTo(),tree);
            }
        }
        source.setColorType(ColorType.BLACK);
    }

    @Override
    public Vertex<T> searchVertex(T goal) {
        Vertex<T> toReturn = null;
        for(Vertex<T> vertex : vertexes){
            if(vertex.getValue().compareTo(goal)==0){
                toReturn = vertex;
            }
        }
        return toReturn;
    }

    @Override
    public  Map<Vertex<T>,Double> dijkstraDistances(T source) throws GraphIsNotWeightedException {
        if(hasWeight){
            Vertex<T> referenceSource = searchVertex(source);

            Map<Vertex<T>, Double> distances = new HashMap<>();
            Set<Vertex<T>> visited = new HashSet<>();
            PriorityQueue<Vertex<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

            distances.put(referenceSource,0.0);
            for(Vertex<T> vertex : vertexes){
                if(vertex!=referenceSource){
                    distances.put(vertex,Double.MAX_VALUE);
                }
                priorityQueue.add(vertex);
            }

            while(!priorityQueue.isEmpty()){
                Vertex<T> temp = priorityQueue.poll();
                visited.add(temp);
                for(Edge<T> edge : temp.getEdges()){
                    Vertex<T> adjacency = edge.getTo();
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
    public  Map<Vertex<T>,Vertex<T>> dijkstraPredecesors(T source) throws GraphIsNotWeightedException {
        if(hasWeight){
            Vertex<T> referenceSource = searchVertex(source);

            Map<Vertex<T>, Double> distances = new HashMap<>();
            Map<Vertex<T>, Vertex<T>> previous = new HashMap<>();
            Set<Vertex<T>> visited = new HashSet<>();
            PriorityQueue<Vertex<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

            distances.put(referenceSource,0.0);
            for(Vertex<T> vertex : vertexes){
                if(vertex!=referenceSource){
                    distances.put(vertex,Double.MAX_VALUE);
                }
                previous.put(vertex,null);
                priorityQueue.add(vertex);
            }

            while(!priorityQueue.isEmpty()){
                Vertex<T> temp = priorityQueue.poll();
                visited.add(temp);
                for(Edge<T> edge : temp.getEdges()){
                    Vertex<T> adjacency = edge.getTo();
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
                Vertex<T> sourceVertex = vertexes.get(i);
                for (Edge<T> edge : sourceVertex.getEdges()) {
                    Vertex<T> destVertex = edge.getTo();
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

    @Override
    public NaryTree<Vertex<T>> prim(T source) throws GraphIsNotWeightedException, GraphTypeNotAllowed{

        if(!isDirected){
            if(hasWeight){
                Vertex<T> referenceSource = searchVertex(source);
                NaryTree<Vertex<T>> naryTree = new NaryTree<>();

                if(referenceSource!=null){
                    for(Vertex<T> vertex : vertexes){
                        vertex.setDistance(Double.MAX_VALUE);
                        vertex.setColorType(ColorType.WHITE);
                    }
                    referenceSource.setDistance(0.0);
                    referenceSource.setPredecesor(null);

                    PriorityQueue<Vertex<T>> priorityQueue = new PriorityQueue<>(vertexes);

                    while(!priorityQueue.isEmpty()){
                        Vertex<T> u = priorityQueue.poll();

                        for(Edge<T> edge : u.getEdges()){
                            if(edge.getTo().getColorType().equals(ColorType.WHITE) && edge.getWeight()<edge.getTo().getDistance()){
                                edge.getTo().setDistance(edge.getWeight());
                                edge.getTo().setPredecesor(u);
                                priorityQueue = new PriorityQueue<>(priorityQueue);
                            }
                        }
                        u.setColorType(ColorType.BLACK);
                        naryTree.add(u.getPredecesor(),u);
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
                    Vertex<T> u = edge.getFrom();
                    Vertex<T> v = edge.getTo();
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

    public ArrayList<Vertex<T>> getVertexes() {
        return vertexes;
    }

    public void setVertexes(ArrayList<Vertex<T>> vertexes) {
        this.vertexes = vertexes;
    }

    public boolean getHasWeight() {
        return hasWeight;
    }

    public void setHasWeight(boolean hasWeight) {
        this.hasWeight = hasWeight;
    }
}
