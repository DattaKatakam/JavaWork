import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Graph {
    ArrayList<Node> GraphVertices;
    ArrayList<Node> priorityQueueMin;
    Map<String, List<Edge>> neighbourEdges;
    List<Edge> edge;
    
    /**
     * user defined constructor
     */
    public Graph(){
        this.edge = new ArrayList<Edge>();
        this.GraphVertices = new ArrayList<Node>();
        this.priorityQueueMin = new ArrayList<Node>();
        this.neighbourEdges = new HashMap<>();
    }

    /**
     * 
     * @param e is an edge as input parameter and edge is added into map of neighbour edges
     */
    public void edgeAddition(Edge e){
        String eSrc = e.getSrc();
        String eDest = e.getDest();
        int eWt = e.getWt();
        Edge edgeFromDest = new Edge(eDest, eSrc, eWt);
        List<Edge> srcEdgesList = this.getEdges(eSrc);
        List<Edge> destEdgesList = this.getEdges(eDest);
        destEdgesList.add(edgeFromDest);
        srcEdgesList.add(e);
        this.neighbourEdges.put(eDest, destEdgesList);
        this.neighbourEdges.put(eSrc, srcEdgesList);
    }

    /**
     * 
     * @param e is an edge in undirected graph as input parameter and it is added to neighbour edges map
     */
    public void edgeAdditionDirected(Edge e){
        List<Edge> edgeList = this.getEdges(e.getSrc());
        edgeList.add(e);
        this.neighbourEdges.put(e.getSrc(), edgeList);
    }

    /**
     * 
     * @param node to get neighbouring edges
     * @return neighbouring edges else new list of edges are created and returned
     */
    public List<Edge> getEdges(String node){
        if(this.neighbourEdges.containsKey(node)){
            return this.neighbourEdges.get(node); 
        }
        else{
            return new ArrayList<>();
        }
    }

    /**
     * 
     * @param node to add vertex in list of graph vertices
     */
    public void addVertex(Node node){
        this.GraphVertices.add(node);
    }
    
    /**
     * 
     * @param node removers the node from graph vertices
     */
    public void  removeVertexConnection(Node node){
        this.GraphVertices.remove(node);
        for( Node instNode: this.GraphVertices){
            instNode.removeConnection(node);
        }
    }

    /**
     * 
     * @param u as source node
     * @param v as destination node
     * @return distance between u, v nodes in graph
     */
    public int getDistanceNodes(Node u, Node v) {
        if (u.isAdjacentVertex(v)) {
            return u.getDistanceNodes(v);
        } else {
            return 0;
        }
    }

}
