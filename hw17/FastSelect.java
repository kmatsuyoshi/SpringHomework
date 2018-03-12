//Kayli Matsuyoshi
//APCS2 pd1
//HW17 -- So So Fast
//2018-03-12m

/***************************************
 * class FastSelect
 * INCLUDES 
    - printArray
    - swap
    - theScrombulator
    - fastSelect ( see block comment below )
    - Main Method
 ***************************************/

public class FastSelect {

    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~

    // helper method for displaying an array
    public static void printArray( int[] array ) {
	System.out.print("[");
	for( int i = 0; i < array.length - 1; i++ )
	    System.out.print( array[i] + ",");
	System.out.println( array[(array.length - 1)] + "]");
    }

    // swap method 
    public static void swap( int[] array, int pos1, int pos2 ) {
	int x = array[pos1];
	int y = array[pos2];
	array[pos1] = y;
	array[pos2] = x;
    }

    /***************************************
     * Function Name: "theScrombulator"
     *** Big Oh Runtime: O(n), simply because there is just a for loop,  which makes n comparisons. 
     *** Function: Given an array, it sorts it starting from index a, and ends th soring at index b, keeping track of the index of the number it makes comparisons to, c. The function separates the values such that all the values smaller than that initially at array[c] will be to the value's left and right for larger values. Therefore a could be called "lowerBound", b can be called "upperBound" and c is the "pivotPoint".
     ***************************************/
    
    // THE SCROMBULATION FUNCTION
    public static int theScrombulator( int[] array, int lowerBound, int upperBound, int pivotPoint ) {
	int v = array[pivotPoint];
	swap( array, pivotPoint, upperBound); // move pivot value to the end
	int s = lowerBound;
	for( int i = lowerBound; i < upperBound -1; i++  ) {
	    if ( array[i] < v ) {
		swap( array, s, i );
		s += 1;
	    }
	}
	// move pivot to the final resting point
	swap( array, upperBound, s );
	return s;
    }

    /***************************************
 * Function name: fastSelect
 * FUNCTION
     - Uses theScrombulator method to rapidly find the yth smallest value in an array. In the fastSelector Method, "y" will be the parameter of of the value of the int compared to the others. 
     - Precondition: The method takes an array of ints and an integer representing the value being searched for.
     - Postcondition: The method will return the index of the yth smallest value in an array of ints. 
 * ALGORITHM
     1. Start with an array of ints (int[])  and value y (int).
     2. Recursion
          - If the array is one element, return that element
     3. Use theScrombulator to put a pivot element in its final resting position
     4. If that position is less than y by 1, it is the index of the yth smallest value and array[y] can be returned.
     5. If the position returned is greater than the one we're looking for, lessen the search area by decreasing the upperBound.
     6. If the position returned is less than y-1, then lessen the search area by increasing the lowerBound. 
 * Big Oh Runtime - O(nlogn)
   Best Case Scenario: O(n)
   Worst Case Scenario: O(nlogn) 
 ***************************************/

    public static int fastSelect( int[] array, int y, int lowerBound, int upperBound) {
	if ( array.length == 1 ) {
	    return array[0];
	}
        int pivot = 0;
	pivot = theScrombulator( array, lowerBound, upperBound, pivot);
	if ( pivot == y-1 ) {
	    return array[pivot];
	}
	else if ( pivot > y-1 ) {
	    return fastSelect( array, y, lowerBound, pivot-1 );
	}
	else {
	    return fastSelect( array, y, pivot+1, upperBound );
	}
    }

    // ~~~~~~~~~~~~ MAIN METHOD ~~~~~~~~~~~~~~

    public static void main( String args[] ) {

	// Magical Number Array
	int[] magicals = { 7, 1, 5, 12, 3 };
	System.out.println( "THE MAGICAL NUMBERS: " );
        printArray( magicals );
	/* -------- SEPARATOR ---------------
	// The Magical Numbers Test
	System.out.println( "..Testing Magical Numbers..");
        System.out.println( theScrombulator( magicals, 0, 4, 2 ) );	
	printArray( magicals );
	// In ascending order
	System.out.println( "..In Ascending Order..");
	int[] magicalA = { 1, 3, 5, 7, 12 };
	printArray( magicalA );
	System.out.println( "..Testing..");
	System.out.println( theScrombulator( magicalA, 0, 4, 2 ) );
	printArray( magicalA );
	// In decending order
	System.out.println( "..In Decending Order..");
	int[] magicalD = { 12, 7, 5, 3, 1 };
	printArray( magicalD );
	System.out.println( "..Testing..");
	System.out.println( theScrombulator( magicalD, 0, 4, 2 ) );
	printArray( magicalD );
	// Different Input Values
	System.out.println( "..Different 'a' Value..");
	int[] magicalZoo = { 7, 1, 5, 12, 3 };
	printArray( magicalZoo );
	System.out.println( "..Testing..");
	System.out.println( theScrombulator( magicalZoo, 1, 4, 2 ) );
	printArray( magicalZoo );
	System.out.println( "..Different 'b' Value..");
	int[] magicalWee = { 7, 1, 5, 12, 3 };
	printArray( magicalWee );
	System.out.println( "..Testing..");
	System.out.println( theScrombulator( magicalWee, 0, 1, 2 ) );
	printArray( magicalWee );
	System.out.println( "..Different 'c' Value..");
	int[] magicalMama = { 7, 1, 5, 12, 3 };
	printArray( magicalMama );
	System.out.println( "..Testing..");
	System.out.println( theScrombulator( magicalMama, 0, 1, 2 ) );
	printArray( magicalMama );
	----------------------------------- */

	// PART 2
	printArray( magicals );
	System.out.println( "4th smallest element: " );
	System.out.println( fastSelect( magicals, 4, 0, magicals.length-1 ));
	System.out.println( "2nd smallest element: " );
	System.out.println( fastSelect( magicals, 2, 0, magicals.length-1 ));

	/* 
	int[] theMildOnes = { 2, 9, 0, 15, 6, 24, 188 };
	System.out.println( "THE MILD ONES: " );
        printArray( theMildOnes );
        System.out.println( "5th smallest element: " );
	System.out.println( fastSelect( theMildOnes, 5, 0, theMildOnes.length-1 ));
	System.out.println( "3rd smallest element: " );
	System.out.println( fastSelect( theMildOnes, 3, 0, theMildOnes.length-1 ));
	*/
    }

} // end of class FastSelect
    
