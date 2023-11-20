public class polarPoint {
    Point point;
    double angle;
    double dist;
    
    public polarPoint(){

    }
    
    public polarPoint(Point p,double d, double a){
        this.angle = a;
        this.point = p;
        this.dist = d;
    }
    public void setPoint(Point p){
        this.point = p;
    }
    public void setAngle (double ang){
        this.angle = ang;
    }
    public void setDist (double distance){
        this.dist = distance;
    }

    public void changeParameters(Point p, double distance, double ang){
        this.point =p;
        this.angle = ang;
        this.dist = distance;
    }

}
