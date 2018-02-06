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
	while ( counter < finalArray.length ) {
	    if ( a.length > 1  && b.length > 1 ) {
		if ( a[0] < b[0] ) {
		    finalArray[counter] = a[0];
		    // remove array1[0] from array1
		    a = Arrays.copyOfRange( a, 1, (a.length - 1) );
		    counter += 1;
		    printArray(finalArray);		    
		}
		else {
		    finalArray[counter] = b[0];
		    b = Arrays.copyOfRange( b, 1, (b.length - 1) );
		    counter += 1;
		    printArray(b);
		    printArray(finalArray);
		}
	    }
	    else {
		if ( a.length > 1 ) {
		    //add elements of array2 to finalArray
		    counter += a.length;
		    printArray(finalArray);
		}
		else {
		    //add elements of array1 to finalArray\
		    counter += b.length;
		    printArray(finalArray);
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
	return arr;
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
	printArray( merge(arr4,arr6) ); // [1,2,3,3,4,4,]
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~

	  System.out.println("\nSorting arr4-7...");
	  printArray( sort( arr4 ) );
	  printArray( sort( arr5 ) );
	  printArray( sort( arr6 ) );
	  printArray( sort( arr7 ) );
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
