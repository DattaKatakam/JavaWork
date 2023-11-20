import java.util.*;

public class BellmanFordAlgorithm {
    Map<String, Integer> weightsMap;
    public BellmanFordAlgorithm(){
        this.weightsMap = new HashMap<>();
    }

    /**
     * this method belmmanFordDirected will find best routes to all nodes from source nodes in directed graph
     * @param graphTemplate is sent as input for retrieving vertices, edges from graph class
     * @param sNode is used for node starting position and get distances from that node to all other nodes
     */
    public void bellmanFordSSRDirected (Graph graphTemplate, String sNode){
        // this.weightsMap = new HashMap<>();
        for(Node n: graphTemplate.GraphVertices){
            this.weightsMap.put(n.vertexName, Integer.MAX_VALUE);
        }
        this.weightsMap.put(sNode, 0);
        int nodesCount=1;
        while(nodesCount<graphTemplate.neighbourEdges.size()-1){
            for(List<Edge> instEdgeList: graphTemplate.neighbourEdges.values()){
                int edgeSize=0;
                while(edgeSize<instEdgeList.size()){
                    Edge iEdge = instEdgeList.get(edgeSize);
                    //distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) 
                    boolean check1 = this.weightsMap.get(iEdge.getSrc()) + iEdge.getWt() < this.weightsMap.get(iEdge.getDest());
                    boolean check2 = this.weightsMap.get(iEdge.getSrc())!= Integer.MAX_VALUE;
                    if( check1 && check2 ){
                        this.weightsMap.put(iEdge.getDest(), this.weightsMap.get(iEdge.getSrc()) + iEdge.getWt());
                    }
                    edgeSize +=1; 
                }
            }
            nodesCount++;
        }
        for(List<Edge> instEdgeList: graphTemplate.neighbourEdges.values()){
            int edgeSize=0;
                while(edgeSize<instEdgeList.size()){
                    Edge iEdge = instEdgeList.get(edgeSize);
                    boolean check1 = this.weightsMap.get(iEdge.getSrc()) + iEdge.getWt() < this.weightsMap.get(iEdge.getDest());
                    boolean check2 = this.weightsMap.get(iEdge.getSrc())!= Integer.MAX_VALUE;
                    if( check1 && check2 ){
                        System.out.println("negative costs in graph........");
                        return;
                    }
                    edgeSize +=1; 
                }
        }
    }

    /**
     * method to print shortest paths from source node to all other nodes
     */
    public void printBellman(String srcVertex){
        System.out.println("Shortest paths from source node " + srcVertex + " :");
        for(String node: weightsMap.keySet()){
            System.out.println(srcVertex + " -> " + node + " --> " + this.weightsMap.get(node));
        }
    }
}
