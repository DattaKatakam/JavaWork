import java.util.ArrayList;
import java.util.Stack;

public class GrahamScan {
    private ArrayList<Point> X;
    
    public GrahamScan(ArrayList<Point> x){
        this.X = new ArrayList<>(x);
    }

    public Stack<Point> Graham(){
        System.out.println("checking for lowest point");
        Point p0 = lowestPoint();
        // Point p0 = lowestPoint(X,Y);
        System.out.println("printing lowest point");
        System.out.println("[ "+p0.getX() + " , "+ p0.getY() + " ]");
        ArrayList<Point> Q = new ArrayList<>();
        
        for(Point p: X){
            if(p.getX() == p0.getX() && p.getY() == p0.getY() ){
            }
            
            else Q.add(p);
        }
        System.out.println("size of X and Q are: "+ X.size() + ", "+Q.size());
        Q = sortPolar(Q,p0);
        System.out.println("sorted polar points");
        for(Point p: Q){
            System.out.println("[ "+p.getX() + " , "+ p.getY() + " ]");
        }
        Stack<Point> st = new Stack<>();
        st.push(p0);
        System.out.println("printing stack first point");
        System.out.println("[ "+st.get(0).getX() + " , "+ st.get(0).getY() + " ]");
        st.push(Q.get(0));
        System.out.println("printing stack second point");
        System.out.println("[ "+st.get(1).getX() + " , "+ st.get(1).getY() + " ]");
        st.push(Q.get(1));
        System.out.println("printing stack third point");
        System.out.println("[ "+st.get(2).getX() + " , "+ st.get(2).getY() + " ]");
        for(int i=2; i<Q.size();i++){
            //while loop
            Point secondStack = st.peek();//st.get(0);
            Point firstStack = st.elementAt(st.size()-2);
            int count = i;
            while(st.size()>3 && count < Q.size() && !turnsLeft(secondStack,firstStack,Q.get(i))){
                count++;
                System.out.println(count);
                st.pop();
            }
            System.out.println("pushing value: [ " + Q.get(i).getX() + " , "+ Q.get(i).getY() + " ]");
            st.push(Q.get(i));
        }
        return st;

    }

    private boolean turnsLeft(Point secondStack, Point firstStack, Point point) {
        double xDiff01 = (firstStack.getX() - secondStack.getX());
        double xDiff02 = (point.getX() - secondStack.getX());
        double yDiff01 = (firstStack.getY() - secondStack.getY());
        double yDiff02 = (point.getY() - secondStack.getY());
        System.out.println(( (xDiff01 * yDiff02) - (xDiff02 * yDiff01) ) < 0);
        return ( (xDiff01 * yDiff02) - (xDiff02 * yDiff01) ) < 0 ;
    }

    private ArrayList<Point> sortPolar(ArrayList<Point> Q, Point p0) {
        ArrayList<polarPoint> polarPointsSorted = new ArrayList<>();
        ArrayList<Point> pTemp = new ArrayList<>(Q);
        for(Point p: Q){
            double xDiff = p.getX() - p0.getX();
            double yDiff = p.getY() - p0.getY();
            double ang = Math.atan(yDiff/xDiff);
            double distance = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
            polarPointsSorted.add(new polarPoint(p, distance, ang));

        }

        for(int i =0; i< Q.size();i++){
            for( int j = i+1; j<Q.size(); j++ ){

                if(polarPointsSorted.get(i).angle > polarPointsSorted.get(j).angle){
                    Point tempPoint = Q.get(i);
                    pTemp.set(i, Q.get(j));
                    pTemp.set(j, tempPoint);

                }
            }
        }
        
        return Q;
    }

    private Point lowestPoint(){
        Point p0 = X.get(0);
        for(Point p: X){
            boolean condition1 = p.getY() < p0.getY();
            boolean condition2c1 = (p.getY() == p0.getY());
            boolean condition2c2 = p.getX() < p0.getX();
            if(condition1 || (condition2c1 && condition2c2)){
                p0 = p;
            }
        }
        return p0;
    }

    // private Point lowestPoint(ArrayList<Point> xList, ArrayList<Point> yList){
    //     if(xList.size()>3){
    //         int m = Math.floorDiv(xList.size(), 2);
    //         double count =0;
    //         ArrayList<Point> xLeft = new ArrayList<>();

    //         for(Point p: xList){
    //             if(count == m){
    //                 break;
    //             }
    //             xLeft.add(p);
    //             count++;
    //         }
    //         Point p0 = lowestPoint(xLeft, yList);
    //         System.out.println("[ "+p0.getX() + " , "+ p0.getY() + " ]");
    //         return p0;
    //     }
    //     else{
    //         Point p0 = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
    //         for(Point p: xList){
    //             System.out.println("curretn point is: [ "+p.getX() + " , "+ p.getY() + " ]");    
    //             if(p0.getY()>p.getY()){
    //                 p0.setX(p.getX());
    //                 p0.setY(p.getY());
    //             }
    //         }
    //         System.out.println("[ "+p0.getX() + " , "+ p0.getY() + " ]");
    //         return p0;
    //     }
        
    // }
}
