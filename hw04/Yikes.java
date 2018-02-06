// Kayli Matsuyoshi
// APCS2 pd1
// HW04 - yikes
// 2018-02-06t

import java.util.Arrays;
public class Yikes {

    public static int[] arrayMerger( int[] array1, int[] array2 ){
	
	int[] finalArray = new int[array1.length + array2.length];
	int counter = 0;
	while ( counter < finalArray.length ) {
	    if ( array1.length > 1  && array2.length > 1 ) {
		if ( array1[0] < array2[0] ) {
		    finalArray[0] = array1[0];
		    // remove array1[0] from array1
		    array1 = Arrays.copyOfRange( array1, 1, (array1.length - 1) );
		    counter += 1;
		    
		}
		else {
		    finalArray[0] = array2[0];
		    array2 = Arrays.copyOfRange( array2, 1, (array2.length - 1) );
		    counter += 1;
		}
	    }
	    else {
		if ( array1.length > 1 ) {
		    //add elements of array2 to finalArray
		    counter += array1.length;
		}
		else {
		    //add elements of array1 to finalArray\
		    counter += array2.length;
		}
	    }
	    
	}
	return finalArray;
	
    }

    /*

    public static int[] mergeSort( int[] array ) {

	
    }

    */

      
    public static void main( String[] args ) {

	int[] testArray1 = { 1, 3, 6, 7 };
	int[] testArray2 = { 2, 4, 5, 8 };

	System.out.println(arrayMerger( testArray1, testArray2 ));
    }

}
