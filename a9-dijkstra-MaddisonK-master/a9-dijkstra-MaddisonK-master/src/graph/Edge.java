package graph;

public interface Edge {

    Vertex getSource();
    Vertex getDestination();
    double getWeight();
}
