// Kayli Matsuyoshi
// APCS2 pd1
// HW21 - 
// 2018-03-20t

/*****************************************************
 * class LList
 *****************************************************/

public class LList 
{
    private LLNode head;

    //add node to list, containing input String as its data
    public boolean add( String x ) {
	LLNode currentNode = head;
	while ( currentNode.getNext().getCargo() != null ) {
	    currentNode = currentNode.getNext();
	}
	currentNode.getNext() = new LLNode();
	currentNode = currentNode.getNext();
	currentNode.getNext().setCargo( null );
    }

    //return data in element at position i
    public String get( int i ) {
	LLNode currentNode = head;
	int counter = -1;
	while ( counter < i ) {
	    currentNode = currentNode.getNext();
	    counter += 1;
	}
	return currentNode.getCargo();
    }

    /*
    //overwrite data in element at position i
    public String set( int i, String x ); 

    //return length of list
    public int size();
    */
    public static void main( String args[] ) {

	LList stuy = new LList();
	stuy.add("s");
	stuy.add("t");
	stuy.add("u");
	stuy.add("y");
	stuy.get(3); // y
	stuy.get(1); // t
	stuy.get(0); // s

    } // end of main method

} //end of class LList
