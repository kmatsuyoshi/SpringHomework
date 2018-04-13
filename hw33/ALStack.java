// Kayli Matsuyoshi
// APCS2 pd1
// HW32 -- Leon Leonwood Stack
// 2018-04-12r

/*****************************************************
 * class ALStack<PANCAKE>
 * Uses built-in ArrayList Java Class
 *****************************************************/
import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

    // INSTANCE VARIABLES
    public ArrayList<PANCAKE> _stack;
    public int _stackSize;
    
    // CONSTRUCTOR
    public ALStack( int size ) {
        _stack = new ArrayList<PANCAKE>( size );
	_stackSize = 0;
    }

    // METHODS
    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty() {
	return _stackSize == 0;
    }

    //Return top element of stack without popping it.
    public PANCAKE peek() {
	return _stack.get( _stack.size() - 1 );
    }

    //Pop and return top element of stack.
    public PANCAKE pop() {
	_stackSize--;
	return _stack.remove( _stack.size() - 1 );
    }

    //Push an element onto top of this stack.
    public void	push( PANCAKE x ) {
	_stack.add( _stackSize, x );
	_stackSize++;
    }
    
}//end class
