// Kayli Matsuyoshi
// APCS2 pd1
// HW21 - 
// 2018-03-20t

/*****************************************************
 * interface List -- subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 * If placed in current working dir, will be consulted instead of 
 * built-in Java library interface.
 *****************************************************/

public interface List
{
    private Node head;

    //add node to list, containing input String as its data
    public boolean add( String x ) {
	Node currentNode = head;
	while ( current.nextNode != null ) {
	    currentNode = currentNode.nextNode;
	}
	currentNode.nextNode = new Node( x );
	currentNode = currentNode.nextNode;
	currentNode.nextNode = null;
    }

    //return data in element at position i
    public String get( int i ) {
	Node currentNode = head;
	int counter = -1;
	while ( counter < i ) {
	    currentNode = currentNode.nextNode;
	    counter += 1;
	}
	return currentNode.cargo;
    }

    //overwrite data in element at position i
    public String set( int i, String x ); 

    //return length of list
    public int size();

    public static void main( String args[] ) {

	List stuy = new List();
	stuy.add("s");
	stuy.add("t");
	stuy.add("u");
	stuy.add("y");
	stuy.get(3); // y
	stuy.get(1); // t
	stuy.get(0); // s
    }

}//end interface
