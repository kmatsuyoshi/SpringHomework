// QueenBees ( Fiona Cai and Kayli Matsuyoshi )
// APCS2 pd1
// HW35 -- ...Nor Do Aussies
// 2018-04-18t

/*****************************************************
 * class ALQueue
 ******************************************************/
import java.util.ArrayList;

public class ALQueue<Quasar> implements Queue<Quasar> {

   // ~~ INSTANCE VARIABLES ~~
    
    private ArrayList<Quasar> _queue;

    // ~~~~ CONSTRUCTOR(S) ~~~~

    public ALQueue( int size )
    {
        _queue = new ArrayList( size );
    }
    
    // ~~~~~~~ METHODS ~~~~~~~~
    
    // means of removing an element from collection:
    // Dequeues and returns the first element of the queue.
    public Quasar dequeue() {
	Quasar removed = _queue.get( _queue.size() - 1 );
        _queue.remove( _queue.size() - 1 );
	return removed;
    }

    // means of adding an element to collection:
    // Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x ) {
	ArrayList temp = new ArrayList();
	temp.add( x );
	for( int i = 0; i < _queue.size(); i++ ) {
	    temp.add( _queue.get(i) );
	}
	_queue = temp;
    }

    // Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty() {
	return _queue.isEmpty();
    }

    // Returns the first element of the queue without dequeuing it.
    public Quasar peekFront() {
	return _queue.get( _queue.size() - 1 );
    }

    // MAIN METHOD
    public static void main( String[] args ) {

        ALQueue<String> line = new ALQueue(3);
	line.enqueue( "zoo" );
	line.enqueue( "wee" );
	line.enqueue( "mama" );
	System.out.println( line.dequeue() ); // zoo
	System.out.println( line.isEmpty() ); // false
	System.out.println( line.peekFront() ); // wee
	line.dequeue(); 
	System.out.println( line.dequeue() ); // mama
	System.out.println( line.isEmpty() ); // true
	
    } // end of main method

}//end interface Queue   
