import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Node {
    public String vertexName;
    private Node Parent;
    private int distance;
    Map<Node, Integer> adjacentNeighbours;
    /**
     * 
     * @param name user defined constructor
     */
    Node(String name){
        this.vertexName=name;
        this.Parent=null;
        this.distance=Integer.MAX_VALUE;
        this.adjacentNeighbours = new HashMap<>();
    }

    public void setParent(Node setParentNode){
        this.Parent = setParentNode;
    }
    public void setDistance(int dist){
        this.distance=dist;
    }
    public int getDistance(){
        return this.distance;
    }
    public Node getParent(){
        return this.Parent;
    }
    /**
     * 
     * @return arraylist of adjacentNeighbours keyset
     */
    public List<Node> getAdjacentVerticesList(){
        return new ArrayList<>(this.adjacentNeighbours.keySet());
    }
    /**
     * 
     * @param v node to be used to get adjacent nodes are present or not
     * @return boolean
     */
    public boolean isAdjacentVertex(Node v) {
        return this.adjacentNeighbours.containsKey(v);
    }
    /**
     * 
     * @param v node to get adjacent nodes 
     * @return distance else 0
     */
    public int getDistanceNodes(Node v){
        int dist = this.adjacentNeighbours.getOrDefault(v, 0);
        return dist;
    }
    /**
     * 
     * @param adjacentMember node is added as adjacent member in map variable
     * @param dist cost value of corresponsing node
     */
    public void addConnection(Node adjacentMember, int dist){
        this.adjacentNeighbours.put(adjacentMember, dist);
    }
    /**
     * 
     * @param removeMemberNode node is removed
     */
    public void removeConnection(Node removeMemberNode){
        this.adjacentNeighbours.remove(removeMemberNode);
    }
}
