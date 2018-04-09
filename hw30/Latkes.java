// Kayli Matsuyoshi
// APCS2 pd1
// HW30 -- No Clue
// 2018-04-10t

/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/

public class Latkes
{
    private String[] _stack;
    private int _stackSize;

    //constructor
    public Latkes( int size )
    {
	_stack = new String[size];
	_stackSize = 0;
    }

    //means of insertion
    public void push( String s )
    {
	if ( _stackSize < _stack.length ) {
	    _stack[_stackSize] = s;
	    _stackSize += 1;
	}
	else {
	    String[] _newStack = new String[_stack.length + 1];
	    for( int i = 0; i < _stack.length; i++ ) {
		_newStack[i] = _stack[i];
	    }
	    _stack = _newStack;
	    _stack[_stackSize] = s;
	    _stackSize += 1;
	}
    }

    //means of removal
    public String pop()
    {
	String removed = _stack[_stackSize-1];
        _stack[_stackSize-1] = null;
	_stackSize -= 1;
	return removed;
    }

    //chk for emptiness
    public boolean isEmpty()
    {
        if ( _stackSize == 0 ) {
	    return true;
	}
	return false;
    }

    //chk for fullness
    public boolean isFull()
    {
        if ( _stackSize == _stack.length ) {
	    return true;
	}
	return false;
    }

    public void print() {
	for( int i = _stack.length-1; i >= 0; i-- ) {
	    System.out.println( _stack[i] );
	}
	System.out.println( "---" );
    }

    //main method for testing
    public static void main( String[] args )
    {
	  Latkes tastyStack = new Latkes(10);

	  tastyStack.push("aoo");
	  tastyStack.push("boo");
	  tastyStack.push("coo");
	  tastyStack.push("doo");
	  tastyStack.push("eoo");
	  tastyStack.push("foo");
	  tastyStack.push("goo");
	  tastyStack.push("hoo");
	  tastyStack.push("ioo");
	  tastyStack.push("joo");
	  tastyStack.push("coocoo");
	  tastyStack.push("cachoo");

	  tastyStack.print();
	  
	  //cachoo
	  System.out.println( tastyStack.pop() );
	  //coocoo
	  System.out.println( tastyStack.pop() );
	  //joo
	  System.out.println( tastyStack.pop() );
	  //ioo
	  System.out.println( tastyStack.pop() );
	  //hoo
	  System.out.println( tastyStack.pop() );
	  //goo
	  System.out.println( tastyStack.pop() );
	  //foo
	  System.out.println( tastyStack.pop() );
	  //eoo
	  System.out.println( tastyStack.pop() );
	  //doo
	  System.out.println( tastyStack.pop() );
	  //coo
	  System.out.println( tastyStack.pop() );
	  //boo
	  System.out.println( tastyStack.pop() );
	  //aoo
	  System.out.println( tastyStack.pop() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

	  //stack empty by now; SOP(null)
	  System.out.println( tastyStack.pop() );
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main()

}//end class Latkes
