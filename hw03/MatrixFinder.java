// Team Cookie (Kevin Lin, Victor Lin, Kayli Matsuyoshi)
// APCS2 pd1
// HW03 -- Searching in a 2D Array
// 2018-02-02f

/* SUMMARY
   In our method we decided to compare the target value to the value at the indices, starting with the value at the upper right-hand corner, array[0][n-1]. We are starting from this value because it is the first pivotal point of comparison, meaning that it is the largest value in its own row, but the smallest value in its own row. Anything to the left of it will be less than it, and anything greater than it will be below it. 
   By using a while loop, we are able to make repetitive comparisons depending on if the value at the index is equal to the target. The while loop returns (-1,-1) if no matches are made, and returns the coordinates once the target is found.
*/

public class MatrixFinder {
    
    public static String searcher( int[][] array, int target ) {

	String returnString = "";
	int n = array[0].length;
	int row = 0;
	int col = n - 1;

	if ( target < array[0][0] || target > array[n-1][n-1] ) {

	    returnString = "(-1, -1)";

	}

	else {

	    while ( row < n && row >= 0 && col < n && col >= 0 ) {

		if ( target == array[row][col] ) {

		    returnString = "(" + row + ", " + col + ")";
		    break;

		}

		else {

		    if ( target > array[row][col] ) {

			row += 1;
			
		    }

		    else {

			col -= 1;

		    }

		}

	    }
	    
	}

	return returnString;

    } // end of searcher

    public static void main( String[] args ) {

	int n = 4;
	
        int[][] _matrix = new int[n][n];
	int i = 1;
	for ( int x = 0; x < n; x++ ) {
	    for ( int y = 0; y < n; y++ ) {
		_matrix[x][y] = i * 2;
		i += 1;
	    }
	}

	System.out.println( searcher( _matrix, 18 ));

    }

} // end of class MatrixFinder
