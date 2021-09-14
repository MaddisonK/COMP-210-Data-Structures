package graph;


import minBinHeap.BinaryHeap;
import minBinHeap.MinBinaryHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
    private Map<String, Vertex> _vertices;
    private List<List<String>> _data;


    public Graph(String fileName) {
        _vertices = new HashMap<>();
        createGraph(fileName);
    }
    public Graph() {
        _vertices = new HashMap<>();
    }


    public double calculateWeight(int distance, int traffic, int scenery, int attractions) {
        return distance*traffic-(100*scenery)-(50*attractions);
    }

    public Map<String, Double> dijkstra(Vertex start) {

        Map<String, Double> rt = new HashMap<>();

        start.setPreviousVertex(start);
        BinaryHeap<Vertex, Double> mh = new MinBinaryHeap<>();
        mh.enqueue(start, 0.0);

        while (mh.size() > 0) {
            // removing top
            Vertex current = mh.dequeue();
            if (current.is_known()) {
                continue;
            }
            current.make_known();
            rt.put(current.getLabel(), current.getDistanceFromSource());
            // looking at adjacent vertices
            List<Edge> adj_list = current.getEdges();
            for (Edge adj_e : adj_list) {
                if (!adj_e.getDestination().is_known()) {
                    if ((adj_e.getDestination().getDistanceFromSource() == start.getDistanceFromSource()) | (current.getDistanceFromSource() + adj_e.getWeight() < adj_e.getDestination().getDistanceFromSource())) {
                    adj_e.getDestination().setPreviousVertex(current);
                    adj_e.getDestination().setDistanceFromSource(current.getDistanceFromSource() + adj_e.getWeight());
                    mh.enqueue(adj_e.getDestination(), adj_e.getDestination().getDistanceFromSource());
                    }
                }
            }
        }
        return rt;
    }

    // Do not edit anything below

    /*
    reads through each entry in csv and calls readLine to create edges and vertices.
     */
    public void createGraph(String fileName) {
        readCSV(fileName);
        for(List<String> list: _data) {
            readLine(list.get(0), list.get(1), Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3))
                    , Integer.parseInt(list.get(4)), Integer.parseInt(list.get(5)));
        }
    }
    /*
    reads through each line of csv and puts data into an ArrayList
     */
    public void readCSV(String fileName) {
        _data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                _data.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    converts one entry of data into vertices and edges
     */
    public void readLine(String src, String dest, int distance, int traffic, int scenery, int attractions) {
        // find source and destination nodes, if they don't exist, create them
        Vertex source = _vertices.get(src);
        if(source == null)
            source = new VertexImpl(src);
        Vertex destination = _vertices.get(dest);
        if(destination == null)
            destination = new VertexImpl(dest);

        // calculate weight of edge
        double weight = calculateWeight(distance, traffic, scenery, attractions);

        //create edge
        Edge e = new EdgeImpl(source, destination, weight);
        source.addEdge(e);

        //add reverse direction edge
        e = new EdgeImpl(destination, source, weight);
        destination.addEdge(e);

        //add to graph
        _vertices.put(src, source);
        _vertices.put(dest, destination);

    }

    public Map<String, Vertex> getVertices() {
        return _vertices;
    }





}
