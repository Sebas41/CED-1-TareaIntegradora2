package com.example.ced1integradora2.model.structure.graph;

import com.example.ced1integradora2.model.exceptions.GraphIsNotWeightedException;
import com.example.ced1integradora2.model.exceptions.GraphOutOfBoundException;
import com.example.ced1integradora2.model.exceptions.GraphTypeNotAllowed;
import com.example.ced1integradora2.model.structure.tree.NaryTree;
import com.example.ced1integradora2.model.template.IGraph;

import java.util.*;

public class AdjacencyMatrixGraph<T extends Comparable<T>> implements IGraph<T> {

    private Map<AdjacencyMatrixGraphVertex<T>, Integer> vertexesPositions;
    private ArrayList<Edge<T>> edges;
    private ArrayList<AdjacencyMatrixGraphVertex<T>> vertexes;
    private ArrayList<Double>[][] matrix;
    private int vertexNumber;
    private PriorityQueue<Integer> availableNumbers;
    private boolean hasWeight;
    private boolean isDirected;

    public AdjacencyMatrixGraph(int vertexNumber, boolean hasWeight, boolean isDirected){
        this.vertexNumber = vertexNumber;
        this.vertexesPositions = new HashMap<>();
        this.edges = new ArrayList<>();
        this.vertexes = new ArrayList<>();
        this.hasWeight = hasWeight;
        this.isDirected = isDirected;
        availableNumbers = new PriorityQueue<>();

        matrix = new ArrayList[this.vertexNumber][this.vertexNumber];
        for(int i = 0; i<this.vertexNumber; i++){
            for(int j = 0; j<this.vertexNumber; j++){
                matrix[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i<this.vertexNumber; i++){
            availableNumbers.offer(i);
        }
    }
    
    @Override
    public boolean addVertex(T value) throws GraphOutOfBoundException{
        boolean status = false;
        AdjacencyMatrixGraphVertex<T> existVertex = castVertex(value);

        if(existVertex==null){
            if(!availableNumbers.isEmpty()){
                AdjacencyMatrixGraphVertex<T> temp = new AdjacencyMatrixGraphVertex<>(value);
                vertexes.add(temp);
                vertexesPositions.put(temp,availableNumbers.poll());
                status = true;
            }else{
                throw new GraphOutOfBoundException("The graph is full");
            }
        }
        return status;
    }

    @Override
    public boolean addEdge(T source, T destination, Double weight) {
        boolean status = false;

        AdjacencyMatrixGraphVertex<T> vertexSource = castVertex(source);
        AdjacencyMatrixGraphVertex<T> vertexDestination = castVertex(source);

        if(hasWeight){
            if(vertexSource!=null && vertexDestination!=null){
                if(!matrix[vertexesPositions.get(vertexSource)][vertexesPositions.get(vertexDestination)].contains(weight)){
                    status = matrix[vertexesPositions.get(vertexSource)][vertexesPositions.get(vertexDestination)].add(weight);
                    edges.add(new Edge<T>(vertexSource,vertexDestination,weight));
                }
                if(!isDirected){
                    status = matrix[vertexesPositions.get(vertexDestination)][vertexesPositions.get(vertexSource)].add(weight);
                    edges.add(new Edge<T>(vertexDestination,vertexSource,weight));
                }
            }
        }

        return status;
    }

    @Override
    public boolean addEdge(T source, T destination) {
        boolean status = false;

        AdjacencyMatrixGraphVertex<T> vertexSource = castVertex(source);
        AdjacencyMatrixGraphVertex<T> vertexDestination = castVertex(destination);

        if(hasWeight){
            if(vertexSource!=null && vertexDestination!=null){
                if(!matrix[vertexesPositions.get(vertexSource)][vertexesPositions.get(vertexDestination)].contains(0.0)){
                    status = matrix[vertexesPositions.get(vertexSource)][vertexesPositions.get(vertexDestination)].add(0.0);
                    edges.add(new Edge<T>(vertexSource,vertexDestination,0.0));
                }
                if(!isDirected){
                    status = matrix[vertexesPositions.get(vertexDestination)][vertexesPositions.get(vertexSource)].add(0.0);
                    edges.add(new Edge<T>(vertexDestination,vertexSource,0.0));
                }
            }
        }else{
            if(vertexSource!=null && vertexDestination!=null){
                if(matrix[vertexesPositions.get(vertexSource)][vertexesPositions.get(vertexDestination)].isEmpty()){
                    status = matrix[vertexesPositions.get(vertexSource)][vertexesPositions.get(vertexDestination)].add(1.0);
                    edges.add(new Edge<T>(vertexSource,vertexDestination,1.0));
                    Collections.sort(matrix[vertexesPositions.get(vertexSource)][vertexesPositions.get(vertexDestination)]);
                }
                if(!isDirected){
                    status = matrix[vertexesPositions.get(vertexDestination)][vertexesPositions.get(vertexSource)].add(1.0);
                    edges.add(new Edge<T>(vertexDestination,vertexSource,1.0));
                    Collections.sort(matrix[vertexesPositions.get(vertexDestination)][vertexesPositions.get(vertexSource)]);
                }
            }
        }

        return status;
    }

    @Override
    public boolean deleteVertex(T goal) {
        boolean status = false;

        AdjacencyMatrixGraphVertex<T> temp = castVertex(goal);

        if(temp!=null){
            int positionTemp = vertexesPositions.get(temp);
            for(int i = 0; i<vertexNumber; i++){
                matrix[positionTemp][i].clear();
                matrix[i][positionTemp].clear();
            }
            ArrayList<Edge<T>> edgesToRemove = new ArrayList<>();
            for(Edge<T> edge : edges){
                if(edge.getFrom()==temp || edge.getTo()==temp){
                    edgesToRemove.add(edge);
                }
            }
            edges.removeAll(edgesToRemove);
            vertexesPositions.remove(temp);
            availableNumbers.offer(positionTemp);
            vertexes.remove(temp);
            status = true;
        }
        return status;
    }

    @Override
    public boolean deleteEdge(T from, T to, Double weight) {
        boolean status = false;

        AdjacencyMatrixGraphVertex<T> vertexFrom = castVertex(from);
        AdjacencyMatrixGraphVertex<T> vertexTo = castVertex(to);

        if(hasWeight){
            if(vertexFrom!=null && vertexTo!=null){
                int fromIndex = vertexesPositions.get(vertexFrom);
                int toIndex = vertexesPositions.get(vertexTo);
                status = matrix[fromIndex][toIndex].remove(weight);
                if(status){
                    Edge<T> temp1 = searchEdge(vertexFrom,vertexTo,weight);
                    edges.remove(temp1);
                }
                if(!isDirected){
                    status &= matrix[toIndex][fromIndex].remove(weight);
                    if(status){
                        Edge<T> temp2 = searchEdge(vertexTo,vertexFrom,weight);
                        edges.remove(temp2);
                    }
                }
            }
        }

        return status;
    }

    public Edge<T> searchEdge(AdjacencyMatrixGraphVertex<T> fromVertex, AdjacencyMatrixGraphVertex<T> toVertex, Double weight){
        for(Edge<T> edge : edges){
            if(edge.getFrom().equals(fromVertex) && edge.getTo().equals(toVertex) && edge.getWeight().equals(weight)){
                return edge;
            }
        }
        return null;
    }

    @Override
    public boolean deleteEdge(T from, T to) {
        boolean status = false;

        AdjacencyMatrixGraphVertex<T> vertexFrom = castVertex(from);
        AdjacencyMatrixGraphVertex<T> vertexTo = castVertex(to);

        if(hasWeight){
            if(vertexFrom!=null && vertexTo!=null){
                status = matrix[vertexesPositions.get(vertexFrom)][vertexesPositions.get(vertexTo)].remove(0.0);
                if(status) edges.remove(searchEdge(vertexFrom,vertexTo,0.0));
                if(!isDirected){
                    status = matrix[vertexesPositions.get(vertexTo)][vertexesPositions.get(vertexFrom)].remove(0.0);
                    if(status) edges.remove(searchEdge(vertexTo,vertexFrom,0.0));
                }
            }
        }else{
            if(vertexFrom!=null && vertexTo!=null){
                status = matrix[vertexesPositions.get(vertexFrom)][vertexesPositions.get(vertexTo)].remove(1.0);
                if(status) edges.remove(searchEdge(vertexFrom,vertexTo,1.0));
                if(!isDirected){
                    status = matrix[vertexesPositions.get(vertexTo)][vertexesPositions.get(vertexFrom)].remove(1.0);
                    if(status) edges.remove(searchEdge(vertexTo,vertexFrom,0.0));
                }
            }
        }

        return status;
    }

    private boolean existConnection(AdjacencyMatrixGraphVertex<T> vertexFrom, AdjacencyMatrixGraphVertex<T> vertexTo){
        return matrix[vertexesPositions.get(vertexFrom)][vertexesPositions.get(vertexTo)].size()>0;
    }


    @Override
    public NaryTree<T> bfs(T source) {
        AdjacencyMatrixGraphVertex<T> referenceSource = castVertex(source);
        NaryTree<T> naryTree = new NaryTree<>();

        if(referenceSource!=null){
            for(AdjacencyMatrixGraphVertex<T> vertex : vertexes){
                if(vertex!=referenceSource){
                    vertex.setColorType(ColorType.WHITE);
                    vertex.setDistance(Double.MAX_VALUE);
                    vertex.setPredecesor(null);
                }
                referenceSource.setColorType(ColorType.GRAY);
                referenceSource.setDistance(0.0);
                referenceSource.setPredecesor(null);
                Queue<AdjacencyMatrixGraphVertex<T>> queue = new LinkedList<>();
                queue.offer(referenceSource);
                naryTree.add(referenceSource.getValue(), null);
                while (!queue.isEmpty()){
                    AdjacencyMatrixGraphVertex<T> temp = queue.poll();
                    for(AdjacencyMatrixGraphVertex<T> vertexTemp : vertexes){
                        if(existConnection(temp,vertexTemp) && vertexTemp.getColorType()== ColorType.WHITE){
                            vertexTemp.setColorType(ColorType.GRAY);
                            vertexTemp.setDistance(temp.getDistance()+1);
                            vertexTemp.setPredecesor(temp);
                            queue.offer(vertexTemp);

                            naryTree.add(temp.getValue(),vertex.getPredecesor().getValue() );
                            queue.offer(vertexTemp);
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
        for (AdjacencyMatrixGraphVertex<T> vertex: vertexes){
            vertex.setColorType(ColorType.WHITE);
            vertex.setPredecesor(null);
        }

        ArrayList<NaryTree<T>> forest = new ArrayList<>();

        for (AdjacencyMatrixGraphVertex<T> vertex: vertexes){
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
        AdjacencyMatrixGraphVertex<T> temp;
        if(source.getPredecesor() != null) {
            temp = (AdjacencyMatrixGraphVertex<T>)source.getPredecesor();
        }else{
            temp = null;
        }
        tree.add(source.getValue(), temp.getValue());
        for(AdjacencyMatrixGraphVertex<T> vertex : vertexes){
            if(existConnection(temp,vertex) && vertex.getColorType().equals(ColorType.WHITE)){
                vertex.setPredecesor(source);
                dfsVisit(vertex,tree);
            }
        }
        source.setColorType(ColorType.BLACK);
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
    public Map<GraphVertex<T>, Double> dijkstraDistances(T source) {
        if(hasWeight){
            AdjacencyMatrixGraphVertex<T> referenceSource = castVertex(source);

            Map<GraphVertex<T>, Double> distances = new HashMap<>();
            Set<AdjacencyMatrixGraphVertex<T>> visited = new HashSet<>();
            PriorityQueue<AdjacencyMatrixGraphVertex<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

            distances.put(referenceSource,0.0);
            for(AdjacencyMatrixGraphVertex<T> vertex : vertexes){
                if(vertex!=referenceSource){
                    distances.put(vertex,Double.MAX_VALUE);
                }
                priorityQueue.add(vertex);
            }

            while(!priorityQueue.isEmpty()){
                AdjacencyMatrixGraphVertex<T> temp = priorityQueue.poll();
                visited.add(temp);
                for(AdjacencyMatrixGraphVertex<T> vertexTemp : vertexes){
                    AdjacencyMatrixGraphVertex<T> adjacency = existConnection(temp,vertexTemp) ? vertexTemp : null;
                    if(!visited.contains(adjacency)){
                        Double alt = distances.get(temp) + matrix[vertexesPositions.get(temp)][vertexesPositions.get(vertexTemp)].get(0);
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
    public Map<GraphVertex<T>, GraphVertex<T>> dijkstraPredecesors(T source) {
        if(hasWeight){
            AdjacencyMatrixGraphVertex<T> referenceSource = castVertex(source);

            Map<AdjacencyMatrixGraphVertex<T>, Double> distances = new HashMap<>();
            Map<GraphVertex<T>, GraphVertex<T>> previous = new HashMap<>();
            Set<AdjacencyMatrixGraphVertex<T>> visited = new HashSet<>();
            PriorityQueue<AdjacencyMatrixGraphVertex<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

            distances.put(referenceSource,0.0);
            for(AdjacencyMatrixGraphVertex<T> vertex : vertexes){
                if(vertex!=referenceSource){
                    distances.put(vertex,Double.MAX_VALUE);
                }
                previous.put(vertex,null);
                priorityQueue.add(vertex);
            }

            while(!priorityQueue.isEmpty()){
                AdjacencyMatrixGraphVertex<T> temp = priorityQueue.poll();
                visited.add(temp);
                for(AdjacencyMatrixGraphVertex<T> vertexTemp : vertexes){
                    AdjacencyMatrixGraphVertex<T> adjacency = existConnection(temp,vertexTemp) ? vertexTemp : null;
                    if(!visited.contains(adjacency)){
                        Double alt = distances.get(temp) + matrix[vertexesPositions.get(temp)][vertexesPositions.get(vertexTemp)].get(0);
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
    public Double[][] floydWarshall() {
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
                AdjacencyMatrixGraphVertex<T> sourceVertex = vertexes.get(i);
                for(AdjacencyMatrixGraphVertex<T> vertexTemp : vertexes){
                    AdjacencyMatrixGraphVertex<T> adjacency = existConnection(sourceVertex,vertexTemp) ? vertexTemp : null;
                    if(adjacency!=null){
                        int destIndex = vertexes.indexOf(adjacency);
                        distances[i][destIndex] = matrix[vertexesPositions.get(sourceVertex)][vertexesPositions.get(vertexTemp)].get(0);
                    }
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

    public NaryTree<AdjacencyMatrixGraphVertex<T>> prim(T source) {
        if(!isDirected){
            if(hasWeight){
                AdjacencyMatrixGraphVertex<T> referenceSource = castVertex(source);
                NaryTree<AdjacencyMatrixGraphVertex<T>> naryTree = new NaryTree<>();

                if(referenceSource!=null){
                    for(AdjacencyMatrixGraphVertex<T> vertex : vertexes){
                        vertex.setDistance(Double.MAX_VALUE);
                        vertex.setColorType(ColorType.WHITE);
                    }
                    referenceSource.setDistance(0.0);
                    referenceSource.setPredecesor(null);

                    PriorityQueue<AdjacencyMatrixGraphVertex<T>> priorityQueue = new PriorityQueue<>(vertexes);

                    while(!priorityQueue.isEmpty()){
                        AdjacencyMatrixGraphVertex<T> u = priorityQueue.poll();

                        for(AdjacencyMatrixGraphVertex<T> vertexTemp : vertexes){
                            AdjacencyMatrixGraphVertex<T> adjacency = existConnection(u,vertexTemp) ? vertexTemp : null;

                            if(adjacency!=null){
                                if(adjacency.getColorType().equals(ColorType.WHITE) && matrix[vertexesPositions.get(u)][vertexesPositions.get(vertexTemp)].get(0)<adjacency.getDistance()){
                                    adjacency.setDistance(matrix[vertexesPositions.get(u)][vertexesPositions.get(vertexTemp)].get(0));
                                    adjacency.setPredecesor(u);
                                    priorityQueue = new PriorityQueue<>(priorityQueue);
                                }
                            }
                        }
                        u.setColorType(ColorType.BLACK);
                        naryTree.add((AdjacencyMatrixGraphVertex<T>) u.getPredecesor(),u);
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
    public ArrayList<Edge<T>> kruskal() {
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
                    AdjacencyMatrixGraphVertex<T> u = (AdjacencyMatrixGraphVertex<T>) edge.getFrom();
                    AdjacencyMatrixGraphVertex<T> v = (AdjacencyMatrixGraphVertex<T>) edge.getTo();
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

    public Map<AdjacencyMatrixGraphVertex<T>, Integer> getVertexesPositions() {
        return vertexesPositions;
    }

    public void setVertexesPositions(Map<AdjacencyMatrixGraphVertex<T>, Integer> vertexesPositions) {
        this.vertexesPositions = vertexesPositions;
    }

    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge<T>> edges) {
        this.edges = edges;
    }

    public ArrayList<AdjacencyMatrixGraphVertex<T>> getVertexes() {
        return vertexes;
    }

    public void setVertexes(ArrayList<AdjacencyMatrixGraphVertex<T>> vertexes) {
        this.vertexes = vertexes;
    }

    public ArrayList<Double>[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<Double>[][] matrix) {
        this.matrix = matrix;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public PriorityQueue<Integer> getAvailableNumbers() {
        return availableNumbers;
    }

    public void setAvailableNumbers(PriorityQueue<Integer> availableNumbers) {
        this.availableNumbers = availableNumbers;
    }

    public boolean getHasWeight() {
        return hasWeight;
    }

    public void setHasWeight(boolean hasWeight) {
        this.hasWeight = hasWeight;
    }

    public boolean getDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }
}
