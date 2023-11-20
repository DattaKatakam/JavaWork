public class Pair<T,U> {
    private T point1;
    private U point2;
    /**
     * constructor to store best closest pair of points 
     * @param p1
     * @param p2
     */
    public Pair(T p1, U p2){
        this.point1 = p1;
        this.point2 = p2;
    }
    /**
     * returns varaiable T
     * @return
     */
    public T getPoint1(){
        return this.point1;
    }

    /**
     * returns varaiable U
     * @return
     */
    public U getPoint2(){
        return this.point2;
    }
}
