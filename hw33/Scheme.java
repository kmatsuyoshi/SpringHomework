// Kayli Matsuyoshi
// APCS2 pd1
// HW33 -- What a Racket 
// 2018-04-13f

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Eliminate white space
 *   2. Put each character string into a stack, I did left to right but this is wrong... 
 *   3. Recursively solve each expression in parentheses
 *   4. Alter variable answer according to the operands
 *   5. Return the unloaded full expression
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
 ******************************************************/

public class Scheme
{
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
    public static String evaluate( String expr ) 
    {
	String[] yikes = expr.split("\\s");
	ALStack<String> stack = new ALStack<String>(yikes.length);
	for ( int i = yikes.length-1 ; i >= 2 ; i-- ) {
	    String temp = yikes[i]; System.out.println(yikes[i]);
	    stack.push( temp );
	}
	int magicNumber = 0;
	if ( yikes[1].equals("+") ) {
	    magicNumber = 1;
	}
	else if ( yikes[1].equals("-") ) {
	    magicNumber = 2;
	}
	else if ( yikes[1].equals("*") ) {
	    magicNumber = 3;
	}
	return unload( magicNumber, stack);
     }//end evaluate()


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	String temp = numbers.pop();
	System.out.println(temp);
	int answer = Integer.parseInt( temp );
	if ( temp.equals(")") ){
	    numbers.pop();
	    if ( !numbers.isEmpty() ) {
		temp = numbers.pop();
	    }
	}
	if ( isNumber( temp ) ) {
	    if ( op == 1 ) {
		answer += Integer.parseInt( temp );
	    }
	    else if ( op == 2 ) {
		answer -= Integer.parseInt( temp );
	    }
	    else if ( op == 3 ) {
		answer *= Integer.parseInt( temp );
	    }
	}
	if ( temp.equals("(") ) {
	    if ( numbers.peek().equals("+") ) {
		numbers.pop();
	        numbers.push( unload( 1, numbers ));
	    }
	    else if ( numbers.peek().equals("-") ) {
		numbers.pop();
	        numbers.push( unload( 2, numbers ));
	    }
	    else if ( numbers.peek().equals("*") ) {
		numbers.pop();
		numbers.push( unload( 3, numbers ));
	    }
	}
	return Integer.toString( answer );
    }//end unload()


  
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
	try {
	    Integer.parseInt(s);
	    return true;
	}
	catch( NumberFormatException e ) {
	    return false;
	}
    }
  


  //main method for testing
  public static void main( String[] args )
  {

      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
