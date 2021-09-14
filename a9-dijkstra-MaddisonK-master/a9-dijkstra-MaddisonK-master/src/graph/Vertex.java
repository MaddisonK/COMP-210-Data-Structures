package graph;

import java.util.List;

public interface Vertex {

     List<Edge> getEdges();
     void addEdge(Edge e);
     double getDistanceFromSource();
     void setDistanceFromSource(double distance);
     String getLabel();
     Vertex getPreviousVertex();
      void setPreviousVertex(Vertex v);
      boolean is_known();
      void make_known();

}
