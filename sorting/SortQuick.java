public class SortQuick {
	private int[] a;
	// own defined constructor
	public SortQuick(int[] arr){
		this.a = new int[arr.length];
        copyArrToA(arr);
	}

	// copying array to class variable
    private void copyArrToA(int[] arr) {
		for(int i=0; i<arr.length;i++){
            this.a[i]=arr[i];
        }
	}

	// sort method and recurring
	public void sort(int p, int r){
        if(p<r-1) {
			int q=deepSort(p, r); //calling deepSort method and obtain the value of q
			sort(q,r); //calling sort method with offer assistance of returned value q
			sort(p, q); //calling sort method with offer assistance of returned value q
		}
    }

	// deep sort method for sub division
    private int deepSort(int p, int r) {
        int keyVal= this.a[r-1];
		int i;

		// p-1 is utilized since in cluster introductory position isn't 1
		if(p-1>=0) {
			i=p-1; 
		}
        //-1 is relegated since position of component is zero i.e to begin with component within the cluster
		else {
			i=-1;
		}
		
		for(int j = p; j<r-1; j++) {
			if(this.a[j]<=keyVal) {
				i=i+1;
                //temparary swap
				int k = this.a[j];
				this.a[j]=this.a[i];
				this.a[i]=k;
			}
		}

		//values swapped
		this.a[r-1]=this.a[i+1];
		this.a[i+1]=keyVal;
		
		//i+1 is position to separate the cluster to sort once more in another step
		return i+1;
    }

	// printing the array after sorting
    public void printSortedArray(){
        System.out.print("Elements of array after Quick sorting >> { ");
		for(int i =0;i<this.a.length;i++) {
			System.out.print(this.a[i]);
			if(i<this.a.length-1) System.out.print(",");
			else System.out.println(" }");
		}
		System.out.println();
    }
    
	//printing the array before sorting
    public void printUnSortedArray(int[] arr){
        System.out.print("Elements of array before Quick sorting >> { ");
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]);
			if(i<arr.length-1) System.out.print(",");
			else System.out.println(" }");
		}
		System.out.println();
    }
}
