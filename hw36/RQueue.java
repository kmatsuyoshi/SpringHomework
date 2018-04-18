// ScrombleYoms ( James Huang and Kayli Matsuyoshi )
// APCS2 pd1
// HW36 --
// 2018-04-18w

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/

public class RQueue<T> implements Queue<T>
{
    //instance variables
    private LLNode<T> _front, _end, _traverse;
    private int _size,_tracker;

    // default constructor creates an empty queue
    public RQueue() {
	_size = 0;
    }//end default constructor

    public boolean isEmpty()
    {
	return _size == 0;
    } //O(1)

    public void enqueue( T enQVal ) {
	LLNode<T> endNode = new LLNode( enQVal, null );
	if ( _size == 0 ) {
	    _front = endNode;
	    _end = endNode;
	}
	else {
	    LLNode<T> tempNode = _end;
	    tempNode.setNext( endNode );
	    _end = endNode;
	}
	_size += 1;
    }//end enqueue()

    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() {
	T ret=peekFront();//preserves queue position and which one we will take out from the peek fxn
  LLNode<T> pointer=_front;
	LLNode<T> removedNode = _traverse;
	//T removed = removedNode.getValue();
  for(int i=0; i<_tracker-1; i++) {
    pointer=pointer.getNext();
  }
  pointer.setNext(removedNode.getNext());
	_size -= 1;
	return ret;
    }//end dequeue()

    public T peekFront() {
      sample();
	LLNode<T> frontNode = _traverse;
	T returned = frontNode.getValue();
	return returned;
    }

    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     *  1. Generate random int less than _size
     *  2. Iterate up to that position, retting the _traverse to that position
     4. keep track of the position of the element before the _traverse9we will need that to "splice " the hole left by removing random items from the Queue
     5. excecute dequque
     ******************************************/
    public void sample()
    {

	LLNode<T> currentNode = _front;//start at the front of the list
	int randomNumber = (int) (Math.random() * _size);
  _tracker=0;//tracks loc of thing before thing to remove

  //iterate through the list,using end as the traverser
	for ( int i = 0; i < randomNumber; i++ ) {
	    currentNode = currentNode.getNext();//goes to next one
      _tracker++;//moves tracker
	   // System.out.println( "**" + (String) _end.getValue() );
	}
  _traverse=currentNode;

    }//end sample()    // print each node, separated by spaces

    public String toString()
    {
	String retStr = "front->";
	LLNode<T> temp = _front; //init tr
	while( temp != null ) {
	    retStr += (String) temp.getValue() + "->";
	    temp = temp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }//end toString()

    //main method for testing
    public static void main( String[] args )
    {
	  RQueue PirateQueue = new RQueue();

	  System.out.println("\nnow enqueuing...");
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  // front->end->null
	  System.out.println("\nnow testing toString()...");
	  System.out.println( PirateQueue ); //for testing toString()...
    //testing sample's ability to choose random elemend
    System.out.println("\nnow sampling...");
    PirateQueue.sample();
	  System.out.println("\nnow dequeuing...");
	  System.out.println( PirateQueue.dequeue() );
    System.out.println("\nnow testing toString()...");
	  System.out.println( PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
    System.out.println("\nnow testing toString()...");
	  System.out.println( PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
    System.out.println("\nnow testing toString()...");
	  System.out.println( PirateQueue );
	  System.out.println( PirateQueue.dequeue() );

	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  System.out.println("\nnow dequeuing fr empty queue...");
	  System.out.println( PirateQueue.dequeue() );
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class RQueue
