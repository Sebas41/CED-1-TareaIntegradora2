package com.example.ced1integradora2.tests;

import com.example.ced1integradora2.model.structure.graph.AdjacencyMatrixGraph;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdjacencyMatrixGraphTest {

    private AdjacencyMatrixGraph<Integer> graph1;

    public void setUpGraphWithoutWeightDirected(){
        graph1 = new AdjacencyMatrixGraph<>(20,false,true);

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
        graph1 = new AdjacencyMatrixGraph<>(20,true,true);

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
        graph1 = new AdjacencyMatrixGraph<>(20,true,false);

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
        graph1 = new AdjacencyMatrixGraph<>(20,false,false);

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
        assertEquals(10,graph1.getVertexes().size());
        assertEquals(6,graph1.getEdges().size());
    }

    @Test
    public void removeEdgeOfGraphWithWeightNotDirected(){
        setUpGraphWithWeightNotDirected();


    }

    @Test
    public void removeEdgeOfGraphWithoutWeightDirected(){
        setUpGraphWithoutWeightDirected();

    }

    @Test
    public void removeEdgeOfGraphWithoutWeightNotDirected(){
        setUpGraphWithoutWeightNotDirected();


    }
}
