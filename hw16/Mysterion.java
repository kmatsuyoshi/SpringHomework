//Kayli Matsuyoshi
//APCS2 pd1
//HW16 -- About Face
//2018-03-08r

/***************************************
 * class Mysterion
 * Function Name: "strangeSort"
 * Runner Up: "theScrombulator"
 * Big Oh Runtime: O(n), simply because there is just a for loop,  which makes n comparisons. 
 * Function: Given an array, it sorts it starting from index a, and ends th soring at index b, keeping track of the index of the number it makes comparisons to, c. The function separates the values such that all the values smaller than that initially at array[c] will be to the value's left and dight for larger values. Therefore a could be called "lowerBound", b can be called "upperBound" and c is the "pivotPoint".
 ***************************************/

public class Mysterion {
    
    // ~~~~~~~~ INSTANCE VARIABLES  ~~~~~~~~~~

    private static int[] array;
    
    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~

    //helper method for displaying an array
    public static void printArray( int[] array ) {
	System.out.print("[");
	for( int i = 0; i < array.length - 1; i++ )
	    System.out.print( array[i] + ",");
	System.out.println( array[(array.length - 1)] + "]");
    }

    //swap method 
    public static void swap( int[] array, int pos1, int pos2 ) {
	int x = array[pos1];
	int y = array[pos2];
	array[pos1] = y;
	array[pos2] = x;
    }

    //THE MYSTERIOUS FUNCTION
    public static int mysterion( int[] array, int a, int b, int c ) {
	int v = array[c];
	swap( array, c, b);
	int s = a;
	for( int i = a; i < b-1; i++  ) {
	    if ( array[i] < v ) {
		swap( array, s, i );
		s += 1;
	    }
	}
	swap( array, b, s );
	return s;
    }
    
    // ~~~~~~~~~~~~ MAIN METHOD ~~~~~~~~~~~~~~

    public static void main( String args[] ) {

	// Magical Number Array
	int[] magicals = { 7, 1, 5, 12, 3 };
	System.out.println( "THE MAGICAL NUMBERS: " );
        printArray( magicals );
	// The Magical Numbers Test
	System.out.println( "..Testing Magical Numbers..");
        System.out.println( mysterion( magicals, 0, 4, 2 ) );	
	printArray( magicals );
	// In ascending order
	System.out.println( "..In Ascending Order..");
	int[] magicalA = { 1, 3, 5, 7, 12 };
	printArray( magicalA );
	System.out.println( "..Testing..");
	System.out.println( mysterion( magicalA, 0, 4, 2 ) );
	printArray( magicalA );
	// In decending order
	System.out.println( "..In Decending Order..");
	int[] magicalD = { 12, 7, 5, 3, 1 };
	printArray( magicalD );
	System.out.println( "..Testing..");
	System.out.println( mysterion( magicalD, 0, 4, 2 ) );
	printArray( magicalD );
	// Different Input Values
	System.out.println( "..Different 'a' Value..");
	int[] magicalZoo = { 7, 1, 5, 12, 3 };
	printArray( magicalZoo );
	System.out.println( "..Testing..");
	System.out.println( mysterion( magicalZoo, 1, 4, 2 ) );
	printArray( magicalZoo );
	System.out.println( "..Different 'b' Value..");
	int[] magicalWee = { 7, 1, 5, 12, 3 };
	printArray( magicalWee );
	System.out.println( "..Testing..");
	System.out.println( mysterion( magicalWee, 0, 1, 2 ) );
	printArray( magicalWee );
	System.out.println( "..Different 'c' Value..");
	int[] magicalMama = { 7, 1, 5, 12, 3 };
	printArray( magicalMama );
	System.out.println( "..Testing..");
	System.out.println( mysterion( magicalMama, 0, 1, 2 ) );
	printArray( magicalMama );
    }

}
