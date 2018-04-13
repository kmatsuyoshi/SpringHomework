/*****************************************************
 * class LLQueue
 * I'll figure it out later
 ******************************************************/

public class LLQueue<T> implements Queue<T> {

    // INSTANCE VARIABLES


    // CONSTRUCTOR(S)

    // METHODS
    
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue();

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x );

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty();

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront();
    //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

    // MAIN METHOD
    public static void main( String[] args ) {
	
    }

}
