import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    /**
     * 
     * @param args to run the main function in class App for testing Prim and Bellmanford algorithms with two different inputs for two algorithms
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
       //Bellman with directed graph
       System.out.println("testing belmman ford with directed graph");
       testBellmanDirected();

        System.out.println("-------******-------******-------");
        
        // prim with undirected graph
        Scanner sc = new Scanner(System.in);
        System.err.println("enter a name to save as file do not forget top give extension .dot: ");
        String fName = sc.nextLine();
        if(!fName.contains(".dot")){
            System.out.println("missed .dot extension adding here.......");
            fName+=".dot";
        }
        System.out.println("Testing Prim algorithm................");
        testPrimUndirected(fName);
        sc.close();
        
    }

    /**
     * Testing prim algorithm of undirected graph
     * @throws IOException
     */
    public static void testPrimUndirected(String fileName) throws IOException {
        String[] verticesString = {"A","B","C","D","E","F"};
        List<Node> nodes = new ArrayList<>();

        for(String node: verticesString){
            nodes.add(new Node(node));
        }
        List<Edge> eList = new ArrayList<>();
        
        eList.add(new Edge("A", "B", 7));
        eList.add(new Edge("A", "C", 8));
        eList.add(new Edge("C", "B", 3));
        eList.add(new Edge("C", "E", 3));
        eList.add(new Edge("C", "D", 4));
        eList.add(new Edge("B", "D", 6));
        eList.add(new Edge("F", "D", 5));
        eList.add(new Edge("E", "F", 2));
        eList.add(new Edge("E", "D", 2));
        Graph graphPrim = new Graph();
        for(Edge e: eList){
            graphPrim.edgeAddition(e);
        }    
        for(Node n: nodes){
            graphPrim.addVertex(n);
        }
        undirectedGraph udg = new undirectedGraph();
        udg.printUndirectedgraph();
        PrimAlgorithm prim = new PrimAlgorithm(graphPrim,nodes.get(0));

        prim.primMSTUndirected();

        prim.printMSTPrimUndirected(fileName);
    }

    /**
     * testing bellman ford algorithm using direcetd graph as input 
     */
    public static void testBellmanDirected(){
        String[] verticesInt = {"0","1","2","3","4"};
        List<Node> nodeList = new ArrayList<>();
        
        for(String s: verticesInt){
            nodeList.add(new Node(s));
        }
        
        Graph graphBellman = new Graph();
        List<Edge> eList = new ArrayList<>();

        eList.add(new Edge("0","1",1));
        eList.add(new Edge("0","2",4));
        eList.add(new Edge("1","2",3));
        eList.add(new Edge("1","3",2));
        eList.add(new Edge("2","3",5));
        eList.add(new Edge("3","4",3));
        eList.add(new Edge("4","1",2));
        
        for(Edge e: eList){
            graphBellman.edgeAdditionDirected(e);
        }    
        for(Node n: nodeList){
            graphBellman.addVertex(n);
        }
        
        directedGraph dg = new directedGraph();
        dg.printDirectedgraph();
        
        BellmanFordAlgorithm bellmanFord = new BellmanFordAlgorithm();

        bellmanFord.bellmanFordSSRDirected(graphBellman, nodeList.get(0).vertexName); 
        bellmanFord.printBellman(nodeList.get(0).vertexName);
    }
}
