public class testQuickSort {
    public static void main(String[] args) throws Exception {
        
        int[] a = {2,9,10,2,9,5,1,22,21};
        int[] b = {982, 685, 585, 181, 1010, 717, 12};
        int[] c = {28,51,909,61,20,251,22,31,5120};
        
        System.out.println("Sorting by Quick sort method >> ");
        //Test Array a
        SortQuick qsA = new SortQuick(a);
        qsA.sort(0, a.length);
        qsA.printUnSortedArray(a);
        qsA.printSortedArray();
        System.out.println("-----------------");
        //Test Array b
        SortQuick qsB = new SortQuick(b); 	
        qsB.sort(0, b.length); 		
        qsB.printUnSortedArray(b);
        qsB.printSortedArray();
        System.out.println("-----------------");
        //Test Array c
        SortQuick qsC = new SortQuick(c);
        qsC.sort(0, c.length);
        qsC.printUnSortedArray(c);
        qsC.printSortedArray();
    }
}
