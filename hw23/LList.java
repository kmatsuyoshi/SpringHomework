// Kayli Matsuyoshi
// APCS2 pd1
// HW21 - Rockin Through the Night
// 2018-03-20t

// Kayli Matsuyoshi
// APCS2 pd1
// HW23 - 
// 2018-03-23f

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List
{
    // instance vars
    public LLNode head;
    public int size;

    // constructors
    public LList() {
        head = null;
	size = 0;
    }

    public LList( LLNode headNode ) {
	this();
	head = headNode;
	size = 1;
    }
    
    // new toString()
    public String toString() {
	String returnString = "";
	LLNode currentNode = head;
	while ( currentNode != null ) {
	    returnString += currentNode.toString();
	    currentNode = currentNode.getNext();
	}
	return returnString;
    }
    
    // add node to list, containing input String as its data
    // see hw22 for more robust code that adds the value to the beginning
    public boolean add( String x ) {
	if ( head == null ) {
	    LLNode headNode = new LLNode( x );
	    head = headNode;
	    return true;
	}
	LLNode currentNode = head;
	while ( currentNode.getNext() != null ) {
	    currentNode = currentNode.getNext();
	}
	LLNode newNode = new LLNode( x );
	currentNode.setNext( newNode ); 
	return true;
    }

    // add at position
    public boolean addPosition( String x, int position ) {
	if ( head == null ) {
	    LLNode headNode = new LLNode( x );
	    head = headNode;
	    return true;
	}
	LLNode currentNode = head;
        int counter = 0;
	while ( counter < position-1 ) {
	    currentNode = currentNode.getNext();
	    counter += 1;
	}
	LLNode newNode = new LLNode( x );
	LLNode tempNode = currentNode.getNext();
	currentNode.setNext( newNode );
	newNode.setNext( tempNode );
	return true;
    }

    // remove element at position
    public String remove( int position ) {
	LLNode currentNode = head;
	int counter = 0;
	while ( counter < position-1 ) {
	    currentNode = currentNode.getNext();
	    counter += 1;
	}
	LLNode oldNode = currentNode.getNext();
	currentNode.setNext( oldNode.getNext() );
	size -= 1;
	return oldNode.getCargo();
    }

    //return data in element at position i
    public String get( int i ) {
	LLNode currentNode = head;
	int counter = 0;
	while ( counter < i ) {
	    currentNode = currentNode.getNext();
	    counter += 1;
	}
	return currentNode.getCargo();
    }

    //overwrite data in element at position i
    public String set( int i, String x ) {
	LLNode currentNode = head;
	int counter = 0;
	while ( counter < i ) {
	    currentNode = currentNode.getNext();
	    counter += 1;
	}
	String oldCargo = currentNode.getCargo();
	currentNode.setCargo( x );
	return oldCargo;
    }
    
    //return length of list
    public int size() {
	LLNode currentNode = head;
	int counter = 0;
	while ( currentNode != null ) {
	    currentNode = currentNode.getNext();
	    counter += 1;
	}
	return counter;
    }

    // MAIN METHOD
    public static void main( String args[] ) {

	LList stuy = new LList();
	stuy.add("s");
	stuy.add("t");
	stuy.add("y");
	stuy.addPosition("u", 2);
	System.out.println( stuy );
	System.out.println( stuy.get(3)); // y
	System.out.println( stuy.get(1)); // t
	System.out.println( stuy.get(0)); // s
	System.out.println( stuy.set(2, "a" )); // u
	System.out.println( stuy );
	System.out.println( stuy.size() );
	System.out.println( stuy.remove(2)); //a
	System.out.println( stuy );
	System.out.println( stuy.size() );
	
    } // end of main method

} //end of class LList
