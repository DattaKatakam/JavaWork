import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PrimAlgorithm {
    private Map<String, Integer> weightsMap; 
    private Map<String, String> mappedEdges;
    private Map<String, Integer> travelEdges;
    private Node rootNode;
    private Graph graphTemplate;
    String dotNotation="";

    /**
     * PrimALgorithm constructor
     * @param gTemplate
     * @param rNode
     */
    public PrimAlgorithm(Graph gTemplate,Node rNode){
        this.weightsMap = new HashMap<>();
        this.travelEdges= new HashMap<>();
        this.mappedEdges = new HashMap<>();
        this.rootNode = rNode;
        this.graphTemplate = gTemplate;
    }

    /**
     * primMSTUndirected() method to find shortest distance path of undirected graph
     */
    public void primMSTUndirected(){ 
        Map<String, Boolean> visitNodes = new HashMap<>();

        for(Node instNode: this.graphTemplate.GraphVertices){
            this.mappedEdges.put(instNode.vertexName, null);
            visitNodes.put(instNode.vertexName, false);
            this.weightsMap.put(instNode.vertexName, Integer.MAX_VALUE);
        }

        this.weightsMap.put(rootNode.vertexName, 0);
        visitNodes.put(rootNode.vertexName, true);
        this.travelEdges.put(rootNode.vertexName, 0);
        // System.out.println(rootNode.vertexName);
        // System.out.println(visitNodes.containsKey(rootNode.vertexName));
        // for(int w: this.weightsMap.values()){
        //     System.out.println("wt is: "+w);
        // }
        
        while(!this.weightsMap.keySet().isEmpty()){
            String currentNode = extractMinUndirected();
            // System.out.println("current node is: " + currentNode);
            List<Edge> cNodeEdgeList = this.graphTemplate.getEdges(currentNode);

            for(Edge iEdge: cNodeEdgeList){
                
                String destinationVertex = iEdge.getDest();
                boolean check1 = iEdge.getWt() <  this.weightsMap.getOrDefault(destinationVertex,Integer.MAX_VALUE);
                boolean check2 = this.weightsMap.containsKey(destinationVertex);

                if(check2 && check1){
                    // System.out.println("mapped edges added to current node DEST NODE: " + destinationVertex + " CURRETN NODE "+ currentNode + " weight " + iEdge.getWt());
                    this.mappedEdges.put(destinationVertex, currentNode);
                    this.weightsMap.put(destinationVertex, iEdge.getWt());
                    this.travelEdges.put(destinationVertex, iEdge.getWt());
                }
                
            }
        }
    }

    /**
     * extractMinUndirected() to get minimum distance edge in graph 
     * @return minimumvertex in graph
     */
    private String extractMinUndirected() {
        String vertexMinimum = null;
        int minDist = Integer.MAX_VALUE;

        for(String vertex: this.weightsMap.keySet()){
            if(this.weightsMap.get(vertex)!=Integer.MAX_VALUE){
                List<Edge> edgeList = this.graphTemplate.neighbourEdges.get(vertex);
                int edgeCount =0;
                while(edgeCount<edgeList.size()){
                    int wt = edgeList.get(edgeCount).getWt();
                    // System.out.println(edgeList.get(edgeCount).getSrc()+" source " + edgeList.get(edgeCount).getDest() +" , and " + wt);
                    if(wt < minDist){
                        minDist = wt;
                        // System.out.println("now min dist is: " + minDist);
                        vertexMinimum = vertex;
                        
                    }
                    edgeCount++;
                }
            }
        }

        this.weightsMap.remove(vertexMinimum);
        return vertexMinimum;
    }

    /**
     * printMSTPrimUndirected() prints the best suitable edges from graph
     * and also generates two dot files with a fileName from input and FinalGraph.dot file which contains only selected edges in graph
     * @throws IOException
     */
    public void printMSTPrimUndirected(String fileName) throws IOException{
        int labelNo = 1;
        String fName = fileName.split("\\.")[0];
        String secDotNotation ="graph FinalGraph{\n edge [color = \"green\"] \n";
        System.out.println("Minimum Spanning Tree:");
        int travelCost =0;
        this.dotNotation += "graph "+ fName+"{\n edge [color = \"black\"] \n";
        for (String node : this.mappedEdges.keySet()) {
            List<Edge> edgeList = this.graphTemplate.neighbourEdges.get(node);
            // System.out.println("edge list size: "+ edgeList.size());
            int edgeCount =0;
            while(edgeCount<edgeList.size()){
                if(edgeList.get(edgeCount).getDest() != this.mappedEdges.get(node)){

                    this.dotNotation += edgeList.get(edgeCount).getDest()  + " -- " + node + " [color = \"black\"];\n";
                    // labelNo+=1;
                }    
                edgeCount+=1;
            }
            // System.out.println("src node: "+node);
            if (this.mappedEdges.get(node) != null) {
                travelCost+=this.travelEdges.get(node);
                this.dotNotation += this.mappedEdges.get(node) + " -- " + node + " [label = \" "+travelCost+ " \", color = \"green\"];\n";
                secDotNotation += this.mappedEdges.get(node) + " -- " + node + " [label = \" "+labelNo+ " \", color = \"green\"];\n";
                System.out.println(this.mappedEdges.get(node) + " - " + node);
                labelNo+=1;
            }
        }
        this.dotNotation+="}";
        secDotNotation+="}";
        System.out.println(this.dotNotation);
        FileWriter fw = new FileWriter(fileName);
        FileWriter fw1 = new FileWriter("FinalGraph.dot");
        
        fw1.write(secDotNotation);
        fw.write(this.dotNotation);
        
        fw.close();
        fw1.close();
        System.out.println("total travel cost from source node " + rootNode.vertexName + " to all other nodes is " + travelCost);
    }
}
