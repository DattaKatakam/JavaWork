import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    /**
     * Main class runs the code
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of points list: ");

        int sizePointsList = sc.nextInt();
        ArrayList<Point> Points = new ArrayList<>();
        sc.close();
        
        Points = getPoints(sizePointsList);
        printPoints(Points);

        MergeSort merge = new MergeSort(Points);
        merge.MergeSortDivide(0, Points.size()-1);
        
        ArrayList<Point> xSorted = merge.getSortedX();
        ArrayList<Point> ySorted = merge.getSortedY();

        ClosestPoints cp = new ClosestPoints();

        Pair<Point, Point> bestPair= cp.FindCLosestPoints(xSorted, ySorted);
        double distance = cp.distance(bestPair.getPoint1(), bestPair.getPoint2());

        System.out.println("Best closest point pair is: [" + bestPair.getPoint1().getX() + " , "+bestPair.getPoint1().getY()+"] and [ "
            + bestPair.getPoint2().getX() + " , "+bestPair.getPoint2().getY()+"] and distance between the points is: " + distance);
                       
    }

    /**
     * getPoints() method will return the ArrayList with Points as data type after generating the points randomly with max val upto 20
     * @param sizePointsList
     * @return
     */
    public static ArrayList<Point> getPoints(int sizePointsList){
        ArrayList<Point> Points = new ArrayList<>();
        Random rn = new Random();
        int maxDoubleVal = 20;

        for(int i=0; i<sizePointsList;i++){
            double x = Math.floor(maxDoubleVal*rn.nextDouble()*1000)/1000;
            double y = Math.floor(maxDoubleVal*rn.nextDouble()*1000)/1000;
            Point instPoint = new Point(x,y);
            Points.add(instPoint);
        }
        return Points;
    }

    /**
     * Printing points generated for main code
     * @param Points
     */
    public static void printPoints(ArrayList<Point> Points){
        System.out.println("Printing points that are chosen:");
        System.out.println("------------------------");
        
        for(Point instP: Points){
            System.out.println("[ "+instP.getX()+" , "+instP.getY()+" ]");
        }
    }
}
