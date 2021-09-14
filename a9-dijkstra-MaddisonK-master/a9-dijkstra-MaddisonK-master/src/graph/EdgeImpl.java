package graph;

public class EdgeImpl implements Edge {
    private Vertex _source;
    private Vertex _destination;
    private double _weight;

    public EdgeImpl(Vertex source, Vertex destination, double weight)  {
        _source = source;
        _destination = destination;
        _weight = weight;
        if(weight < 0)
            _weight = 0;
    }

    public Vertex getSource() {
        return _source;
    }

    public Vertex getDestination() {
        return _destination;
    }

    public double getWeight() {
        return _weight;
    }
}
