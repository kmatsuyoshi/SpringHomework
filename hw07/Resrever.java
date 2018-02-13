// Kayli Matsuyoshi
// APCS2 pd1
// HW07 -  
// 2018-02-14w

/*======================================
  class Resrever
  Reverses Strings
  ======================================*/

public class Resrever {

    // LINEAR RUNTIME: O(n)
    public static String linReverse( String input ) {

	String output = "";
	for ( int i = input.length(); i > 0 ; i-- ) {
	    output += input.substring( i-1, i );
	}
	return output;
	
    } 
    
    // O(log2n)
    /* STEPS
       1. Determine if odd or even
       2. Divide
       3. Swap
       4. Repeat 2 and 3 until 
     */
    public static String reverse( String input ) {

	if ( input.length() <= 1 ) {
	    return input;
	}
	else {
	    String a = input.substring( 0, input.length() / 2 );
	    String b = input.substring( input.length() / 2 , input.length());
	    return reverse(b) + reverse(a);
	}
	    
    }

    // MAIN METHOD
    public static void main( String args[] ) {

	System.out.println( "Testing O(n) runtime algorithm: " );
	System.out.println( linReverse("desserts") ); // stressed
	System.out.println( "Testing O(log2n) runtime algorithm: " );
	System.out.println( reverse("stressed") ); // desserts
	
    }
} // end of class Resrever
