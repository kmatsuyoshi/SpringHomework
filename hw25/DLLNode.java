// Kayli Matsuyoshi
// APCS2 pd1
// HW 24 -- On the DLL
// 2018-03-26m

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type T
 *****************************************************/

public class DLLNode<T> 
{
    // INSTANCE VARIABLES
    private T _cargo;    //cargo may only be of type T
    private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    // CONSTRUCTORS
    public DLLNode() {
	_cargo = null;
	_nextNode = null;
	_prevNode = null;
    }

    public DLLNode( T cargoString ) {
	this();
	_cargo = cargoString;
    }

    public DLLNode( T cargoString, DLLNode prev, DLLNode next ) {
	this();
	_cargo = cargoString;
	_prevNode = prev;
	_nextNode = next;
    }

    // ACCESSORS
    public T getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() { return _prevNode; }

    // MUTATORS
    public T setCargo( T newCargo ) {
        T foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    public DLLNode setPrev( DLLNode newPrev ) {
	DLLNode foo = getPrev();
	_prevNode = newPrev;
	return foo;
    }

    // override inherited toString
    public String toString() { return _cargo.toString(); }

    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...

	DLLNode zoo = new DLLNode("kayli");
	DLLNode mama = new DLLNode();
	DLLNode wee = new DLLNode( "wong", zoo, mama );
	System.out.println(zoo.setCargo( "johnny" ));
	System.out.println(mama.setCargo( "tong" ));
	System.out.println(mama.getCargo());
	System.out.println(zoo.setNext( wee ));
	System.out.println(wee.setNext( mama ));
	System.out.println(zoo.toString());
	System.out.println(wee.toString());
	
    }//end main


}//end class DLLNode
