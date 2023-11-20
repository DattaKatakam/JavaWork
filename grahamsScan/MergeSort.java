import java.util.ArrayList;

public class MergeSort {
    private ArrayList<Point> pointsXSort;
    private ArrayList<Point> sortedX;
    private ArrayList<Point> sortedY;

    public MergeSort(ArrayList<Point> points){
        this.pointsXSort = new ArrayList<>(points);
        this.sortedX = new ArrayList<>();
        this.sortedY = new ArrayList<>();

        for(int i=0; i<points.size();i++){
            Point p = new Point();
            this.sortedX.add(p);
            this.sortedY.add(p);
        }
    }

    public ArrayList<Point> getSortedX(){
        return this.sortedX;
    }
    public ArrayList<Point> getSortedY(){
        return this.sortedY;
    }

    public void MergeSortDivide(int p, int r){
        if(p < r){
            // System.out.println("In Merge sort divide");
            int q = Math.floorDiv(p+r,2);
            MergeSortDivide(p, q);
            MergeSortDivide(q+1, r);
            Merge(p,r,q);
        }
    }

    private void Merge(int p, int r, int q) {
        int n1 = q-p+1;
        int n2 = r-q;

        ArrayList<Point> pointsListLeft = new ArrayList<>();
        ArrayList<Point> pointsListRight = new ArrayList<>();
        
        for(int i = 0; i< n1; i++){
            pointsListLeft.add(this.pointsXSort.get(i+p));
        }

        Point pointInfnity = new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);
        pointsListLeft.add(pointInfnity);

        for(int i = 0; i< n2; i++){
            pointsListRight.add(this.pointsXSort.get(i+q+1));
        }
        pointsListRight.add(pointInfnity);

        int i = 0, j = 0;
        for(int k = p; k <= r; k++){
            if(pointsListLeft.get(i).getX() <= pointsListRight.get(j).getX()){
                this.sortedX.get(k).setX(pointsListLeft.get(i).getX());
                this.sortedX.get(k).setY(pointsListLeft.get(i).getY());
                i++;
            }
            else{
                this.sortedX.get(k).setX(pointsListRight.get(j).getX());
                this.sortedX.get(k).setY(pointsListRight.get(j).getY());
                j++;
            }
        }

        i = 0; j = 0;
        for(int k = p; k <= r; k++){
            if(pointsListLeft.get(i).getY() <= pointsListRight.get(j).getY()){
                this.sortedY.get(k).setX(pointsListLeft.get(i).getX());
                this.sortedY.get(k).setY(pointsListLeft.get(i).getY());
                i++;
            }
            else{
                this.sortedY.get(k).setX(pointsListRight.get(j).getX());
                this.sortedY.get(k).setY(pointsListRight.get(j).getY());
                j++;
            }
        }
    }

    
}
