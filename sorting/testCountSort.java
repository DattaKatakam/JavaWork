public class testCountSort {
    public static void main(String[] args){
        
        int[] a = {2,9,10,2,9,5,1,22,21};
        int[] b = {982, 685, 585, 181, 1010, 717, 12};
        int[] c = {28,51,909,61,20,251,22,31,5120};
        
        //define Sort count for all three arrays and printing unsorted arrays and sorted arrays in sequence
        SortCount scA = new SortCount(a);
        scA.printUnSortedArray();
        scA.SortArr();

        System.out.println("----------------------");
        
        SortCount scB = new SortCount(b);
        scB.printUnSortedArray();
        scB.SortArr();
        
        System.out.println("----------------------");
        
        SortCount scC = new SortCount(c);
        scC.printUnSortedArray();
        scC.SortArr();

    }
}
