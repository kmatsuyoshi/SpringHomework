// Kayli Matsuyoshi
// APCS2 pd1
// HW51 -- Heaping Piles of Sordidness
// 2018-05-21m

/*****************************************************
 * class HeapSort
 * Implements HeapSort Algorithm
 *****************************************************/

import java.util.ArrayList;

public class HeapSort {
     
    // METHODS

    private static void heapify( ArrayList<Integer> heap, int start, int end ) {
	int bigg = start;
	int left = 2*start+1;
	int right = 2*start+2;
	// if the left child is the largest
	if ( left < end && heap.get(bigg) < heap.get(left) ) {
	    bigg = left;
	}
	// if the right child is the largest
	if ( right < end && heap.get(bigg) < heap.get(right) ) {
	    bigg = right;
	}
	// if the parent is no longer the largest
	if ( bigg != start ) {
	    swap( heap, bigg, start );
	    // fix affected subtree
	    heapify( heap, bigg, end );
	}
    }
    
    //swap for an ArrayList
    private static void swap( ArrayList<Integer> array, int pos1, int pos2 )
    {
        array.set( pos1, array.set( pos2, array.get(pos1) ) );
    }
    
    private static void sort( ArrayList<Integer> input ) {
	int upperbound = input.size();
	// heapifies the entire input arraylist
	for ( int i = upperbound / 2 - 1; i >= 0; i-- ) {
	    heapify( input, i, upperbound );
	}
	for (int i = upperbound - 1; i >= 0; i-- ) {
	    // puts each value to be sorted at the end
	    swap( input, 0, i );
	    heapify( input, 0, i );
	}
    }
    
    // MAIN METHOD
    
    public static void main( String[] args ) {

	System.out.println( "...INITIATING TESTING..." );
	
	ArrayList<Integer> test1 = new ArrayList<Integer>();
	int[] test1subjects = { 7, 1, 5, 12, 3 };
	for( int i = 0; i < test1subjects.length; i++ ) {
	    test1.add( test1subjects[i] );
	}
	System.out.println( "TEST 1 DATA:" );
	System.out.println( test1 );
	System.out.println( "SORTED DATA:" );
	sort(test1);
	System.out.println( test1 );

	ArrayList<Integer> test2 = new ArrayList<Integer>();
	int[] test2subjects = { 6, 3, 5, 7, 1, 8, 4, 2 };
	for( int i = 0; i < test2subjects.length; i++ ) {
	    test2.add( test2subjects[i] );
	}
	System.out.println( "TEST 2 DATA:" );
	System.out.println( test2 );
	System.out.println( "SORTED DATA:" );
	sort(test2);
	System.out.println( test2 );
	System.out.println( "Ms in my Bank Account" );


    } // end of main method

} // end of class HeapSort
