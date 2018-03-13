//Kayli Matsuyoshi
//APCS2 pd1
//HW18 -- Driver Roll Up the Partition Please...
//2018-03-13t
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
      uno - Takes an array of ints and applies the helper function, qsortHelper.
      dos - The partition function is called to set a pivot value in its final resiting position. 
      tres - The recursive functions branch out and make the bounds cover a smaller area, until the partition area is 1 element.
      quatro - The elements are finally in their resting position after all recursive calls.
 *
 * 2a. Worst pivot choice and associated runtime: 
 * The worst pivot choice is an end of the array. and the runtime O(n^2).
 * 2b. Best pivot choice and associated runtime:
 * The best pivot point is in the middle, and the runtime is O(nlogn).
 * 3. Approach to handling duplicate values in array:
 * You can take either value, because they are the same. 
 *****************************************************/

public class QuickSort
{
    //--------------  HELPER METHODS  --------------
    //swap values at indices x, y in array o
    public static void swap( int[] o, int x, int y ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( d, swapPos, i );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }

    public static int partition(int[] arr, int left, int right, int pvtPos) {
        int pvtVal = arr[pvtPos];
        swap(arr, pvtPos, right); //move pivot point to end

	int storePos = left;
	for (int i = left; i < right; i ++) {
	    if (arr[i] < pvtVal) {
	        swap(arr,storePos,i);
		storePos += 1;
	    }
	}
	swap(arr,right,storePos); //move pivot point to final resting place
	return storePos;
    }
    
    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d )
    { 
        qsortHelper( d, 0, d.length - 1);
    }

    public static void qsortHelper ( int[] arr, int left, int right ) {
	if ( left < right ) {
	    int pivot = partition ( arr, left, right, right );
	    qsortHelper( arr, left, pivot -1 );
	    qsortHelper( arr, pivot +1, right );
	}
    }


    //main method for testing
    public static void main( String[] args )
    {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort

