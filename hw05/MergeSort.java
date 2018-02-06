// Kayli Matsuyoshi
// APCS2 pd1
// HW05 - MergeSort! 
// 2018-02-07w

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:

  ======================================*/

import java.util.Arrays;

public class MergeSort
{
    /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b )
    {
	int[] finalArray = new int[a.length + b.length];
	int counter = 0;
	int aCounter = 0;
	int bCounter = 0; 
	while ( counter < finalArray.length ) {
	    if ( aCounter < a.length  && bCounter < b.length ) {
		if ( a[aCounter] < b[bCounter] ) {
		    finalArray[counter] = a[aCounter];
		    counter += 1;
		    aCounter += 1; 		    
		}
		else {
		    finalArray[counter] = b[bCounter];
		    counter += 1;
		    bCounter += 1;
		}
	    } 
	    else {
		if ( aCounter < a.length ) {
		    finalArray[counter] = a[aCounter];
		    counter += 1;
		    aCounter += 1;
		}
		else if ( bCounter < b.length ) {
		    finalArray[counter] = b[bCounter];
		    counter +=1;
		    bCounter += 1;
		}
	    }
	    
	}
	return finalArray;
	
    }//end merge()


    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr )
    {
        if ( arr.length == 1 ) {
	    return arr;
	}
	else {
	    int[] a = new int[arr.length / 2];
	    int[] b = new int[arr.length - a.length];
	    for ( int i = 0; i < arr.length; i++ ) {
		if ( i < a.length ) {
		    a[i] = arr[i];
		}
		else {
		    b[i - a.length] = arr[i];
		}
	    }
	    return merge( sort(a), sort(b));  
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array.
    // It just changes all the elements to 0...
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	/*~~~~~~~~~~~~~ No Thanks ~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) ); // [0,1,]

	System.out.println("\nMerging arr3 and arr4: ");
	printArray( merge(arr3,arr4) ); // [1,2,3,3,4,4,]

	  System.out.println("\nSorting arr4-7...");
	  printArray( sort( arr4 ) );
	  printArray( sort( arr5 ) );
	  printArray( sort( arr6 ) );
	  printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
