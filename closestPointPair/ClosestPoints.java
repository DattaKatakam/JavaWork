import java.util.ArrayList;

public class ClosestPoints {

    /**
     * finds the closest points in the list of points after sorting the points list and
     *  parameters are passed according to the sorting lists
     * @param X
     * @param Y
     * @return pair<Point, Point>
     */
    public Pair<Point,Point> FindCLosestPoints(ArrayList<Point> X, ArrayList<Point> Y){
        // System.out.println("in finding closeset pair method");
        if(X.size()>3){
            int m = Math.floorDiv(X.size(), 2);
            double l_X = (X.get(m-1).getX()+X.get(m).getX()) / 2;
            ArrayList<Point> X_Left = new ArrayList<>();
            ArrayList<Point> x_Right = new ArrayList<>();
            for(int i=0;i<m;i++){
                X_Left.add(X.get(i));
            }
            for(int i=m;i<X.size();i++){
                x_Right.add(X.get(i));
            }
            Pair<Point, Point> pair1 = FindCLosestPoints(X_Left, Y);
            Pair<Point, Point> pair2 = FindCLosestPoints(x_Right, Y);
            Pair<Point, Point> pair3 = Combine(Y, l_X, pair1, pair2);
            return pair3;
        }
        else{
            return BruteForceClosestPoints(X);
        }
    }

    /**
     * cobines the arraylist with consdering the best pair of points that are closest taking parameters as sortedList with Y points
     * and mid index value and best two pairs of points finally returnt the best pair of points 
     * @param Y
     * @param l_X
     * @param pair1
     * @param pair2
     * @return pair<Point, Point>
     */
    public Pair<Point, Point> Combine(ArrayList<Point> Y, double l_X, Pair<Point, Point> pair1, Pair<Point, Point> pair2){
        // System.out.println("combing the list");
        double d =0;
        double d1 = distance(pair1.getPoint1(), pair1.getPoint2() );
        double d2 = distance(pair2.getPoint1(), pair2.getPoint2());
        Pair<Point, Point> pair3;
        if( d1 < d2){
            pair3 = pair1;
            d = d1;
        }
        else{
            pair3 = pair2;
            d = d2;
        }
        ArrayList<Point> dupY = new ArrayList<>();
        for(Point p: Y){
            if(l_X-d <= p.getX() && p.getX() <= l_X+d){
                dupY.add(p);
            }
        }
        for(int i=0; i<dupY.size(); i++){
            int j=0;
            while(j < 7 && i+j < dupY.size()){
                double d3 = distance(dupY.get(i), dupY.get(i+j));
                if(d1 < d){
                    Pair<Point, Point> pairInst = new Pair<>(dupY.get(i), dupY.get(i+j));
                    pair3 = pairInst;
                    d = d3;
                }
                j++;
            }
        }
        return pair3;

    }

    /**
     * calculates the distance between the points and return double value of distance between the points
     * @param point1
     * @param point2
     * @return dist
     */
    public double distance(Point point1, Point point2) {
        double xDiff = point1.getX() - point2.getX();
        double yDiff = point1.getY() - point2.getY();
        double dist = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
        return dist;
    }

    /**
     * gets the best apir within the three points by using distance method returns the best pair of points 
     * @param X
     * @return pair<Point, Point>
     */
    public Pair<Point, Point> BruteForceClosestPoints(ArrayList<Point> X){
        // System.out.println("using brute force");
        Pair<Point, Point> bestPair = null;
        double distMinimum = Integer.MAX_VALUE;
        
        for(int i=0; i < X.size(); i++){
            
            for(int j = i+1; j < X.size(); j++){
                double d = distance(X.get(i), X.get(j));

                if(d < distMinimum){
                    distMinimum = d;
                    bestPair = new Pair<>(X.get(i), X.get(j));
                }
            }
        }
        // System.out.println("Best closest point pair is: [" + bestPair.getPoint1().getX() + " , "+bestPair.getPoint1().getY()+"] and [ "
        //                     + bestPair.getPoint2().getX() + " , "+bestPair.getPoint2().getY()+"] and distance between the points is: " + distMinimum);
        return bestPair;
    }

}
