package com.example.ced1integradora2.tests;

import com.example.ced1integradora2.model.exceptions.GraphIsNotWeightedException;
import com.example.ced1integradora2.model.exceptions.GraphTypeNotAllowed;
import com.example.ced1integradora2.model.structure.graph.AdjacencyListGraph;
import com.example.ced1integradora2.model.structure.graph.AdjacencyListGraphVertex;
import com.example.ced1integradora2.model.structure.graph.Edge;
import com.example.ced1integradora2.model.structure.graph.GraphVertex;
import com.example.ced1integradora2.model.structure.tree.NaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class AdjacencyListGraphTest {

    private AdjacencyListGraph<Integer> graph1;

    public void setUpGraphWithoutWeightDirected(){
        graph1 = new AdjacencyListGraph<>(false,true);

        graph1.addVertex(1);
        graph1.addVertex(2);
        graph1.addVertex(3);
        graph1.addVertex(4);
        graph1.addVertex(5);
        graph1.addVertex(6);
        graph1.addVertex(7);
        graph1.addVertex(8);
        graph1.addVertex(9);
        graph1.addVertex(0);
        graph1.addEdge(1,2);
        graph1.addEdge(2,3);
        graph1.addEdge(5,4);
        graph1.addEdge(9,7);
        graph1.addEdge(0,6);
    }

    public void setUpGraphWithWeightDirected(){
        graph1 = new AdjacencyListGraph<>(true,true);

        graph1.addVertex(1);
        graph1.addVertex(2);
        graph1.addVertex(3);
        graph1.addVertex(4);
        graph1.addVertex(5);
        graph1.addVertex(6);
        graph1.addVertex(7);
        graph1.addVertex(8);
        graph1.addVertex(9);
        graph1.addVertex(0);
        graph1.addEdge(1,2,2.0);
        graph1.addEdge(2,3,5.0);
        graph1.addEdge(5,4,3.45);
        graph1.addEdge(9,7,1.0);
        graph1.addEdge(0,6,6.99);
    }

    public void setUpGraphWithWeightNotDirected(){
        graph1 = new AdjacencyListGraph<>(true,false);

        graph1.addVertex(1);
        graph1.addVertex(2);
        graph1.addVertex(3);
        graph1.addVertex(4);
        graph1.addVertex(5);
        graph1.addVertex(6);
        graph1.addVertex(7);
        graph1.addVertex(8);
        graph1.addVertex(9);
        graph1.addVertex(0);
        graph1.addEdge(1,2,2.0);
        graph1.addEdge(2,3,5.0);
        graph1.addEdge(5,4,3.45);
        graph1.addEdge(9,7,1.0);
        graph1.addEdge(0,6,6.99);
    }

    public void setUpGraphWithoutWeightNotDirected(){
        graph1 = new AdjacencyListGraph<>(false,false);

        graph1.addVertex(1);
        graph1.addVertex(2);
        graph1.addVertex(3);
        graph1.addVertex(4);
        graph1.addVertex(5);
        graph1.addVertex(6);
        graph1.addVertex(7);
        graph1.addVertex(8);
        graph1.addVertex(9);
        graph1.addVertex(0);
        graph1.addEdge(1,2);
        graph1.addEdge(2,3);
        graph1.addEdge(5,4);
        graph1.addEdge(9,7);
        graph1.addEdge(0,6);
    }

    //--------------------------------------------------------------------------------------------
    //Add vertexes to graph tests
    @Test
    public void addVertexToGraphWithWeightDirected(){
        setUpGraphWithWeightDirected();

        graph1.addVertex(14);
        assertEquals(11,graph1.getVertexes().size());
    }

    @Test
    public void addVertexToGraphWithWeightNotDirected(){
        setUpGraphWithWeightNotDirected();

        graph1.addVertex(14);
        assertEquals(11,graph1.getVertexes().size());
    }

    @Test
    public void addVertexToGraphWithoutWeightDirected(){
        setUpGraphWithoutWeightDirected();

        graph1.addVertex(14);
        assertEquals(11,graph1.getVertexes().size());
    }

    @Test
    public void addVertexToGraphWithoutWeightNotDirected(){
        setUpGraphWithoutWeightNotDirected();

        graph1.addVertex(14);
        assertEquals(11,graph1.getVertexes().size());
    }
    //--------------------------------------------------------------------------------------------
    //Add edges to graph tests
    @Test
    public void addEdgeToGraphWithWeightDirected(){
        setUpGraphWithWeightDirected();

        boolean status = graph1.addEdge(1,3, 7.77);
        assertTrue(status);
        assertEquals(6,graph1.getEdges().size());
    }

    @Test
    public void addEdgeToGraphWithWeightNotDirected(){
        setUpGraphWithWeightNotDirected();

        boolean status = graph1.addEdge(1,3, 7.77);
        assertTrue(status);
        assertEquals(12,graph1.getEdges().size());
    }

    @Test
    public void addEdgeToGraphWithoutWeightDirected(){
        setUpGraphWithoutWeightDirected();

        boolean status = graph1.addEdge(1,3, 7.77);
        assertFalse(status);
        status = graph1.addEdge(1,3);
        assertTrue(status);
        assertEquals(6,graph1.getEdges().size());
    }

    @Test
    public void addEdgeToGraphWithoutWeightNotDirected(){
        setUpGraphWithoutWeightNotDirected();

        boolean status = graph1.addEdge(1,3, 7.77);
        assertFalse(status);
        status = graph1.addEdge(1,3);
        assertTrue(status);
        assertEquals(12,graph1.getEdges().size());
    }
    //--------------------------------------------------------------------------------------------
    //Remove vertexes of graph tests
    @Test
    public void removeVertexOfGraphWithWeightDirected(){
        setUpGraphWithWeightDirected();

        boolean status = graph1.deleteVertex(14);
        assertFalse(status);
        status = graph1.deleteVertex(1);
        assertTrue(status);
        assertEquals(9,graph1.getVertexes().size());
        assertEquals(4,graph1.getEdges().size());
    }

    @Test
    public void removeVertexOfGraphWithWeightNotDirected(){
        setUpGraphWithWeightNotDirected();

        boolean status = graph1.deleteVertex(14);
        assertFalse(status);
        status = graph1.deleteVertex(1);
        assertTrue(status);
        assertEquals(9,graph1.getVertexes().size());
        assertEquals(8,graph1.getEdges().size());
    }

    @Test
    public void removeVertexOfGraphWithoutWeightDirected(){
        setUpGraphWithoutWeightDirected();

        boolean status = graph1.deleteVertex(14);
        assertFalse(status);
        status = graph1.deleteVertex(1);
        assertTrue(status);
        assertEquals(9,graph1.getVertexes().size());
        assertEquals(4,graph1.getEdges().size());
    }

    @Test
    public void removeVertexOfGraphWithoutWeightNotDirected(){
        setUpGraphWithoutWeightNotDirected();

        boolean status = graph1.deleteVertex(14);
        assertFalse(status);
        status = graph1.deleteVertex(1);
        assertTrue(status);
        assertEquals(9,graph1.getVertexes().size());
        assertEquals(8,graph1.getEdges().size());
    }
    //--------------------------------------------------------------------------------------------
    //Remove edges of graph tests
    @Test
    public void removeEdgeOfGraphWithWeightDirected(){
        setUpGraphWithWeightDirected();

        boolean status = graph1.deleteEdge(3,4,9.0);
        assertFalse(status);
        graph1.addEdge(3,4,12.2);
        assertEquals(6,graph1.getEdges().size());
        status = graph1.deleteEdge(3,4,12.2);
        assertTrue(status);
        assertEquals(10,graph1.getVertexes().size());
        assertEquals(5,graph1.getEdges().size());
    }

    @Test
    public void removeEdgeOfGraphWithWeightNotDirected(){
        setUpGraphWithWeightNotDirected();

        boolean status = graph1.deleteVertex(14);
        assertFalse(status);
        status = graph1.deleteVertex(1);
        assertTrue(status);
        assertEquals(9,graph1.getVertexes().size());
        assertEquals(8,graph1.getEdges().size());
    }

    @Test
    public void removeEdgeOfGraphWithoutWeightDirected(){
        setUpGraphWithoutWeightDirected();

        boolean status = graph1.deleteVertex(14);
        assertFalse(status);
        status = graph1.deleteVertex(1);
        assertTrue(status);
        assertEquals(9,graph1.getVertexes().size());
        assertEquals(4,graph1.getEdges().size());
    }

    @Test
    public void removeEdgeOfGraphWithoutWeightNotDirected(){
        setUpGraphWithoutWeightNotDirected();

        boolean status = graph1.deleteVertex(14);
        assertFalse(status);
        status = graph1.deleteVertex(1);
        assertTrue(status);
        assertEquals(9,graph1.getVertexes().size());
        assertEquals(8,graph1.getEdges().size());
    }

    // Returns a NaryTree object when given a valid source vertex
    @Test
    public void test_valid_source_vertex() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2, 1.0);

        NaryTree<Integer> result = graph.bfs(1);

        assertNotNull(result);
    }

    // Returns a NaryTree object with the correct structure when given a valid source vertex
    @Test
    public void test_valid_source_vertex_structure() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2, 1.0);

        NaryTree<Integer> result = graph.bfs(1);

        NaryTree<Integer> expected = new NaryTree<>();
        expected.add(1, null);
        expected.add(2, 1);

        assertEquals(expected, result);
    }

    // Returns a NaryTree object with the correct values when given a valid source vertex
    @Test
    public void test_valid_source_vertex_values() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2, 1.0);

        NaryTree<Integer> result = graph.bfs(1);

        NaryTree<Integer> expected = new NaryTree<>();
        expected.add(1, null);
        expected.add(2, 1);

        assertEquals(expected.getValue(2), result.getValue(2));
    }

    // Returns an empty NaryTree object when given a null source vertex
    @Test
    public void test_null_source_vertex() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2, 1.0);

        NaryTree<Integer> result = graph.bfs(null);

        assertTrue(result.isEmpty());
    }

    // Returns an empty NaryTree object when the graph is empty
    @Test
    public void test_empty_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);

        NaryTree<Integer> result = graph.bfs(1);

        assertTrue(result.isEmpty());
    }

    // Returns a NaryTree object with only the source vertex when the graph has no edges
    @Test
    public void test_no_edges() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);

        NaryTree<Integer> result = graph.bfs(1);

        NaryTree<Integer> expected = new NaryTree<>();
        expected.add(1, null);

        assertEquals(expected, result);
    }

    // Returns a list of NaryTrees representing the DFS forest of the graph
    @Test
    public void test_dfs_forest() {
        // Arrange
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        // Act
        ArrayList<NaryTree<Integer>> result = graph.dfs();

        // Assert
        assertEquals(1, result.size());
        NaryTree<Integer> tree = result.get(0);
        assertEquals(Optional.of(1), tree.getRoot().getValue());
        assertEquals(2, tree.getRoot().getChildren().size());
        assertEquals(Optional.of(2), tree.getRoot().getChildren().get(0).getValue());
        assertEquals(Optional.of(3), tree.getRoot().getChildren().get(0).getChildren().get(0).getValue());
    }

    // Returns an empty list when the graph is empty
    @Test
    public void test_dfs_emptyGraph() {
        // Arrange
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false, true);

        // Act
        ArrayList<NaryTree<Integer>> result = graph.dfs();

        // Assert
        assertTrue(result.isEmpty());
    }

    // Returns a list with a single tree when the graph is a single vertex
    @Test
    public void test_dfs_singleVertex() {
        // Arrange
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false, true);
        graph.addVertex(1);

        // Act
        ArrayList<NaryTree<Integer>> result = graph.dfs();

        // Assert
        assertEquals(1, result.size());
        NaryTree<Integer> tree = result.get(0);
        assertEquals(Optional.of(1), tree.getRoot().getValue());
        assertTrue(tree.getRoot().getChildren().isEmpty());
    }

    // Returns a list with a single tree when the graph is a single vertex with no edges
    @Test
    public void test_dfs_singleVertexNoEdges() {
        // Arrange
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false, true);
        graph.addVertex(1);

        // Act
        ArrayList<NaryTree<Integer>> result = graph.dfs();

        // Assert
        assertEquals(1, result.size());
        NaryTree<Integer> tree = result.get(0);
        assertEquals(Optional.of(1), tree.getRoot().getValue());
        assertTrue(tree.getRoot().getChildren().isEmpty());
    }

    // Returns a list with a single tree when the graph is a single connected component with no cycles
    @Test
    public void test_dfs_singleConnectedComponentNoCycles() {
        // Arrange
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        // Act
        ArrayList<NaryTree<Integer>> result = graph.dfs();

        // Assert
        assertEquals(1, result.size());
        NaryTree<Integer> tree = result.get(0);
        assertEquals(Optional.of(1), tree.getRoot().getValue());
        assertEquals(1, tree.getRoot().getChildren().size());
        assertEquals(Optional.of(2), tree.getRoot().getChildren().get(0).getValue());
        assertEquals(1, tree.getRoot().getChildren().get(0).getChildren().size());
        assertEquals(Optional.of(3), tree.getRoot().getChildren().get(0).getChildren().get(0).getValue());
    }

    // Returns a list with multiple trees when the graph is a single connected component with cycles
    @Test
    public void test_dfs_singleConnectedComponentWithCycles() {
        // Arrange
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        // Act
        ArrayList<NaryTree<Integer>> result = graph.dfs();

        // Assert
        assertEquals(1, result.size());
        NaryTree<Integer> tree = result.get(0);
        assertEquals(Optional.of(1), tree.getRoot().getValue());
        assertEquals(1, tree.getRoot().getChildren().size());
        assertEquals(Optional.of(2), tree.getRoot().getChildren().get(0).getValue());
        assertEquals(1, tree.getRoot().getChildren().get(0).getChildren().size());
        assertEquals(Optional.of(3), tree.getRoot().getChildren().get(0).getChildren().get(0).getValue());
    }

    // Returns a map with the shortest distances from the source vertex to all other vertices in the graph
    @Test
    public void test_returnsShortestDistancesFromSourceToAllVertices() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(1, 2, 1.0);
        graph.addEdge(1, 3, 2.0);
        graph.addEdge(2, 3, 1.0);
        graph.addEdge(2, 4, 3.0);
        graph.addEdge(3, 4, 1.0);

        Map<GraphVertex<Integer>, Double> distances = graph.dijkstraDistances(1);

        assertEquals(Optional.of(0.0), distances.get(new GraphVertex<>(1)));
        assertEquals(Optional.of(1.0), distances.get(new GraphVertex<>(2)));
        assertEquals(Optional.of(2.0), distances.get(new GraphVertex<>(3)));
        assertEquals(Optional.of(3.0), distances.get(new GraphVertex<>(4)));
    }

    // Returns a map with the shortest distances from the source vertex to all other vertices in the graph, when the graph has only one vertex
    @Test
    public void test_returnsShortestDistancesFromSourceToAllVerticesWithOneVertex() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);

        Map<GraphVertex<Integer>, Double> distances = graph.dijkstraDistances(1);

        assertEquals(Optional.of(0.0), distances.get(new GraphVertex<>(1)));
    }

    // Returns a map with the shortest distances from the source vertex to all other vertices in the graph, when the graph has only two vertices and one edge
    @Test
    public void test_returnsShortestDistancesFromSourceToAllVerticesWithTwoVerticesAndOneEdge() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2, 2.0);

        Map<GraphVertex<Integer>, Double> distances = graph.dijkstraDistances(1);

        assertEquals(Optional.of(0.0), distances.get(new GraphVertex<>(1)));
        assertEquals(Optional.of(2.0), distances.get(new GraphVertex<>(2)));
    }

    // Returns an empty map when the source vertex is not in the graph
    @Test
    public void test_returnsEmptyMapWhenSourceVertexNotInGraph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2, 2.0);

        Map<GraphVertex<Integer>, Double> distances = graph.dijkstraDistances(3);

        assertTrue(distances.isEmpty());
    }

    @Test
    public void test_correct_distances_weighted_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2, 1.0);
        graph.addEdge(2, 3, 2.0);
        graph.addEdge(1, 3, 3.0);

        Double[][] expectedDistances = {
                {0.0, 1.0, 3.0},
                {Double.MAX_VALUE, 0.0, 2.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, 0.0}
        };
        Double[][] distances = graph.floydWarshall();
        assertArrayEquals(expectedDistances, distances);
        fail("Unexpected GraphIsNotWeightedException");
    }

    // Returns a NaryTree object with the expected vertices and edges when called with a valid source vertex in an undirected, weighted graph
    @Test
    public void test_valid_source_vertex_undirected_weighted_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, false);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2, 5.0);
        graph.addEdge(2, 3, 3.0);
        graph.addEdge(1, 3, 4.0);

        NaryTree<AdjacencyListGraphVertex<Integer>> result = graph.prim(1);

        NaryTree<AdjacencyListGraphVertex<Integer>> expected = new NaryTree<>();
        expected.add(null, new AdjacencyListGraphVertex<>(1));
        expected.add(new AdjacencyListGraphVertex<>(1), new AdjacencyListGraphVertex<>(2));
        expected.add(new AdjacencyListGraphVertex<>(2), new AdjacencyListGraphVertex<>(3));

        assertEquals(expected, result);
    }

    // Returns an empty NaryTree object when called with a source vertex that has no edges in an undirected, weighted graph
    @Test
    public void test_source_vertex_no_edges_undirected_weighted_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, false);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        NaryTree<AdjacencyListGraphVertex<Integer>> result = graph.prim(1);

        NaryTree<AdjacencyListGraphVertex<Integer>> expected = new NaryTree<>();

        assertEquals(expected, result);
    }

    // Returns an empty NaryTree object when called with a source vertex that does not exist in an undirected, weighted graph
    @Test
    public void test_source_vertex_not_exist_undirected_weighted_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, false);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        NaryTree<AdjacencyListGraphVertex<Integer>> result = graph.prim(4);

        NaryTree<AdjacencyListGraphVertex<Integer>> expected = new NaryTree<>();

        assertEquals(expected, result);
    }

    // Returns a NaryTree object with the expected vertices and edges when called with a valid source vertex in a graph with only one vertex
    @Test
    public void test_valid_source_vertex_single_vertex_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, false);
        graph.addVertex(1);

        NaryTree<AdjacencyListGraphVertex<Integer>> result = graph.prim(1);

        NaryTree<AdjacencyListGraphVertex<Integer>> expected = new NaryTree<>();
        expected.add(null, new AdjacencyListGraphVertex<>(1));

        assertEquals(expected, result);
    }

    // Returns an empty NaryTree object when called with a source vertex in an empty graph
    @Test
    public void test_source_vertex_empty_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, false);

        NaryTree<AdjacencyListGraphVertex<Integer>> result = graph.prim(1);

        NaryTree<AdjacencyListGraphVertex<Integer>> expected = new NaryTree<>();

        assertEquals(expected, result);
    }

    // Returns an empty NaryTree object when called with a source vertex that has no edges in a graph with multiple vertices
    @Test
    public void test_source_vertex_no_edges_multiple_vertices_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, false);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        NaryTree<AdjacencyListGraphVertex<Integer>> result = graph.prim(1);

        NaryTree<AdjacencyListGraphVertex<Integer>> expected = new NaryTree<>();

        assertEquals(expected, result);
    }

    // Returns an ArrayList of edges for an undirected, weighted graph with no isolated vertices
    @Test
    public void test_undirected_weighted_graph_no_isolated_vertices() {
        setUpGraphWithWeightNotDirected();
        ArrayList<Edge<Integer>> expected = new ArrayList<>();
        expected.add(graph1.searchEdge(graph1.castVertex(9), graph1.castVertex(7), 1.0));
        expected.add(graph1.searchEdge(graph1.castVertex(1), graph1.castVertex(2), 2.0));
        expected.add(graph1.searchEdge(graph1.castVertex(5), graph1.castVertex(4), 3.45));
        expected.add(graph1.searchEdge(graph1.castVertex(2), graph1.castVertex(3), 5.0));
        expected.add(graph1.searchEdge(graph1.castVertex(0), graph1.castVertex(6), 6.99));


        try {
            ArrayList<Edge<Integer>> result = graph1.kruskal();
            assertEquals(expected, result);
        } catch (GraphIsNotWeightedException | GraphTypeNotAllowed e) {
            fail("Unexpected exception thrown");
        }
    }

    // Returns an empty ArrayList for an undirected, weighted graph with no edges
    @Test
    public void test_undirected_weighted_graph_no_edges() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, false);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        ArrayList<Edge<Integer>> expected = new ArrayList<>();

        try {
            ArrayList<Edge<Integer>> result = graph.kruskal();
            assertEquals(expected, result);
        } catch (GraphIsNotWeightedException | GraphTypeNotAllowed e) {
            fail("Unexpected exception thrown");
        }
    }

    // Returns an ArrayList with a single edge for an undirected, weighted graph with two vertices and one edge
    @Test
    public void test_undirected_weighted_graph_two_vertices_one_edge() {
        setUpGraphWithWeightNotDirected();

        ArrayList<Edge<Integer>> expected = new ArrayList<>();
        expected.add(graph1.searchEdge(graph1.castVertex(9), graph1.castVertex(7), 1.0));
        expected.add(graph1.searchEdge(graph1.castVertex(1), graph1.castVertex(2), 2.0));
        expected.add(graph1.searchEdge(graph1.castVertex(5), graph1.castVertex(4), 3.45));
        expected.add(graph1.searchEdge(graph1.castVertex(2), graph1.castVertex(3), 5.0));
        expected.add(graph1.searchEdge(graph1.castVertex(0), graph1.castVertex(6), 6.99));

        try {
            ArrayList<Edge<Integer>> result = graph1.kruskal();
            assertEquals(expected, result);
        } catch (GraphIsNotWeightedException | GraphTypeNotAllowed e) {
            fail("Unexpected exception thrown");
        }
    }

    // Throws GraphIsNotWeightedException for an unweighted graph
    @Test
    public void test_unweighted_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(false, false);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);

        assertThrows(GraphIsNotWeightedException.class, () -> {
            graph.kruskal();
        });
    }

    // Throws GraphTypeNotAllowed for a directed graph
    @Test
    public void test_directed_graph() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, true);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2, 5.0);

        assertThrows(GraphTypeNotAllowed.class, () -> {
            graph.kruskal();
        });
    }

    // Returns an empty ArrayList for an undirected, weighted graph with isolated vertices
    @Test
    public void test_undirected_weighted_graph_isolated_vertices() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>(true, false);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        ArrayList<Edge<Integer>> expected = new ArrayList<>();

        try {
            ArrayList<Edge<Integer>> result = graph.kruskal();
            assertEquals(expected, result);
        } catch (GraphIsNotWeightedException | GraphTypeNotAllowed e) {
            fail("Unexpected exception thrown");
        }
    }
}
