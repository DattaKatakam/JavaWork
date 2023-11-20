public class Point {
    private double xCoOrdinate;
    private double yCoOrdinate;
    public Point(){

    }

    public Point(double xVal, double yVal){
        this.xCoOrdinate = xVal;
        this.yCoOrdinate = yVal;
    }

    public double getX(){
        return this.xCoOrdinate;
    }

    public double getY(){
        return this.yCoOrdinate;
    }

    public void setX(double xVal){
        this.xCoOrdinate = xVal;
    }

    public void setY(double yVal){
        this.yCoOrdinate = yVal;
    }
}
