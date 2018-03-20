// Kayli Matsuyoshi
// APCS2 pd1
// HW21 - Rockin Through the Night
// 2018-03-20t

/*****************************************************
 * class LList
 *****************************************************/

public class LList 
{
    public LLNode head;

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
    
    //add node to list, containing input String as its data
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
	stuy.add("u");
	stuy.add("y");
	System.out.println( stuy );
	System.out.println( stuy.get(3)); // y
	System.out.println( stuy.get(1)); // t
	System.out.println( stuy.get(0)); // s
	System.out.println( stuy.set(2, "a" )); // u
	System.out.println( stuy );
	System.out.println( stuy.size() );
	
    } // end of main method

} //end of class LList
