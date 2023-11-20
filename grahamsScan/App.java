import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of points list: ");

        int sizePointsList = sc.nextInt();
        ArrayList<Point> Points = new ArrayList<>();
        sc.close();
        
        Points = getPoints(sizePointsList);
        System.out.println("Printing points that are chosen:");
        printPoints(Points);

        MergeSort merge = new MergeSort(Points);
        merge.MergeSortDivide(0, Points.size()-1);
        
        ArrayList<Point> xSorted = merge.getSortedX();
        System.out.println("printing xsorted list");
        printPoints(xSorted);
        GrahamScan gs = new GrahamScan(xSorted);
        ArrayList<Point> stackPoints= new ArrayList<>(gs.Graham());
        System.out.println("Printing final convex hull points");
        printPoints(stackPoints);
    }

    private static void printPoints(ArrayList<Point> points) {
        System.out.println("------------------------");
        
        for(Point instP: points){
            System.out.println("[ "+instP.getX()+" , "+instP.getY()+" ]");
        }
    }

    private static ArrayList<Point> getPoints(int sizePointsList) {
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
}
