// Kayli Matsuyoshi
// APCS2 pd1
// HW34 -- The English Do Not Wait In Line
// 2018-04-16m

/*****************************************************
 * class NodeQueue
 ******************************************************/

public class NodeQueue<Quasar> implements Queue<Quasar> {

    // ~~ INSTANCE VARIABLES ~~
    
    public LLNode<Quasar> _front;
    public LLNode<Quasar> _end;
    public int _size;

    // ~~~~ CONSTRUCTOR(S) ~~~~

    public NodeQueue( LLNode<Quasar> frontNode )
    {
	_front = _end = frontNode; // In order for the line to start, there needs to be at least one person standing in the line
	_size = 1;
    }

    public NodeQueue( LLNode<Quasar> frontNode, Quasar cargo )
    {
	_front = _end = frontNode; // In order for the line to start, there needs to be at least one person standing in the line
	frontNode.setValue( cargo );
	_size = 1;
    }
    
    // ~~~~~~~ METHODS ~~~~~~~~
    
    // means of removing an element from collection:
    // Dequeues and returns the first element of the queue.
    public Quasar dequeue() {
	LLNode<Quasar> frontNode = _front; 
	Quasar removed = frontNode.getValue();
	_front = frontNode.getNext();
	_size -= 1;
	return removed;
    }

    // means of adding an element to collection:
    // Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x ) {
        LLNode<Quasar> tempNode = _end;
	LLNode<Quasar> endNode = new LLNode( x, null );
	tempNode.setNext( endNode );
	_end = endNode;
	_size += 1;
    }

    // Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty() {
	return _size == 0;
    }

    // Returns the first element of the queue without dequeuing it.
    public Quasar peekFront() {
	LLNode<Quasar> frontNode = _front; 
	Quasar returned = frontNode.getValue();
	return returned;
    }

    // MAIN METHOD
    public static void main( String[] args ) {

	LLNode<String> first = new LLNode<String>( "oops", null );
	NodeQueue<String> line = new NodeQueue<String>( first );
	line.enqueue( "zoo" );
	line.enqueue( "wee" );
	line.enqueue( "mama" );
	System.out.println( line.dequeue() );
	System.out.println( line.isEmpty() );
	System.out.println( line.peekFront() );
        line.dequeue();
	System.out.println( line.dequeue() );
	System.out.println( line.dequeue() );
	System.out.println( line.isEmpty() );
	
    } // end of main method

} // end of class
