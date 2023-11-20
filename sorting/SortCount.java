public class SortCount {
    
    private int b[];
	private int c[];
    private int a[];
    
    // own defined constructor
    public SortCount(int[] arr){
        this.a = new int[arr.length];
        copyArrToA(arr);
        this.b = new int[arr.length];

        this.c =  new int[maxValueArr(arr)+1];
    }
    
    // method to copy the array into class variable
    private void copyArrToA(int[] arr) {
        for(int i=0; i<arr.length;i++){
            this.a[i]=arr[i];
        }
    }

    // method to get max values from array
    private int maxValueArr(int[] arr){
        int maximumArrayValue=0;

        for(int i =0; i<arr.length;i++){
            if(maximumArrayValue<arr[i]){
                maximumArrayValue=arr[i];
            }
        }
        return maximumArrayValue;
    }

    //method to sort the array
    public void SortArr(){
        
        for(int j =0; j<a.length;j++) {
			this.c[a[j]]+=1;
		}

		int i =2;
		while(i<this.c.length) {
			this.c[i]+=this.c[i-1];	
			i+=1;
		}

		int k;
		int itr=0;
		while(itr<a.length) {
			k = this.c[a[itr]];
			this.c[a[itr]] -= 1;
            this.b[k-1] += a[itr];
			itr+=1;
		}
		
		//Calling method to print the array elements after sorted
		printSortedArray();
    }

    //print sorted array
    public void printSortedArray() {
        System.out.print("Elements of array after Counting sort >> { ");
		for(int i =0;i<this.b.length;i++) {
			System.out.print(b[i]);//values are printed adjacent to each other
			if(i<this.b.length-1)    System.out.print(",");
            else System.out.println(" }");
		}
        System.out.println();
    }

    //print unsorted array
    public void printUnSortedArray() {
        System.out.print("Elements of array before Counting sort >> { ");
		for(int i =0;i<this.a.length;i++) {
			System.out.print(a[i]);//values are printed adjacent to each other
			if(i<this.a.length-1)    System.out.print(",");
            else System.out.println(" }");
		}
        System.out.println();
    }
}
