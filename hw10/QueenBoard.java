`// Kayli Matsuyoshi
// APCS2 pd1
// HW10 -- Freddie Mercury, Brian May, Roger Taylor, John Deacon
// 2018-02-28w

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
    private int[][] _board;
    
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }

  
    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
        return solveH(0); // initializes the recursive process through tail recursion
    }
  
    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	if ( col == _board[0].length ) {
	    // print board
	    printSolution();
	    // maintain boolean returntype
	    return true;
	} // ends recursive process
	else {
	    for ( int row = 0; row < _board[0].length; row++ ) {
	        // introduces row as a useable variable
		if ( addQueen( row, col )) { //checks to see if adding a queen is possible
		    addQueen( row, col );
		    if ( solveH( col + 1 )) { // recursive call!
			return true;
		    }
		    else {
			removeQueen( row, col ); // removes the queen if conflict arises
		    }
		}
	    }
	}
	return false;
    }


    public void printSolution()
    {
        String board = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if ( _board[r][c] < 1 ) { // underscore for every negative number or 0, meaning no queens
		    board += "_" + "\t"; 
		}
		else { // for every location of a queen, a "Q" is shown
		    board += "Q" + "\t";
		}
	    }
	    board += "\n";
	}
        System.out.println( board ); // return type is void
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * <General description>
     * precondition: Matrix of numbers representing the amount of queens in each coordinate.
     * postcondition: Given a coordinate...
     * If the coordinate given is not in the range of the matrix, or if there is already a queen in that position, then it returns false.
     * A queen is added, but if its path intersects with another's, then the number in that spot will decrease by 1, and true will be returned.  
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: Matrix of numbers representing the amount of queens in each coordinate.
     * postcondition: Given a coordinate...
     * If the coordinate given is not in the range of the matrix, or if there is no queen in that position, then it returns false.
     * A queen is removed, but if a queen's path intersects with another's, then the number  at the coordinate increases by 1 and the function returns true.  
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: Matrix with values representing the presence of queens in each coordinate.
     * postcondition: Returns a visual representation of the matrix.
     */
    public String  toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	/* 
	QueenBoard b = new QueenBoard(5);
	System.out.println(b);
	// b.printSolution();
	b.addQueen(3,0);
	b.addQueen(0,1);
	System.out.println(b);
	// b.printSolution();
	b.removeQueen(3,0);
	System.out.println(b);
	// b.printSolution();
	*/
	
	// ----------------------------

	QueenBoard c = new QueenBoard(8);
	System.out.println( "-------- 8x8 Board -----------" );
	c.printSolution();
	System.out.println( "Testing Algo..." );
	c.solve();

	QueenBoard d = new QueenBoard(10);
	System.out.println( "-------- 10x10 Board -----------" );
	d.printSolution();
	System.out.println( "Testing Algo..." );
	d.solve();
    }
    
}//end class
