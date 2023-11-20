public class testRun {
    //code contains all test cases to run two sort methods
    public static void main(String[] args){
        int[] a = {982, 685, 585, 181, 1010, 717, 12};
        int[] b = {28,51,909,61,20,251,22,31,5120};
        int[] c = {2,9,10,2,9,5,1,22,21};
        
        //define Sort count for all three arrays and printing unsorted arrays and sorted arrays in sequence
        System.out.println("Sorting by Counting sort method >> ");
        // Test array a
        SortCount scA = new SortCount(a);
        scA.printUnSortedArray();
        scA.SortArr();

        System.out.println("\n----------------------\n");
        
        // Test array b
        SortCount scB = new SortCount(b);
        scB.printUnSortedArray();
        scB.SortArr();
        
        System.out.println("\n----------------------\n");
        
        // Test array c
        SortCount scC = new SortCount(c);
        scC.printUnSortedArray();
        scC.SortArr();

        System.out.println("\n----------------------\n");
        
        // quick sorting tests by defining class and sorting
        System.out.println("Sorting by Quick sort method >> ");
        //Test Array a
        SortQuick qsA = new SortQuick(a);
        qsA.sort(0, a.length);
        qsA.printUnSortedArray(a);
        qsA.printSortedArray();
        System.out.println("\n-----------------------\n");
        //Test Array b
        SortQuick qsB = new SortQuick(b); 	
        qsB.sort(0, b.length); 		
        qsB.printUnSortedArray(b);
        qsB.printSortedArray();
        System.out.println("\n-----------------------\n");
        //Test Array c
        SortQuick qsC = new SortQuick(c);
        qsC.sort(0, c.length);
        qsC.printUnSortedArray(c);
        qsC.printSortedArray();

    }
}
