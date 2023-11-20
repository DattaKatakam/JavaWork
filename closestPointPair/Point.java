
public class Point {
    private double xCoOrdinate;
    private double yCoOrdinate;
    /**
     * default constructor 
     */
    public Point(){
        
    }

    /**
     * constructor if input parameter are provided
     * @param x
     * @param y
     */
    public Point(double x, double y){
        this.xCoOrdinate = x;
        this.yCoOrdinate = y;
    }
    /**
     * sets the varible x
     * @param x
     */
    public void setX(double x){
        this.xCoOrdinate = x;
    }

    /**
     * sets the varible y
     * @param y
     */
    public void setY(double y){
        this.yCoOrdinate = y;
    }

    /**
     * gets the varible x
     * @return xCoOrdinate
     */
    public double getX(){
        return this.xCoOrdinate;
    }

    /**
     * gets the varible y
     * @return yCoOrdinate
     */
    public double getY(){
        return this.yCoOrdinate;
    }

}
