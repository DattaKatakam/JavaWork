public class Edge {
    private String src;
    private String dest;
    private int wt;

    /**
     * user defined constructor
     */
    public Edge(String source, String destination, int dist){
        this.wt = dist;
        this.src = source;
        this.dest = destination;
    }
    /**
     * 
     * @param dist sets wt variable 
     */
    public void setWt(int dist){
        this.wt = dist;
    }
    /**
     * 
     * @param source sets src variable
     */
    public void setSrc(String source){
        this.src = source;
    }
    /**
     * 
     * @param destination sets dest variable 
     */
    public void setDest(String destination){
        this.dest = destination;
    }
    /**
     * 
     * @return source node as string
     */
    public String getSrc(){
        return this.src;
    }
    /**
     * 
     * @return dest node as String
     */
    public String getDest(){
        return this.dest;
    }
    /**
     * 
     * @return wt as int
     */
    public int getWt(){
        return this.wt;
    }
}
