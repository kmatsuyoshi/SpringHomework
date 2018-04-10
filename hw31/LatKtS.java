// Kayli Matsuyoshi
// APCS2 pd1
// HW31 -- Stack: What Is It Good For?
// 2018-04-10w

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/

public class LatKtS
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s )
    {
	String returnString = "";
	Latkes givenString  = new Latkes(s.length());
	for( int i = 0; i < s.length(); i++ ) {
	    givenString.push(s.substring(i,i+1));
	}
	for( int i = 0; i < s.length(); i++ ) {
	    returnString += givenString.pop();
	}
	return returnString;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s )
    {
	Latkes givenString  = new Latkes(s.length());
	for( int i = 0; i < s.length(); i++ ) {
	    String current = s.substring(i,i+1);
	    if ( current.equals("(") || current.equals("{") || current.equals("[") ) {
		givenString.push(current);
	    }
	    else {
		if ( givenString.isEmpty() ) {
		    return false;
		}
		String next = givenString.pop();
		if ( !((current.equals(")") && next.equals("("))
		       || (current.equals("]") && next.equals("["))
		       || (current.equals("}") && next.equals("{"))) ) {
		    return false;
		}
	    }
	}
	return givenString.isEmpty();
    }//end allMatched()


    //main method to test
    public static void main( String[] args )
    {
	  System.out.println(flip("stressed"));
	  System.out.println(allMatched( "({}[()])" )); //true
	  System.out.println(allMatched( "([)]" ) ); //false
	  System.out.println(allMatched( "(){([])}" ) ); //true
	  System.out.println(allMatched( "](){([])}" ) ); //false
	  System.out.println(allMatched( "(){([])}(" ) ); //false
	  System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
