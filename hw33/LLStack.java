// Kayli Matsuyoshi
// APCS2 pd1
// HW32 -- Leon Leonwood Stack
// 2018-04-12r

/*****************************************************
 * class LLStack
 * Uses built-in LinkedList Java Class
 *****************************************************/
import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {

    // INSTANCE VARIABLES
    private LinkedList<PANCAKE> _stack;
    private int _stackSize;
    
    // CONSTRUCTOR
    public LLStack() {
	_stack = new LinkedList<PANCAKE>();
	_stackSize = 0;
    }

    //METHODS
    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty() {
	return _stackSize == 0;
    }

    //Return top element of stack without popping it.
    public PANCAKE peek() {
	return _stack.peekLast();
    }

    //Pop and return top element of stack.
    public PANCAKE pop() {
	_stackSize--;
	return _stack.pop();
    }

    //Push an element onto top of this stack.
    public void	push( PANCAKE x ) {
	_stack.add( x );
	_stackSize++;
    }

}//end class 
