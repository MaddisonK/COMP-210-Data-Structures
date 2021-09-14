package graph;


import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph("D://Downloads//Copy of roadtrip - Sheet1.csv");
        Map<String, Double> dijkstra =  graph.dijkstra(graph.getVertices().get("Chapel Hill"));
        for (Map.Entry<String, Double> entry : dijkstra.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        // trace back
        System.out.println("");
        System.out.println("Trace Back");
        Vertex end = graph.getVertices().get("Los Angeles");
        System.out.println(end.getLabel());
        Vertex previous = end.getPreviousVertex();
        System.out.println(previous.getLabel());
        while (!previous.getLabel().equals("Chapel Hill") ) {
            previous = previous.getPreviousVertex();
            System.out.println(previous.getLabel());
        }


//        for (Map.Entry<String, Vertex> entry : graph.getVertices().entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue().is_known());
//        }
        }
    }

